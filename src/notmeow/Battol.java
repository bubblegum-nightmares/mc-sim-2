package notmeow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import java.util.Random;

public class Battol {
    public static String mobDrop = "";

    public static Zomber zomber = new Zomber("zomber", 100, 5);
    public static int position = 1; // chat is this real

    public static void randomCreatureGenerator() {
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

        switch (Creechah.type) {
            case "zomber":
                Fwame.mobDisplayLabel.setIcon(Fwame.zomberIcon);
                if (Zomber.health <= 0) {
                    position = 3;
                    Fwame.meow.setText("you killed the zomber");
                    Fwame.mobDropDisplay.setIcon(Fwame.rottenFleshIcon);
                    Fwame.mobDropDisplayVisible();
                    Fwame.continueButtonVisible();
                    mobDrop = "rotten flesh";
                } // if statement bracket
        } // switch bracket
    } // fightInit bracket

    // for clicking continue button
    // position 1 = creature is attacking you
    // position 2 = you are attacking creature
    // position 3 = creature is dead
    // position 4 = you are now viewing the item dropped by the creature
    public static void continyoo() {
        if (Objects.equals(Creechah.type, "zomber") && position == 1) { // if creature is a zomber and position is 1
            Battol.zomber.attack();
            position = 2;
        } else if (position == 2) {
            if (Player.playerHP <= 0) {
                Fwame.meow.setText("your died :(");
                Fwame.continueButton.setVisible(false);
                Fwame.respawnButton.setVisible(true);
            } else {
                fightInit();
            }
        } else if (position == 3) {
              Fwame.meow.setText("it dropped a item. click it to pick it \nup. \nclick continue button to leave it");
              position = 4;
        } else if (position == 4) {
            randomCreatureGenerator();
        }
    } // continyoo bracket
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
        else if (e.getSource() == Fwame.respawnButton) {
            Fwame.respawnButton.setVisible(false);
            Fwame.meow.setText("your alive");
            Battol.fightInit();
        }
    }

} // button clicker class bracket

class itemClicker implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Battol.mobDrop) {
            case "rotten flesh":
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
