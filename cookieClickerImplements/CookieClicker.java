package cookieClickerImplements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CookieClicker extends JFrame {

    GamePanel game;
    Timer gameTimer;

    public static CookieClicker cookieClicker;
    public static final int WIDTH = 400, HEIGHT = 700, DELAY = 12;
    public cookieClickerImplements.Renderer renderer;

    public CookieClicker(){
        super("CockieClicker");
        gameTimer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        game = new GamePanel();
        renderer = new Renderer();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setVisible(true);

        //Add Panel to Frame
        add(game);

        //Game timer
        gameTimer.start();

    }

}

class main {
    public static void main (String[] args) {
        CookieClicker.cookieClicker = new CookieClicker();
    }
}

