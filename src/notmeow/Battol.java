package notmeow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Battol {
    public static void randomCreatureGenerator(ArrayList<Creechah> creechahsList) {
        Random randomNumber = new Random(); // this makes random number (duh)
        int creaturePickedInt = randomNumber.nextInt(1, 5);
        String creaturePickedString = "";

        // turns number into creature (so the message below doesnt display a number bc that would be stupid)
        switch (creaturePickedInt) {
            case 1: creaturePickedString = "zomber";
            break;
        }

        fightInit(creaturePickedString);
    }

    public static void fightInit(String creaturePickedString) {
        Fwame.meow.setText(creaturePickedString + " approaches u. what do?");
        switch(creaturePickedString) {
            case "zomber": fightZomber();
        }
    }

    public static void fightZomber() {
        Creechah.type = "zomber";
        Zomber zomber = new Zomber("Normal", 100, 5);
        if (Zomber.health <= 0) {
            Fwame.meow.setText("you killed the zomber");
        } else {

        }
    }
}

class buttonClicker implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Fwame.attackButton) {
            Player.attack();
            if (e.getSource() == Fwame.continueButton) {
                System.out.println("sobs loudly");
            }
        }
    }
}