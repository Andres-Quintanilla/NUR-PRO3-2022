package practico2.vista;

import practico2.modelo.arbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class panel extends JPanel implements PropertyChangeListener, MouseListener {

    private arbol modelo;

    public panel(){
        addMouseListener(this);
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
            modelo.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "Posición"){
            return;
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 1){

            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
