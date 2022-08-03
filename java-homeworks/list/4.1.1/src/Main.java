import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void showTasks(List<String> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();
        int input;
        boolean check = false;
        while (true) {
            if (check) break;
            System.out.println("Выберите действие:\n1.Добавить задачу\n2.Вывести список задач\n3.Удалить задачу\n0.Выход");
            try {
                String stringInput = scanner.nextLine();
                input = Integer.parseInt(stringInput);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректное значение!");
                continue;
            }
            switch (input) {
                case 1:
                    System.out.println("Введите задачу для планирования:");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    break;
                case 2:
                    showTasks(tasks);
                    break;
                case 3:
                    System.out.println(" Выберите номер задачи для удаления из списка.");
                    showTasks(tasks);
                    String stringRemoveNumber = scanner.nextLine();
                    int removeNumber = Integer.parseInt(stringRemoveNumber);
                    tasks.remove(removeNumber - 1);
                    System.out.println("Задача успешно удалена!");
                    System.out.println("Обновленный список");
                    showTasks(tasks);
                    break;
                case 0:
                    check = true;
            }
        }
        System.out.println("Программа завершена, всего доброго!");


    }
}
