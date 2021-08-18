package cookieClickerImplements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Fachliche Klasse
public class Granies extends JPanel implements Upgrade{
    protected String name;
    private int levels;
    protected int productionRate;
    public int costs;

    JLabel label;
    JButton button;

    public Granies(String name, int levels, int productionRate, int costs) {
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

    @Override
    public void improve() {
        if(GamePanel.Money >= costs) {
            levels++;
            GamePanel.Money -= costs;
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

class GraniesStub extends Granies {

    public GraniesStub(String name, int levels, int productionRate, int costs) {
        super(name, levels, productionRate, costs);
        productionRate = getProductionRate();
    }
    @Override
    public int getProductionRate() {
        return 5;
    }
}
