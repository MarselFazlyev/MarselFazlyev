import weapons.*;

public class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[Main.SIZE];
        weaponSlots[0] = new Pistol();
        weaponSlots[1] = new Automat();
        weaponSlots[2] = new Gun();
        weaponSlots[3] = new Hammer();
        weaponSlots[4] = new Minigun();
    }


    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        if (slot < weaponSlots.length && slot >= 0) {
            Weapon weapon = weaponSlots[slot];
            weapon.shot();
        } else {
            System.out.println(" Вы ввели некорректный номер слота\n Повторите ввод");
        }

    }

}
