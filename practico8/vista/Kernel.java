package practico8.vista;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Kernel extends JPanel implements PropertyChangeListener {
    private JTextField textfield1;

    public Kernel() {
        textfield1=new JTextField();
        textfield1.setBounds(0,0,20,20);
        add(textfield1);
    }

    public Dimension getPreferredSize() {
        return new Dimension(640, 400);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        repaint();
    }
}

