package practico1.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class barra {
    private int x;
    private PropertyChangeSupport ps;

    public barra(int x) {
        this.x = x;
        ps = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observador) {
        try {
            ps.addPropertyChangeListener(observador);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getX() {
        ps.firePropertyChange("cambio", 0, 1);
        return x;
    }

    public void setX(int xy) {
        this.x = xy;
    }
}
