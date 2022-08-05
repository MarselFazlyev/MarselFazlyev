import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        List<Integer> numbers;
        logger.log("Запуск программы.");
        System.out.println("Приветствую, уважаемый пользователь!");
        while (true) {
            System.out.println("Введите два числа через пробел: Размер списка чисел и предел значений элементов списка");
            logger.log("Пользовательский ввод в консоль");
            try {
                String[] parts = scanner.nextLine().split(" ");
                int listSize = Integer.parseInt(parts[0]);
                numbers = new ArrayList<>(listSize);
                int valuesBound = Integer.parseInt(parts[1]);
                Random random = new Random();
                logger.log("Создание  и заполнение списка");
                for (int i = 0; i < listSize; i++) {
                    numbers.add(i, random.nextInt(valuesBound));
                }
                System.out.println("Введите  число для фильтрации списка");
                logger.log("Ввод числа для фильтрации");
                int f = Integer.parseInt(scanner.nextLine());
                logger.log("Создание объекта класса Filter");
                Filter filter = new Filter(f);
                logger.log("Применение метода filterOut и вывод на консоль результирующего списка");
                List<Integer> result = filter.filterOut(numbers);
                System.out.println(result);
                logger.log("Завершение работы программы");
                break;
            } catch (NumberFormatException e) {
                logger.log(" Осуществлен неправильный ввод параметров!");

            }

        }


    }
}
