package practico2.vista;

import practico2.modelo.arbol;
import practico2.modelo.paisaje;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class panel extends JPanel implements PropertyChangeListener {

    ArrayList<arbol> listaArbol;
    private paisaje paisaje;

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
            for (arbol lista: listaArbol) {
                lista.dibujarArbol(g);
            }
            repaint();
        }
    }

    public void crearArbol(int x, int y) {
        int complejidad = (int) (Math.random()*6+1);
        System.out.println("Complejidad es = " + complejidad);
        arbol aux = new arbol(x,y,10,complejidad);
        listaArbol.add(aux);
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "Posición"){
            return;
        }
        repaint();
    }



}
