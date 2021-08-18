package cookieClickerImplements;

import javax.swing.*;
import java.awt.*;

//fachliche Klasse
public class Renderer extends JPanel
{
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        CookieClicker.cookieClicker.game.repaint();
    }
}