import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год в формате *уууу*");
        int year = scanner.nextInt();
        if (year % 400 == 0) {
            System.out.println("В данном году 366 календарных дней");
        } else if (year % 100 == 0) {
            System.out.println("В данном году 365 календарных дней");
        } else if (year % 4 == 0) {
            System.out.println("В данном году 366 календарных дней");
        } else {
            System.out.println("В данном году 365 календарных дней");
        }
    }

}

