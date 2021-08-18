package cookieClickerImplements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

//fachliche Klasse
public class GamePanel extends JPanel {

    public Renderer renderer;
    static int Money = 0;
    public int clicker = 1;

    JButton increaseClicker;

    //Upgrades
    Granies granies;
    boolean graniesUnlocked;

    Factory factory;
    boolean FactoryUnlocked;


    public GamePanel() {
        renderer = new Renderer();
        granies = new Granies("Granies", 0, 1, 20);
        graniesUnlocked = false;

        factory = new Factory("Factory", 0, 2, 100);
        FactoryUnlocked = false;

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
                if (!graniesUnlocked && Money == granies.costs) {
                    granies.unlock();
                    graniesUnlocked = true;
                }
                if (!FactoryUnlocked && Money == factory.costs) {
                    factory.unlock();
                    FactoryUnlocked = true;
                }
            }
        }, 0, 2000);
        java.util.Timer produceWithUpgrades = new java.util.Timer();
        produceWithUpgrades.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Money += granies.getProductionRate();
                Money += factory.getProductionRate();
            }
        }, 0, 1000);

        add(renderer);

        add(granies);
        add(factory);

        setSize(400, 700);
        setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //set font and color
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.BLACK);

        //Paint Cookie
        Graphics2D cookie = (Graphics2D) g;
        cookie.setColor(Color.BLACK);
        int cookieRadius = 100;
        cookie.fillOval(160, 90, cookieRadius, cookieRadius);

        //draw Money
        g.drawString("Cookies " + (Money), 100, 250);

        //Buttons
        int BUTTON_POSX = 110;
        int BUTTON_POSY = 300;
        increaseClicker.setBounds(BUTTON_POSX, BUTTON_POSY, 200, 50);
        granies.setBounds(BUTTON_POSX, BUTTON_POSY + 50, 200, 50);
        factory.setBounds(BUTTON_POSX, BUTTON_POSY + 100, 200, 50);
    }


}
