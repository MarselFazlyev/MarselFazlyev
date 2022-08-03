public class Summator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите первое значение: ");
        int value1 = scanner.nextInt();
        System.out.println("Введите второе значение: ");
        int value2 = scanner.nextInt();
        System.out.println("Введите третье значение: ");
        int value3 = scanner.nextInt();
        int summa = sumOfThreeValues(value1, value2, value3);
        System.out.println("Результат сложения: " + summa + "см");
    }

    public static int sumOfThreeValues(int value1, int value2, int value3) {
        return value1 + value2 + value3;
    }
}
