import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floor;
        Queue<Integer> algoritm = new LinkedList<>();
        while (true) {
            System.out.println(" Введите этаж от 0 до 25 :");
            try {
                floor = scanner.nextInt(); //почему не считывает консоль при срабатывании catch (InputMismatchException),
                // а зацикливается на бесконечность???
//                floor = Integer.parseInt(scanner.nextLine());
                if (floor < 0 || floor > 25) {
                    continue;
                } else if (floor == 0) {
                    for (int f : algoritm) {
                        System.out.print(f + "-->");
                    }
                    algoritm.offer(floor);
                    System.out.println(floor);
                    break;
                }
                algoritm.offer(floor);
            } catch (InputMismatchException e) {
                System.out.println(" НЕПРАВИЛЬНЫЙ ВВОД ЗНАЧЕНИЯ!!");
                System.out.println();
                scanner.next();
            }
////            catch (NumberFormatException e) {  нормально ловит ошибку и не зацикливается, если считывать nextLine-ом
//              System.out.println(" НЕПРАВИЛЬНЫЙ ВВОД ЗНАЧЕНИЯ!!");
//              System.out.println();
//            }
        }
        int openingDoors = 10;
        int goToNextFloor = 5;
        int previosFloor = 0;
        int totalTime = 0;
        for (int f : algoritm) {
            totalTime += openingDoors + goToNextFloor * (Math.abs(f - previosFloor));
            previosFloor = f;
        }
        totalTime -= 5; //подразумевается остановка лифта на 1 этаже в конце при вызове ноль.
        System.out.println(totalTime);
    }
}
