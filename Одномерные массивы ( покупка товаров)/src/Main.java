import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] products = {"Хлеб", "Соль", "Колбаса", "Вода"};
        int[] costs = {35, 20, 300, 75};
        int[] totalPositions = new int[4];
        int[] totalUnits = new int[4];

        while (true) {
            System.out.println("Прейскурант нашего магазина: ");
            for (int i = 0; i < products.length; i++) {
                System.out.println(products[i] + " " + costs[i] + " руб./шт");
            }
            System.out.println("");
            System.out.println("Введите номер продукта,и количество, либо завершите закупку товаров командой end:");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");
            int inputProduct = Integer.parseInt(parts[0]);
            int inputUnit = Integer.parseInt(parts[1]);
            totalPositions[inputProduct - 1] += inputUnit * costs[inputProduct - 1];
            System.out.println(Arrays.toString(totalPositions));
            totalUnits[inputProduct - 1] += inputUnit;
            System.out.println(Arrays.toString(totalUnits));
        }
        int sum = 0;
        for (int totalPosition : totalPositions) {
            sum += totalPosition;
        }
        System.out.println("Ваша корзина:  Наименование товара   Количество Цена/за ед.   Общая стоимость");
        for (int i = 0; i < products.length; i++) {
            if (totalUnits[i] != 0) {
                System.out.println(products[i] + " " + costs[i] + " руб/шт." + " Количество " + totalUnits[i] + "ед.  " + totalPositions[i] + "руб.");
            }
        }
        System.out.println("Итоговая стоимость всех Ваших покупок составила: " + "[" + sum + "] рублей.\nСпасибо за покупку!!!");

    }
}