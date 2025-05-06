package notmeow;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Fwame extends JFrame {

    // IF YOU WANNA USE A VARIABLE FROM ANOTHER CLASS YOU HAVE TO PUT "EXTENDS"!!!!!!!!!!!!!!!! REMEMBER!!!!!!!!!!!!!!!
    static Random random = new Random();
    public static boolean hit = random.nextBoolean();
    public static boolean run = random.nextBoolean();

    public static String mob;
    public static String mobPosition;

    static int zomberHP = 100;
    static int zomberDamage = 2;

    static JTextArea meow;

    Font minecraftRegular;

    static JPanel sidebarPanel, gamePanel, bottomPanel;
    static JPanel textPanel, buttonPanel, statsPanel, inventoryPanel, mobDisplayPanel;

    static JLabel weaponDisplay, expDisplay, playerHealthDisplay, inventoryTitleDisplay;

    public static JButton attackButton;
    public static JButton runButton;
    public static JButton continueButton;

    public Fwame() {
        fontActivate();

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
        continueButton.setBounds(0, 0, 50, 50);
        continueButton.setFont(minecraftRegular);
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setVisible(false);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(180, 320, 605, 142); // x = left and right, y = up and down
        bottomPanel.setBackground(Color.BLUE);

        // ------------------------------------

        mobDisplayPanel = new JPanel();
        mobDisplayPanel.setLayout(null);
        mobDisplayPanel.setBounds(200, 30, 200, 260);
        mobDisplayPanel.setBackground(Color.RED);

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

        gamePanel.add(mobDisplayPanel);

        this.add(sidebarPanel);
        this.add(bottomPanel);
        this.add(gamePanel);

        Player.playerSetup();
        this.setVisible(true);
        Battol.randomCreatureGenerator(Main.creechahsList);

        attackButton.addActionListener(new buttonClicker());
        runButton.addActionListener(new buttonClicker());
        continueButton.addActionListener(new buttonClicker());
    }

    public void fontActivate() {
        try {
            minecraftRegular = Font.createFont(Font.TRUETYPE_FONT, new File("minecraft-regular.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("minecraft-regular.ttf")));
        } catch (IOException | FontFormatException e){
            throw new RuntimeException(e);
        }
    } // fontActivate bracket

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

} // class bracket. keep stuff inside it
