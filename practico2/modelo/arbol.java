package practico2.modelo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class arbol {
    private PropertyChangeSupport cambios;
    private Color color;
    private int x;
    private int y;
    private int tamano;
    private int angulo;
    private int complejidad;

    public arbol(int x, int y, int complejidad) {
        this.x = x;
        this.y = y;
        this.complejidad = complejidad;
        tamano = 100;
        angulo = 0;
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
        dibujarArbol(g,tamano,angulo,x,y, complejidad);
    }

    private void  dibujarArbol(Graphics g, int tamano, int angulo, int x, int y, int complejidad){
        int xmover = (int)(Math.cos(Math.toRadians(angulo + 90))* tamano);
        int ymover = (int)(Math.sin(Math.toRadians(angulo - 90))* tamano);
        g.setColor(Color.BLACK);
        g.drawLine(x,y,x + xmover,y + ymover);
        if (tamano >= 1){
            dibujarArbol(g, tamano - 20, angulo + 30, x + xmover, y + ymover, complejidad);
            dibujarArbol(g, tamano - 20, angulo - 30, x + xmover, y + ymover, complejidad);

           /*int newComplejidad = complejidad - 1;

            dibujarArbol(g, tamano - 50, angulo + 30, x + xmover, y + ymover, complejidad);
            dibujarArbol(g, tamano - 50, angulo - 30, x + xmover, y + ymover, complejidad);

            dibujarArbol(g, tamano - 34, angulo + 30, x + xmover, y + ymover, complejidad);
            dibujarArbol(g, tamano - 34, angulo - 30, x + xmover, y + ymover, complejidad);

            dibujarArbol(g, tamano - 25, angulo + 30, x + xmover, y + ymover, complejidad);
            dibujarArbol(g, tamano - 25, angulo - 30, x + xmover, y + ymover, complejidad);

            dibujarArbol(g, tamano - 20, angulo + 30, x + xmover, y + ymover, complejidad);
            dibujarArbol(g, tamano - 20, angulo - 30, x + xmover, y + ymover, complejidad);*/
            return;
        }



    }



    /*private void dibujarArbol(Graphics g, int x, int y, int tamano, int complejidad){
        if(complejidad == 1){
            g.setColor(Color.BLACK);
            g.drawLine(x, y, tamano, tamano + 50);
            return;
        }
        int newTamano = tamano / 3;
        int newComplejidad = complejidad - 1;

        dibujarArbol(g, x,y + newTamano,newTamano, newComplejidad);


    }*/

    public void addObserver(PropertyChangeListener listener){
        cambios.addPropertyChangeListener(listener);
    }
}
