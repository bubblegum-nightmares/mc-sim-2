package notmeow;

public class Weapon {
    protected static String type;
    protected static int damage;
    protected static int durability;

    public Weapon(String type, int damage, int durability) {
        this.type = type;
        this.damage = damage;
        this.durability = durability;
    }

    public void equip() {
        Fwame.meow.setText("Equipped " + this.type);
        Player.playerDamage = this.damage;
    }
}
