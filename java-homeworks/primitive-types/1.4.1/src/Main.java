import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер  операции "
                    + "\n1. Сравнить"
                    + "\n2. Округлить"
                    + "\n3. Отбросить дробную часть"
                    + "\nВыберите и нажмите enter или введите 0 для завершения программы:");
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            switch (input) {
                case 1: {
                    System.out.println("Введите первое число");
                    double x = scanner.nextDouble();
                    System.out.println("Введите второе число");
                    float y = scanner.nextFloat();
                    System.out.println("Результат сравнения: " + compareNumbers(x, y));
                    break;
                }
                case 2: {
                    System.out.println("Введите число: ");
                    double z = scanner.nextDouble();
                    System.out.println("Результат округления:" + Math.round(z));
                    break;
                }
                case 3: {
                    System.out.println("Введите число: ");
                    double n = scanner.nextDouble();
                    long nn = (int) n;
                    System.out.println("Результат:" + nn);
                    break;
                }
            }
        }
    }

    public static String compareNumbers(double x, float y) {
        if (Math.abs(x - y) < 0.00001) {
            return "числа равны";
        } else if (x > y) {
            return "первое число больше второго";
        } else {
            return "первое число меньше второго";
        }
    }
}
