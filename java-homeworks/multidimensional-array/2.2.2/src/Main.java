public class Main {
    public static final int SIZE = 5;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        char[][] field = new char[SIZE][SIZE];
        char[][] changedMassive = new char[SIZE][SIZE];
        field[0][0] = ZERO;
        field[0][1] = ZERO;
        field[0][2] = ZERO;
        field[0][3] = EMPTY;
        field[0][4] = EMPTY;
        field[1][0] = CROSS;
        field[1][1] = CROSS;
        field[1][2] = CROSS;
        field[1][3] = CROSS;
        field[1][4] = CROSS;
        field[2][0] = CROSS;
        field[2][1] = ZERO;
        field[2][2] = CROSS;
        field[2][3] = ZERO;
        field[2][4] = CROSS;
        field[3][0] = ZERO;
        field[3][1] = ZERO;
        field[3][2] = EMPTY;
        field[3][3] = ZERO;
        field[3][4] = CROSS;
        field[4][0] = ZERO;
        field[4][1] = EMPTY;
        field[4][2] = ZERO;
        field[4][3] = CROSS;
        field[4][4] = CROSS;
        printField(field);
        if (isWin(field, CROSS, changedMassive)) {
            System.out.println("Победили крестики!!!");
        } else if (isWin(field, ZERO, changedMassive)) {
            System.out.println("Победили нолики!!!");
        } else {
            System.out.println("Никто не победил ..");
        }

        field[0][0] = CROSS;
        field[0][1] = ZERO;
        field[0][2] = EMPTY;
        field[0][3] = EMPTY;
        field[0][4] = EMPTY;
        field[1][0] = EMPTY;
        field[1][1] = CROSS;
        field[1][2] = ZERO;
        field[1][3] = EMPTY;
        field[1][4] = EMPTY;
        field[2][0] = CROSS;
        field[2][1] = EMPTY;
        field[2][2] = CROSS;
        field[2][3] = ZERO;
        field[2][4] = EMPTY;
        field[3][0] = ZERO;
        field[3][1] = ZERO;
        field[3][2] = EMPTY;
        field[3][3] = CROSS;
        field[3][4] = EMPTY;
        field[4][0] = ZERO;
        field[4][1] = EMPTY;
        field[4][2] = EMPTY;
        field[4][3] = CROSS;
        field[4][4] = CROSS;
        printField(field);

        if (isWin(field, CROSS, changedMassive)) {
            System.out.println("Победили крестики!!!");
        } else if (isWin(field, ZERO, changedMassive)) {
            System.out.println("Победили нолики!!!");
        } else {
            System.out.println("Никто не победил ..");
        }

        field[0][0] = ZERO;
        field[0][1] = ZERO;
        field[0][2] = ZERO;
        field[0][3] = ZERO;
        field[0][4] = ZERO;
        field[1][0] = CROSS;
        field[1][1] = CROSS;
        field[1][2] = CROSS;
        field[1][3] = EMPTY;
        field[1][4] = EMPTY;
        field[2][0] = CROSS;
        field[2][1] = EMPTY;
        field[2][2] = CROSS;
        field[2][3] = CROSS;
        field[2][4] = CROSS;
        field[3][0] = ZERO;
        field[3][1] = EMPTY;
        field[3][2] = EMPTY;
        field[3][3] = EMPTY;
        field[3][4] = CROSS;
        field[4][0] = ZERO;
        field[4][1] = EMPTY;
        field[4][2] = EMPTY;
        field[4][3] = EMPTY;
        field[4][4] = EMPTY;
        printField(field);

        if (isWin(field, CROSS, changedMassive)) {
            System.out.println("Победили крестики!!!");
        } else if (isWin(field, ZERO, changedMassive)) {
            System.out.println("Победили нолики!!!");
        } else {
            System.out.println("Никто не победил ..");
        }

        field[0][0] = CROSS;
        field[0][1] = ZERO;
        field[0][2] = CROSS;
        field[0][3] = ZERO;
        field[0][4] = CROSS;
        field[1][0] = ZERO;
        field[1][1] = CROSS;
        field[1][2] = ZERO;
        field[1][3] = CROSS;
        field[1][4] = ZERO;
        field[2][0] = EMPTY;
        field[2][1] = EMPTY;
        field[2][2] = CROSS;
        field[2][3] = EMPTY;
        field[2][4] = EMPTY;
        field[3][0] = EMPTY;
        field[3][1] = EMPTY;
        field[3][2] = EMPTY;
        field[3][3] = EMPTY;
        field[3][4] = EMPTY;
        field[4][0] = EMPTY;
        field[4][1] = EMPTY;
        field[4][2] = EMPTY;
        field[4][3] = EMPTY;
        field[4][4] = EMPTY;
        printField(field);


        if (isWin(field, CROSS, changedMassive)) {
            System.out.println("Победили крестики!!!");
        } else if (isWin(field, ZERO, changedMassive)) {
            System.out.println("Победили нолики!!!");
        } else {
            System.out.println("Никто не победил ..");
        }


    }


    public static boolean isWin(char[][] field, char player, char[][] changedMassive) {
        int k = 0;
        int countDiagonal1 = 0;
        int countDiagonal2 = 0;

        for (int row = 0; row < SIZE; row++) {
            int countHorizontal = 0;
            int countVertikal = 0;
            for (int cell = 0; cell < SIZE; cell++) {
                changedMassive[row][cell] = field[cell][k];
                if (field[row][cell] == player) {
                    countHorizontal++;
                }
                if (changedMassive[row][cell] == player) {
                    countVertikal++;
                }
                if (countHorizontal == SIZE || countVertikal == SIZE) {
                    return true;
                }
            }
            k++;
        }

        for (int i = 0; i < SIZE; i++) {
            changedMassive[0][i] = field[i][i];
            changedMassive[1][i] = field[SIZE - 1 - i][i];
            if (changedMassive[0][i] == player) {
                countDiagonal1++;
            } else if (changedMassive[1][i] == player) {
                countDiagonal2++;
            }
        }
        if (countDiagonal1 == SIZE || countDiagonal2 == SIZE) {
            return true;
        }
        return false;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}