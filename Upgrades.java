package cockieClicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Upgrades extends JPanel {
    private String name;
    private int levels;
    private int productionRate;
    private int costs;
    static int Money;
    GamePanel gamePanel;

    JLabel label;
    JButton button;

    public Upgrades(String name, int levels, int productionRate, int costs){
        this.name = name;
        this.levels = levels;
        this.productionRate = productionRate;
        this.costs = costs;

        label = new JLabel();
        button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                improve();
            }
        });
    }

    public int getLevels() {
        return levels;
    }

    public void improve(){
        if(gamePanel.Money >= costs) {
            levels++;
            gamePanel.Money -= costs;
            costs *= 2;
            JOptionPane.showMessageDialog(null, "You have improved the " + name + "!");
        } else {
                JOptionPane.showMessageDialog(null, "You have not enough money!");
            }
            actualize();
        }
    public int getProductionRate(){
        return productionRate * levels;
    }

    public void actualize(){
        label.setText(name + "Prod. Rate: " + getProductionRate());
        button.setText("Improve " + name + "(costs:" + costs + ")");
    }

    public void unlock() {
        add(button);
        actualize();
    }
}
