package practico2.vista;

import practico2.modelo.arbol;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class panel extends JPanel implements PropertyChangeListener {

    private arbol modelo;

    public panel(){

    }

    public panel(arbol m){
        modelo = m;
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(900,800);
    }

    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        if (modelo != null){
            modelo.dibujarPaisaje(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "Posición"){
            return;
        }
        repaint();
    }
}
