package practico2.modelo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class arbol {
    private PropertyChangeSupport cambios;
    private int x;
    private int y;
    private int tamano;
    private int complejidad;
    private Color color;

    public arbol(int x, int y,int tamano, int complejidad) {
        this.x = x;
        this.y = y;
        this.tamano = tamano;
        this.complejidad = complejidad;
        cambios = new PropertyChangeSupport(this);
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void dibujarArbol(Graphics g){
        if(complejidad == 1) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, tamano, tamano + 100);
        }





    }

    public void addObserver(PropertyChangeListener listener){
        cambios.addPropertyChangeListener(listener);
    }
}
