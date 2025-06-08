package notmeow;

public class Player {
    protected static int playerHP;
    static int playerDamage;
    protected static int exp;
    static String weapon;

    public static void playerSetup() {
        playerHP = 100;
        playerDamage = 50;
        weapon = "grah";
        exp = 0;

        Fwame.playerHealthDisplay.setText("health: " + playerHP);
        Fwame.weaponDisplay.setText("weapon: " + weapon);
        Fwame.expDisplay.setText("exp: " + exp);
    }

    public static void attack() {
        Fwame.continueButtonVisible();
        Fwame.meow.setText("You attacked the " + Creechah.type + " for " + playerDamage + " \ndamage.");
        Creechah.health = Creechah.health - playerDamage;
        Fwame.mobHealthDisplay.setText("health: " + Creechah.health);
    }

    public static void run() {
        Fwame.continueButtonVisible();
        Fwame.meow.setText("You ran away!");
    }
}


