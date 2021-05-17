package cookieClickerImplements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Factory extends JPanel implements Upgrade{
    private String name;
    private int levels;
    private int productionRate;
    public int costs;
    GamePanel gamePanel;

    JLabel label;
    JButton button;

    public Factory(String name, int levels, int productionRate, int costs){
        this.name = name;
        this.levels = levels;
        this.productionRate = productionRate;
        this.costs = costs;

        label = new JLabel();
        button = new JButton();
        button.setEnabled(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                improve();
            }
        });
    }
    @Override
    public void improve() {
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
    @Override
    public int getProductionRate() {
        return productionRate * levels;
    }
    @Override
    public void actualize() {
        label.setText(name + "Prod. Rate: " + getProductionRate());
        button.setText("Improve " + name + "(costs:" + costs + ")");
    }
    @Override
    public void unlock() {
        add(button);
        actualize();
    }
}
