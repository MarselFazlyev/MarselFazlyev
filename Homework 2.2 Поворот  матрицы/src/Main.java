
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int filedSize;
    public static Scanner scanner = new Scanner(System.in);

    public static void printMatrix(int[][] matrixForPrint) {
        for (int i = 0; i < filedSize; i++) {
            for (int j = 0; j < filedSize; j++) {
                System.out.format("%4d", matrixForPrint[i][j]);
            }
            System.out.println();
        }
    }


    public static int[][] turnMatrix(int[][] colors) {
        int[][] rotatedColors = new int[filedSize][filedSize];

        for (int i = 0; i < filedSize; i++) {
            int k = 0;
            for (int j = 0; j < filedSize; j++) {
                k++;
                rotatedColors[i][j] = colors[filedSize - k][i];
            }
        }
        return rotatedColors;
    }

    public static void main(String[] args) {
        int SIZE = 5;
        filedSize = SIZE;
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
            System.out.println();
        }
        System.out.println("Ваша исходная матрица :");
        printMatrix(colors);
        System.out.println();
        System.out.println("Выберите угол поворота матрицы: \n1. 90гр.\n2. 180гр.\n3. 270гр.");
        String stringInput = scanner.nextLine();
        int input = Integer.parseInt(stringInput);
        switch (input) {
            case 1: {
                turnMatrix(colors);
                printMatrix(turnMatrix(colors));
                break;
            }
            case 2: {
                turnMatrix(turnMatrix(colors));
                printMatrix(turnMatrix(turnMatrix(colors)));
                break;
            }
            case 3: {
                turnMatrix(turnMatrix(turnMatrix(colors)));
                printMatrix(turnMatrix(turnMatrix(turnMatrix(colors))));
                break;
            }
            default: {
                System.out.println("Некорректный ввод");

            }
        }


    }
}
