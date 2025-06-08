package notmeow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static ArrayList<Creechah> creechahsList = new ArrayList<>();

    public static void main(String[] args) {

        Item rottenFlesh = new Item("Rotten Flesh");

        ArrayList<String> playerInv = new ArrayList<>();
        playerInv.add(rottenFlesh.toString());

        HashMap<Creechah, Item> creatureDrops = new HashMap<>();
        creatureDrops.put(Battol.zomber, rottenFlesh);

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

    public class creatureHandler {
        Map<String, Creechah> creatureMap = new HashMap();
    }
}