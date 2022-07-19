package practico8.vista;

import practico8.modelo.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class panelPhotoshop extends JPanel implements PropertyChangeListener {
    private  final Imagen modelo;

    public panelPhotoshop(Imagen modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800,460);
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
}


