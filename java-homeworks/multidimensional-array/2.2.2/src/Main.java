
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

import static java.util.Arrays.deepToString;

public class Main {
    public static final int SIZE = 3;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] field = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
//                System.out.print(field[i][j]);
            }
//            System.out.println();
        }
        boolean isCrossTurn = true;

        while (true) {
            printField(field);
            System.out.println("Ходят " + (isCrossTurn ? "крестики" : "нолики") + "!!");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int r = Integer.parseInt(parts[0]) - 1;
            int c = Integer.parseInt(parts[1]) - 1;
            if (field[r][c] != EMPTY) {
                System.out.println("Сюда ходить нельзя!!!");
                continue;
            }
            field[r][c] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                System.out.println("Победили " + (isCrossTurn ? "крестики" : "нолики") + "!!");
                printField(field);
                break;

            } else {
                isCrossTurn = !isCrossTurn;
            }
        }

    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static boolean isWin(char[][] field, char player) {
        if (field[0][0] == player && field[0][1] == player && field[0][2] == player) {
            return true;
        }
        if (field[1][0] == player && field[1][1] == player && field[1][2] == player) {
            return true;
        }
        if (field[2][0] == player && field[2][1] == player && field[2][2] == player) {
            return true;
        }
        if (field[0][0] == player && field[1][0] == player && field[2][0] == player) {
            return true;
        }
        if (field[0][1] == player && field[1][1] == player && field[2][1] == player) {
            return true;
        }
        if (field[0][2] == player && field[1][2] == player && field[2][2] == player) {
            return true;
        }
        if (field[0][0] == player && field[1][1] == player && field[2][2] == player) {
            return true;
        }
        if (field[2][0] == player && field[1][1] == player && field[0][2] == player) {
            return true;
        }
        return false;
    }


}
