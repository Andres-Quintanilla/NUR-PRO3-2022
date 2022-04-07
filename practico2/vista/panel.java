package practico2.vista;

import practico2.modelo.arbol;
import practico2.modelo.paisaje;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class panel extends JPanel implements PropertyChangeListener {
    //private arbol modelo;
    ArrayList<arbol> listaArbol;
    private practico2.modelo.paisaje paisaje;
    public panel(){
    }

    public panel(paisaje p){
        paisaje = p;
        listaArbol = new ArrayList<>();

    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(900,800);
    }

    @Override
    protected  void paintComponent(Graphics g){
        super.paintComponent(g);
        if (paisaje != null){
            paisaje.dibujarPaisaje(g);
            int aux=0;
            for (arbol lista: listaArbol) {
                lista.dibujarArbol(g);
                aux++;
            }
            repaint();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "Posición"){
            return;
        }
        repaint();
    }

    public void crearArbol(int x, int y) {
        arbol aux = new arbol(x,y,50,(y/100)+1);
        listaArbol.add(aux);
       repaint();
    }
}
