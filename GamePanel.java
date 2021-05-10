package cockieClicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TimerTask;

public class GamePanel extends JPanel{

    public cockieClicker.Renderer renderer;
    static int Money = 0;
    public double clicker = 1;
    private int BUTTON_POSX = 110, BUTTON_POSY = 300;

    JButton increaseClicker;

    //Upgrades
    Upgrades granies;
    boolean graniesUnlocked;


    public GamePanel() {
        renderer = new Renderer();
        granies = new Upgrades("Granies", 0, 1, 20);
        graniesUnlocked = false;

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
                if (graniesUnlocked == false && Money >=2){
                    granies.unlock();
                    graniesUnlocked = true;
                }
            }
        },0,2000);
        java.util.Timer produceWithUpgrades = new java.util.Timer();
        produceWithUpgrades.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Money += granies.getProductionRate();
            }
        },0,1000);

        add(renderer);
        add(granies);
        add(increaseClicker);
        setSize(400, 700);
        setVisible(true);

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
        cookie.fillOval(160, 90, 100, 100);

        //draw Money
        g.drawString("Cookies " + Money, 100, 250);

        //Buttons
        increaseClicker.setBounds(BUTTON_POSX, BUTTON_POSY, 200, 50);
        granies.setBounds(BUTTON_POSX, BUTTON_POSY + 50, 200, 50);

    }
}
