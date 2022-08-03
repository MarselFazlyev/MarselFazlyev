import java.util.Scanner;

class Main {
    public static double usnRevenueTaxSystem(int summOfRevenue) {
        return 0.06 * summOfRevenue;
    }

    public static double usnRevenueAndExpensesTaxSystem(int summOfRevenue, int summOfeExpenses) {
        double tax = (summOfRevenue - summOfeExpenses) * 0.15;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int summOfeExpenses = 0;
        int summOfRevenue = 0;
        while (true) {
            System.out.println("Выберите операцию и введите ее номер"
                    + "\n1 Добавить расход"
                    + "\n2 Добавить доход"
                    + "\n3 Выбрать систему налогообложения"
                    + "\n4 Набрать end для завершения команды");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Программа завершена");
                System.out.println("");
                break;
            }
            int intFromSystem = Integer.parseInt(input);
            switch (intFromSystem) {
                case 1:
                    System.out.println("Введите сумму расхода");
                    String e = scanner.nextLine();
                    int expenses = Integer.parseInt(e);
                    summOfeExpenses = summOfeExpenses + expenses;
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Введите сумму дохода");
                    String r = scanner.nextLine();
                    int revenue = Integer.parseInt(r);
                    summOfRevenue = summOfRevenue + revenue;
                    System.out.println("");
                    break;
                case 3:
                    double usnDohody = usnRevenueTaxSystem(summOfRevenue);
                    double usnDohodyMinusRashody = usnRevenueAndExpensesTaxSystem(summOfRevenue, summOfeExpenses);
                    if (usnDohody < usnDohodyMinusRashody) {
                        System.out.println("Мы советуем Вам УСН доходы");
                        System.out.println("Ваш налог составит" + usnDohody + "рублей");
                        System.out.println("Налог на другой системе " + usnDohodyMinusRashody + "рублей");
                        System.out.println("Экономия " + Math.abs(usnDohody - usnDohodyMinusRashody) + "рублей");
                        System.out.println("");
                    } else if (usnDohody == usnDohodyMinusRashody) {
                        System.out.println("В данном случае системы налогообложения равнозначны");
                    } else {
                        System.out.println("Мы советуем Вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит" + usnDohodyMinusRashody + "рублей");
                        System.out.println("Налог на другой системе " + usnDohody + "рублей");
                        System.out.println("Экономия " + Math.abs(usnDohodyMinusRashody - usnDohody) + "рублей");
                        System.out.println("");
                    }
                    break;
                default:
                    System.out.println("Недопустимая операция");
                    break;
            }


        }

    }
}
