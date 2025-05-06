package notmeow;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Creechah> creechahsList = new ArrayList<>();

    public static void main(String[] args) {

        Weapon woodAxe = new Weapon("Wooden Axe", 5, 100);
        Weapon stoneAxe = new Weapon("Stone Axe", 10, 100);
        Weapon goldAxe = new Weapon("Golden Axe", 15, 100);
        Weapon diamondAxe = new Weapon("Diamond Axe", 20, 100);

        ArrayList<Weapon> weaponList = new ArrayList<>();
        weaponList.add(woodAxe);
        weaponList.add(stoneAxe);
        weaponList.add(goldAxe);
        weaponList.add(diamondAxe);

        new Fwame();
    }
}