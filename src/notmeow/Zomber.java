package notmeow;

public class Zomber extends Creechah {
    public Zomber(String type, int health, int damage) {
        this.type = type;
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void attack() {
        Fwame.meow.setText("zomber bites u for " + this.damage + " damage");
        Player.playerHP = Player.playerHP - this.damage;
        Fwame.playerHealthDisplay.setText("health: " + Player.playerHP);
    }

    @Override
    public void makeSound() {
        Fwame.meow.setText("zomber growls");
    }
}
