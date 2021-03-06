package practico2.modelo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class arbol {
    private PropertyChangeSupport cambios;
    private Color color;
    private int x;
    private int y;
    private int largo;
    private int angulo;
    private int tamanoArbol;
    private int complejidad;
    private static Logger log = LogManager.getRootLogger();


    public arbol(int x, int y, int complejidad) {
        this.x = x;
        this.y = y;
        this.complejidad = complejidad;
        largo = 100;
        angulo = 0;
        tamanoArbol = (int) (Math.random()*50+5);
        cambios = new PropertyChangeSupport(this);
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


    public void dibujar(Graphics g){
        dibujarArbol(g,largo,angulo,x,y, complejidad);
    }

    private void  dibujarArbol(Graphics g, int largo, int angulo, int x, int y, int complejidad){

        int xmover = (int)(Math.cos(Math.toRadians(angulo + 90))* tamanoArbol);
        int ymover = (int)(Math.sin(Math.toRadians(angulo - 90))* tamanoArbol);

        g.setColor(Color.BLACK);
        g.drawLine(x,y,x + xmover,y + ymover);

        if (largo >= 1){
            if(complejidad == 1){
                dibujarArbol(g, largo - 100, angulo + 30, x + xmover, y + ymover, complejidad);
                dibujarArbol(g, largo - 100, angulo - 30, x + xmover, y + ymover, complejidad);
                return;
            }

            int newComplejidad = complejidad - 1;

            dibujarArbol(g, largo - 50, angulo + 30, x + xmover, y + ymover, newComplejidad);
            dibujarArbol(g, largo - 50, angulo - 30, x + xmover, y + ymover, newComplejidad);

            dibujarArbol(g, largo - 34, angulo + 30, x + xmover, y + ymover, newComplejidad);
            dibujarArbol(g, largo - 34, angulo - 30, x + xmover, y + ymover, newComplejidad);

            dibujarArbol(g, largo - 25, angulo + 30, x + xmover, y + ymover, newComplejidad);
            dibujarArbol(g, largo - 25, angulo - 30, x + xmover, y + ymover, newComplejidad);

            dibujarArbol(g, largo - 20, angulo + 30, x + xmover, y + ymover, newComplejidad);
            dibujarArbol(g, largo - 20, angulo - 30, x + xmover, y + ymover, newComplejidad);
        }

    }


    public void addObserver(PropertyChangeListener listener){
        cambios.addPropertyChangeListener(listener);
    }
}
