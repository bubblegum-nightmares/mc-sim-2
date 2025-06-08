package notmeow;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fwame extends JFrame {

    static JTextArea meow;

    Font minecraftRegular;

    static JPanel sidebarPanel, gamePanel, bottomPanel;
    static JPanel textPanel, buttonPanel, statsPanel, inventoryPanel, mobDisplayPanel, mobHealthPanel;

    static JLabel weaponDisplay, expDisplay, playerHealthDisplay, inventoryTitleDisplay, mobHealthDisplay, mobDisplayLabel, mobDropDisplay;

    public static JButton attackButton, runButton, continueButton, respawnButton;

    static ImageIcon zomberIcon, rottenFleshIcon;

    public Fwame() {
        // font activate
        try {
            minecraftRegular = Font.createFont(Font.TRUETYPE_FONT, new File("minecraft-regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("minecraft-regular.ttf")));
        } catch (IOException | FontFormatException e){
            throw new RuntimeException(e);
        }

        // setup components
        meow = new JTextArea("good evening. good day for skibidi rizz");
        meow.setHighlighter(null);
        meow.setFocusable(false);
        meow.setEditable(false);
        meow.setLineWrap(true);
        meow.setFont(minecraftRegular);
        meow.setBackground(Color.BLACK);
        meow.setForeground(Color.WHITE);
        meow.setBounds(10, 10, 310, 40);

        statsPanel = new JPanel();
        statsPanel.setLayout(null);
        statsPanel.setBounds(0, 0, 180, 180);
        statsPanel.setBackground(Color.CYAN);

        playerHealthDisplay = new JLabel();
        playerHealthDisplay.setBounds(10, 40, 100, 30);
        playerHealthDisplay.setFont(minecraftRegular);

        weaponDisplay = new JLabel();
        weaponDisplay.setBounds(10, 60, 150, 30);
        weaponDisplay.setFont(minecraftRegular);

        expDisplay = new JLabel();
        expDisplay.setBounds(10, 80, 100, 30);
        expDisplay.setFont(minecraftRegular);

        inventoryPanel = new JPanel();
        inventoryPanel.setLayout(null);
        inventoryPanel.setBounds(0, 180, 180, 281);
        inventoryPanel.setBackground(Color.ORANGE);

        inventoryTitleDisplay = new JLabel("inventory:");
        inventoryTitleDisplay.setBounds(10, 10, 100, 20);
        inventoryTitleDisplay.setFont(minecraftRegular);

        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0, 0, 180, 461);
        sidebarPanel.setBackground(Color.BLACK);

        // --------------------------------

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(180, 90, 250, 40);
        buttonPanel.setBackground(Color.DARK_GRAY);

        textPanel = new JPanel();
        textPanel.setBounds(130, 10, 350, 70);
        textPanel.setBackground(Color.BLACK);

        attackButton = new JButton("attack");
        attackButton.setFocusable(false);
        attackButton.setBounds(0, 5, 100, 30);
        attackButton.setFont(minecraftRegular);
        attackButton.setBackground(Color.BLACK);
        attackButton.setForeground(Color.WHITE);

        runButton = new JButton("run");
        runButton.setFocusable(false);
        runButton.setBounds(150, 5, 100, 30);
        runButton.setFont(minecraftRegular);
        runButton.setBackground(Color.BLACK);
        runButton.setForeground(Color.WHITE);

        continueButton = new JButton(">");
        continueButton.setFocusable(false);
        continueButton.setBounds(95, 5, 50, 30);
        continueButton.setFont(minecraftRegular);
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setVisible(false);

        respawnButton = new JButton("respawn");
        respawnButton.setFocusable(false);
        respawnButton.setBounds(95, 5, 100, 30);
        respawnButton.setFont(minecraftRegular);
        respawnButton.setBackground(Color.BLACK);
        respawnButton.setForeground(Color.WHITE);
        respawnButton.setVisible(false);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(180, 320, 605, 142); // x = left and right, y = up and down
        bottomPanel.setBackground(Color.BLUE);

        // ------------------------------------

        zomberIcon = new ImageIcon(new ImageIcon("C:\\Users\\savvy\\IdeaProjects\\meowwwwwwwwwwwwwww\\src\\notmeow\\icons\\zomber.png").getImage().getScaledInstance(150, 230, Image.SCALE_DEFAULT));
        rottenFleshIcon = new ImageIcon(new ImageIcon("C:\\Users\\savvy\\IdeaProjects\\meowwwwwwwwwwwwwww\\src\\notmeow\\icons\\flesh.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

        mobDisplayPanel = new JPanel();
        mobDisplayPanel.setLayout(null);
        mobDisplayPanel.setBounds(200, 30, 200, 260);
        mobDisplayPanel.setBackground(Color.RED);

        mobDisplayLabel = new JLabel();
        mobDisplayLabel.setLayout(null);
        mobDisplayLabel.setBounds(20, 0, 200, 260);

        mobHealthDisplay = new JLabel("health: 100");
        mobHealthDisplay.setLayout(null);
        mobHealthDisplay.setBounds(225,10, 150, 40);
        mobHealthDisplay.setBackground(Color.black);
        mobHealthDisplay.setForeground(Color.white);
        mobHealthDisplay.setFont(minecraftRegular);
        mobHealthDisplay.setOpaque(true);

        mobDropDisplay = new JLabel();
        mobDropDisplay.setLayout(null);
        mobDropDisplay.setBounds(80, 200, 50, 50);

        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBounds(180, 0, 605, 320);
        gamePanel.setBackground(Color.MAGENTA);

        // setup meow.fwame
        this.setSize(800, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // add thingies to thingies
        sidebarPanel.add(statsPanel);
        sidebarPanel.add(inventoryPanel);

        statsPanel.add(playerHealthDisplay);
        statsPanel.add(weaponDisplay);
        statsPanel.add(expDisplay);

        inventoryPanel.add(inventoryTitleDisplay);

        buttonPanel.add(attackButton);
        buttonPanel.add(runButton);
        buttonPanel.add(continueButton);

        bottomPanel.add(textPanel);
        bottomPanel.add(buttonPanel);

        textPanel.add(meow);

        gamePanel.add(mobHealthDisplay);
        gamePanel.add(mobDisplayPanel);
        mobDisplayPanel.add(mobDisplayLabel);
        mobDisplayPanel.add(mobDropDisplay);
        mobDropDisplay.addMouseListener(new itemClicker());


        this.add(sidebarPanel);
        this.add(bottomPanel);
        this.add(gamePanel);

        Player.playerSetup();
        this.setVisible(true);
        Battol.randomCreatureGenerator();

        attackButton.addActionListener(new buttonClicker());
        runButton.addActionListener(new buttonClicker());
        continueButton.addActionListener(new buttonClicker());
    }


    public static void continueButtonVisible() {
        attackButton.setVisible(false);
        runButton.setVisible(false);
        continueButton.setVisible(true);
    }

    public static void continueButtonInvisible() {
        attackButton.setVisible(true);
        runButton.setVisible(true);
        continueButton.setVisible(false);
    }

    public static void mobDropDisplayVisible() {
        Fwame.mobDisplayLabel.setVisible(false);
        Fwame.mobDropDisplay.setVisible(true);
    }

} // class bracket. keep stuff inside it
