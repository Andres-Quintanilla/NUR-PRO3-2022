package practico1.vista;


import practico1.modelo.barra;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class panelBarras extends JPanel implements PropertyChangeListener {
    //private  Logger log = LogManager.getRootLogger();
    private static PropertyChangeSupport ps;
    barra[] lista = new barra[17];

    public panelBarras() {
        ps = new PropertyChangeSupport(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        int x = 0;
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 800);
        g.setColor(Color.BLUE);
        for (barra i : lista) {
            if (i != null) {
                g.fillRect(x, 0, 20, i.getX() * 50);
                x += 30;
            }
        }

    }

    public void agregarNumeroAleatorio() {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new barra((int) (Math.random() * 10) + 1);
            //log.info("Se esta creando los números aleatorios " + lista[i]);
        }
        for (barra object : lista) {
            object.addObserver(this);
        }
        this.repaint();
    }

    public void ordenar() {
        bubbleSort(lista);
        this.repaint();
    }

    static void bubbleSort(barra[] arr) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int nVariable = arr.length;
                int aux = 0;
                for (int i = 0; i < nVariable; i++) {
                    if (arr[i]!=null) {
                        for (int j = 1; j < (nVariable - i); j++) {
                            if (arr[j - 1].getX() > arr[j].getX()) {
                                aux = arr[j - 1].getX();
                                arr[j - 1].setX(arr[j].getX());
                                arr[j].setX(aux);
                            }
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException ex) {
                            }
                        }

                    }
                }

            }
        });
        t.start();
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        repaint();

    }
}
