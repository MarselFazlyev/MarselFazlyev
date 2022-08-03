import java.util.Scanner;

class Main {

    public static boolean calculateVisokosnost(int finalYear, int finalDays) {
        if (finalYear % 400 == 0 || finalYear % 100 != 0 && finalYear % 4 == 0 && finalDays == 366) {
            return true;
        } else if (finalYear % 4 != 0 && finalDays == 365) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("Введите год в формате уууу :");
            String year = scanner.nextLine();
            if (year.equals("end")) {
                break;
            }
            int finalYear = Integer.parseInt(year);
            System.out.println("Введите количество дней в данном году :");
            String days = scanner.nextLine();
            if (days.equals("end")) {
                break;
            }
            int finalDays = Integer.parseInt(days);

            boolean a = calculateVisokosnost(finalYear, finalDays);
            if (a != true) {
                System.out.println("Неправильно!!!");
                break;
            }
            System.out.println("Правильно!!!");
            count++;

        }
        System.out.println("В сумме вы набрали " + count + " очков.");

    }
}
