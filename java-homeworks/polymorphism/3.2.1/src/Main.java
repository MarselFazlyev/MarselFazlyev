import java.util.Scanner;

public class Main {
    public static final int SIZE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.printf(" У игрока %d слотов с оружием, "
                + "введите номер от 0 до 4, чтобы выстрелить,"
                + "-1, чтобы выйти%n", player.getSlotsCount());
        int slot;
        while (true) {
            slot = scanner.nextInt();
            if (slot == -1) {
                System.out.println("Игра закончена!");
                break;
            } else {
                player.shotWithWeapon(slot);
            }
        }
    }
}
