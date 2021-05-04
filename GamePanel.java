package cockieClicker;

import org.w3c.dom.css.Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener, ActionListener {

    public cockieClicker.Renderer renderer;
    JButton bScore = new JButton("Click me!!");
    JButton button;

    public int Money = 0;
    public double cost;

    //Upgrades
    private String name;
    private int levels;
    private int productionRate;
    private int costs;


    public GamePanel(){
        renderer = new Renderer();

        add(renderer);
        setSize(400,700);
        setVisible(true);
        add(bScore);
        bScore.addActionListener(this::actionPerformed);


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //set font and color
        g.setFont(new Font("Arial", 1,50));
        g.setColor(Color.BLACK);

        //draw Cookie
        Graphics2D cookie = (Graphics2D) g;
        cookie.setColor(Color.RED);
        cookie.fillOval(160,90,80,80);

        //draw Score
        g.drawString(String.valueOf(Money), 160, 230);

        //Buttons
        bScore.setBounds(160, 300, 200, 50);

    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        if (e.getSource()==bScore){
            Money++;
        }
        if (e.getSource()==button){
            improve();
        }


    }

    public void Upgrades(String name, int levels, int productionRate, int costs){
        this.name = name;
        this.levels = levels;
        this.productionRate = productionRate;
        this.costs = costs;

        button = new JButton();
        button.addActionListener(this::actionPerformed);

}

    public void improve(){

    }


    @Override
    public void mouseClicked(MouseEvent e) {

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
