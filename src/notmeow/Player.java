package notmeow;

public class Player {
    private static int playerHP;
    static int playerDamage;
    private static int exp;
    static String weapon;

    public static void playerSetup() {
        playerHP = 100;
        playerDamage = 2;
        weapon = "grah";
        exp = 0;

        Fwame.playerHealthDisplay.setText("health: " + playerHP);
        Fwame.weaponDisplay.setText("weapon: " + weapon);
        Fwame.expDisplay.setText("exp: " + exp);
    }

    public static void attack() {
        Fwame.continueButtonVisible();
        Fwame.meow.setText("You attacked the " + Creechah.type + " for " + playerDamage + " damage.");
    }
}


