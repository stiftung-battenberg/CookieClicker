package cookieClickerTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class GamePanel extends JPanel{

    public Renderer renderer;
    static double Money = 0;
    public double clicker = 1;
    private int BUTTON_POSX = 100, BUTTON_POSY = 300;

    JButton increaseClicker;

    //Upgrades
    Upgrades granies;
    boolean graniesUnlocked;

    Upgrades factory;
    boolean factoryUnlocked;


    public GamePanel() {
        renderer = new Renderer();
        setSize(400, 700);
        setVisible(true);

        granies = new Upgrades("Granies", 0, 0.5, 20);
        graniesUnlocked = false;

        factory = new Upgrades("Factory", 0, 2.5,50);
        factoryUnlocked = false;

        increaseClicker = new JButton("Increase Cookies");
        increaseClicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Money += clicker;
            }
        });

        java.util.Timer getMoreUpgrades = new java.util.Timer();
        getMoreUpgrades.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (graniesUnlocked == false && Money >=10){
                    granies.unlock();
                    graniesUnlocked = true;
                }
                if (factoryUnlocked == false && Money >=20){
                    factory.unlock();
                    factoryUnlocked = true;
                }
            }
        },0,2000);
        java.util.Timer produceWithUpgrades = new java.util.Timer();
        produceWithUpgrades.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Money += granies.getProductionRate();
                Money += factory.getProductionRate();
            }
        },0,1000);

        add(renderer);
        add(increaseClicker);

        //Upgrades
        add(granies);
        add(factory);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //set font and color
        g.setFont(new Font("Arial", 1, 50));
        g.setColor(Color.BLACK);

        //draw Cookie
        Graphics2D cookie = (Graphics2D) g;
        cookie.setColor(Color.RED);
        cookie.fillOval(160, 90, 80, 80);

        //draw Score
        g.drawString(String.valueOf(Money), 160, 230);

        //Buttons
        increaseClicker.setBounds(BUTTON_POSX, BUTTON_POSY, 200, 50);
        granies.setBounds(BUTTON_POSX, BUTTON_POSY + 50, 200, 50);
        factory.setBounds(BUTTON_POSX, BUTTON_POSY + 100, 200, 50);

    }
}
