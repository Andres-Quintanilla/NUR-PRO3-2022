package practico5.vista;

import practico5.modelo.DeshacerYHacer;
import practico5.modelo.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class panelImagen extends JPanel implements PropertyChangeListener {
    private  final Imagen modelo;
    private DeshacerYHacer listaCambios;

    public panelImagen(Imagen m){
        modelo = m;
        this.listaCambios = new DeshacerYHacer();
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(600,600);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(modelo == null){
            return;
        }

        BufferedImage rms = new BufferedImage(modelo.getAncho(), modelo.getAlto(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rms.createGraphics();

        modelo.dibujar(g2d);
        g.drawImage(rms,0,0, null);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() != "Imagen"){
            return;
        }
        repaint();
    }

    public void deshacer(){
        listaCambios.deshacer();
        Imagen img = listaCambios.clonarActual();
        modelo.setFromImagen(img);
    }

    public void rehacer(){
        listaCambios.rehacer();
        Imagen img = listaCambios.clonarActual();
        modelo.setFromImagen(img);
    }
}
