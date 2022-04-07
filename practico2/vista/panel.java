package practico2.vista;

import practico2.modelo.arbol;
import practico2.modelo.paisaje;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class panel extends JPanel implements PropertyChangeListener {

    ArrayList<arbol> listaArbol;
    private paisaje paisaje;
    private static Logger log = LogManager.getRootLogger();

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
                 lista.dibujar(g);
            }
            repaint();
        }
    }

    public void crearArbol(int x, int y) {
        int complejidad = ((y/100)-1);
        log.info("La complejidad tiene un valor de: " + complejidad);
        arbol nuevoArbol = new arbol(x,y,complejidad);
        listaArbol.add(nuevoArbol);
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
