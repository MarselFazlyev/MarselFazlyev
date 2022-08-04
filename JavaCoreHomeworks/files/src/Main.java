import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class Main {
    private static final String separator = File.separator;
    private static final StringBuilder info = new StringBuilder();
    private static final LocalDateTime dateTime = LocalDateTime.now();

    public static void main(String[] args) throws IOException {
        Path pathGames = Paths.get("D:" + separator + "Марсель" + separator + "javaProjects" + separator +
                "Homework 1 (JavaCore Streams) Установка" + separator + "Games");
        Path dirgames = Files.createDirectory(pathGames);
//        System.out.println(dirgames.toFile().canRead());
//        System.out.println(dirgames.toFile().canWrite());
        if (dirgames.toFile().exists()) {
            info.append("Создана директория Games " + "\nДата создания: ").append(dateTime).append("\n").append("\n");
        }

        String[] namesOfDirGames = new String[]{"src", "res", "savegames", "temp"};
        String[] namesOfDirSrc = new String[]{"main", "test"};
        String[] namesOfDirRes = new String[]{"drawables", "vectors", "icons"};

        try {
            for (String name : namesOfDirGames) {
                createDirectoryWithLog(pathGames, name);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            for (String name : namesOfDirSrc) {
                createDirectoryWithLog(Paths.get("Games" + separator + "src"), name);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Path pathMain = Paths.get("Games" + separator + "src" + separator + "main" + separator + "Main.java");
        Path pathUtils = Paths.get("Games" + separator + "src" + separator + "main" + separator + "Utils.java");
        createFileWithLog(pathMain, "Main.java");
        createFileWithLog(pathUtils, "Utils.java");

        try {
            for (String name : namesOfDirRes) {
                createDirectoryWithLog(Paths.get("Games" + separator + "res"), name);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        Path pathTemp = Paths.get("Games" + separator + "temp" + separator + "temp.txt");
        try {
            createFileWithLog(pathTemp, "temp.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        GameProgress saving1 = new GameProgress(100, 2, 3, 40.5);
        GameProgress saving2 = new GameProgress(90, 4, 4, 101.6);
        GameProgress saving3 = new GameProgress(20, 1, 6, 260.78);
        List<GameProgress> savings = new ArrayList<>();
        savings.add(saving1);
        savings.add(saving2);
        savings.add(saving3);
        createSaving(savings, pathGames + separator + "savegames");

        Map<String, String> filesForZip = new HashMap<>();
        filesForZip.put("save1.dat", "D:" + separator + "Марсель" + separator + "javaProjects" + separator +
                "Homework 1 (JavaCore Streams) Установка" + separator + "Games" + separator + "savegames" + separator + "save1.dat");
        filesForZip.put("save2.dat", "D:" + separator + "Марсель" + separator + "javaProjects" + separator +
                "Homework 1 (JavaCore Streams) Установка" + separator + "Games" + separator + "savegames" + separator + "save2.dat");
        filesForZip.put("save3.dat", "D:" + separator + "Марсель" + separator + "javaProjects" + separator +
                "Homework 1 (JavaCore Streams) Установка" + separator + "Games" + separator + "savegames" + separator + "save3.dat");

        Path zipPath = Paths.get("D:" + separator + "Марсель" + separator + "javaProjects" + separator +
                "Homework 1 (JavaCore Streams) Установка" + separator + "Games" + separator + "savegames" + separator + "zip_out.zip");

        zipFiles(String.valueOf(zipPath), filesForZip);

        unzipFiles(zipPath);


        writeTempFile(info, pathTemp);

        Optional<GameProgress> a = loadingSaving(Paths.get(zipPath.getParent() + separator + "save3.dat"));
        GameProgress loadingSaving = null;
        if(a.isPresent()) {
            loadingSaving = a.get();
        }
        System.out.println(loadingSaving);


    }


    private static void createDirectoryWithLog(Path path, String name) throws IOException {
        Files.createDirectory(Paths.get(path.toString() + separator + name));
        info.append("Cоздана директория: ").append(name).append(" ").append("\nПуть: " + path).
                append("\nДата создания: ").append(dateTime).append("\n").append("\n");

    }

    private static void createFileWithLog(Path path, String name) throws IOException {
        Files.createFile(path);
        info.append("Создан файл: ").append(name).append(" ").append("\nПуть: " + path).
                append("\nДата создания: ").append(dateTime).append("\n").append("\n");
    }

    private static void createSaving(List<GameProgress> savings, String f) {
        for (int i = 0; i < savings.size(); i++) {
            try (FileOutputStream fos = new FileOutputStream((f + separator + "save" + (i + 1) + ".dat"));
                 ObjectOutputStream ous = new ObjectOutputStream(fos)) {
                ous.writeObject(savings.get(i));
                info.append("Cоздан обьект сохранения: save").append(i + 1).append(".dat").append(dateTime).append("\n");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        info.append("\n");

    }

    private static void zipFiles(String path, Map<String, String> filesForZip) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (Map.Entry<String, String> file : filesForZip.entrySet()) {
                FileInputStream fis = new FileInputStream(file.getValue());
                ZipEntry entry = new ZipEntry(file.getKey());
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                zout.write(buffer);
                zout.closeEntry();
                Files.delete(Paths.get(file.getValue())); // удаляются файлы вне архива
                info.append("\n").append("Файл ").append(file.getKey()).append(" добавлен в архив zip_out.zip").append("\nПуть: " + file.getValue()).
                        append("\nДата создания: ").append(dateTime).append("\n");
            }
            info.append("\n").append("Создан  архив: zip_out.zip ").append("\nПуть: " + path).append("\nДата создания: ").append(dateTime).append("\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void unzipFiles(Path zipPath) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipPath.toString()))) {
            ZipEntry entry;
            String name;
//            Long size;
            while ((entry = zis.getNextEntry()) != null) {
                name = entry.getName();
//              size = entry.getSize();
//                System.out.printf("File name: %s \t File size: %d \n", name, size);
                FileOutputStream fos = new FileOutputStream(zipPath.getParent() + separator + name);
                for (int i = zis.read(); i != -1; i = zis.read()) {
                    fos.write(i);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
                info.append("\n").append("Разархивирован файл: ").append(name).append("\nПуть: ").append(zipPath).append(name).
                        append("\nДата создания: ").append(dateTime).append("\n").append("\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeTempFile(StringBuilder info, Path pathToTemp) {
        try (FileWriter writer = new FileWriter(pathToTemp.toString())) {
            writer.write(info.toString());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(info);

    }

    private static Optional<GameProgress> loadingSaving(Path inputPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputPath.toString());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return Optional.ofNullable((GameProgress) ois.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }


    }


}


