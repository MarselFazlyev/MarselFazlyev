import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Student> studentsList = new HashSet<>();

        while (true) {
            int id;
            System.out.println("Введите данные  студента или звершите ввод через end:");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            List<String> parts = new ArrayList<>(Arrays.asList(input.split(",")));
            List<String> newParts = new ArrayList<>();

            for (String part : parts) {
                newParts.add(part.trim());
            }
            System.out.println(newParts);

            try {
                if (parts.size() >= 3) {
                    id = Integer.parseInt(parts.get(2));
                } else {
                    System.out.println("Введены не все значения!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите корректный ID!!");
                continue;
            }


            Student student = new Student(newParts.get(0), newParts.get(1), id);
            if (!studentsList.add(student)) {
                System.out.println("Данный студент уже есть в списке!");
            } else studentsList.add(student);
        }
        System.out.println("Итоговый список студентов:\n");
        for (Student student : studentsList) {
            System.out.println(student);
            System.out.println();
        }


    }
}
