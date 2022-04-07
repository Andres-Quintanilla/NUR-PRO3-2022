package practico2.vista;

import practico2.modelo.arbol;
import practico2.modelo.paisaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ventana extends JFrame implements MouseListener {
    private arbol modelo;
    private panel panel;
    private paisaje paisaje;
    private static Logger log = LogManager.getRootLogger();

    public ventana(){
        init();
        addMouseListener(this);
    }

    private void init() {
        this.setTitle("Paisaje");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        paisaje = new paisaje(250);
        panel = new panel(paisaje);

        this.getContentPane().add(panel,BorderLayout.CENTER);

        this.pack();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 0 && e.getX() <= 900 && e.getY() >= 350  && e.getY() <= 860 ){
            panel.crearArbol(e.getXOnScreen()-30,e.getYOnScreen()-80);
            log.info("Su árbol se agrego en:" + (e.getXOnScreen()-30) + " - " + (e.getYOnScreen()-80));
        }
    }

    //Sin usar
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
