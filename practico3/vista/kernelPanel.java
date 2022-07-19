package practico3.vista;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class kernelPanel extends JPanel implements PropertyChangeListener {

    private JTextField textfield1;
    private JLabel label1;
    private JButton boton1;

    public kernelPanel() {
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

