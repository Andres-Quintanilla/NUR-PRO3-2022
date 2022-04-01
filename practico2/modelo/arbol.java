package practico2.modelo;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class arbol {
    private PropertyChangeSupport cambios;
    private int x;
    private int y;
    private int tamano;
    private Color color;

    public arbol(Color color,int tamano) {
        this.color = color;
        x=0;
        y=0;
        this.tamano = tamano;
        cambios = new PropertyChangeSupport(this);
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void dibujar(Graphics g){
        //Cielo
        g.setColor(Color.blue);
        g.fillRect(x,y,650 + tamano,100 + tamano);
        //suelo
        g.setColor(Color.GREEN);
        g.fillRect(x,y + 350,650 + tamano,200 + tamano);
        //sol
        g.setColor(Color.yellow);
        g.fillOval(x + 645,y + 5,tamano - 50,tamano - 50);


    }

    public void dibujarArbol(){
        //arboles
        /*gs.setColor(Color.BLACK);
        gs.fillRect(x,y,tamano, tamano);*/
    }

    public void addObserver(PropertyChangeListener listener){
        cambios.addPropertyChangeListener(listener);
    }
}
