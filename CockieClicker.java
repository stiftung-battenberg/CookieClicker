package cockieClicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CockieClicker extends JFrame {

    GamePanel game;
    Timer gameTimer;

    public static cockieClicker.CockieClicker cockieClicker;
    public static final int WIDTH = 400, HEIGHT = 700, DELAY = 12;
    public cockieClicker.Renderer renderer;

    public CockieClicker(){
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

