package notmeow;

public class Creechah {
    protected static String type;
    protected static int health;
    protected static int damage;
    protected static String name;

    public Creechah () {

    }

    public Creechah(String type, int health, int damage) {
        this.type = type;
        this.health = health;
        this.damage = damage;
        //this.name = name;
    }

    public void attack(){
        Fwame.meow.setText(this.type + " attacked u for " + this.damage + " damage");
    }

    public void makeSound(){
        Fwame.meow.setText("la creechura makes epic sound");
    }

    public String getType() {
        return type;
    }
}
