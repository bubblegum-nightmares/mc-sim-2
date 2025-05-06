package notmeow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Battol {
    public static Zomber zomber = new Zomber("zomber", 100, 5);
    public static int position = 1;

    public static void randomCreatureGenerator(ArrayList<Creechah> creechahsList) {
        Random randomNumber = new Random(); // this makes random number (duh)
        int creaturePickedInt = randomNumber.nextInt(2);

        // turns number into creature (so the message below doesnt display a number bc that would be stupid)
        switch (creaturePickedInt) {
            case 1:
                Creechah.type = zomber.getType();
                break;
        }

        fightInit();
    }

    public static void fightInit() {
        Fwame.meow.setText(Creechah.type + " approaches u. what do?");
        Fwame.continueButtonInvisible();
        position = 1; // this is for continue button, since its only one button computer needs to know what to display when its clicked at differnt points
        switch (Creechah.type) {
            case "zomber":
                if (Zomber.health <= 0) {
                    Fwame.meow.setText("you killed the zomber");
                }
        }
    }

    public static void continyoo() {
        if (Objects.equals(Creechah.type, "zomber") && position == 1) {
            Battol.zomber.attack();
            position = 2;
        } else if (position == 2) {
            fightInit();
        }
    }
} // battol class bracket

class buttonClicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Fwame.attackButton) {
            Player.attack();
        } else if (e.getSource() == Fwame.continueButton) {
            Battol.continyoo();
        } else if (e.getSource() == Fwame.runButton){
            Player.run();
        }
    }

} // button clicker class bracket
