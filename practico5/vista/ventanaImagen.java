package practico5.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico5.lista;
import practico5.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ventanaImagen extends JFrame {
    private Imagen modelo;
    private panelImagen panel;
    lista<Imagen> l = new lista();
    private static Logger log = LogManager.getRootLogger();

    public ventanaImagen(){
        init();
    }

    public void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());
        modelo = new Imagen(1280,880);
        panel = new panelImagen(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();
        JMenu mnu = new JMenu("Archivo");
        bar.add(mnu);
        JMenuItem item = new JMenuItem("Añadir imagen");
        JMenu mnu2 = new JMenu("Efectos");
        bar.add(mnu2);
        JMenuItem rojo = new JMenuItem("Imagen con tonos de rojo");
        JMenuItem verde = new JMenuItem("Imagen con tonos de verde");
        JMenuItem azul = new JMenuItem("Imagen con tonos de azul");
        JMenuItem gris = new JMenuItem("Imagen con tonos de gris");

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
                log.info("Se abrio la imagen");
            }
        });
        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rojo_clicked();
                l.adicionar(modelo);
                log.info("Selecciono el filtro rojo para la imagen");
            }
        });
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verde_clicked();
                l.adicionar(modelo);
                log.info("Selecciono el filtro verde para la imagen");
            }
        });
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azul_clicked();
                l.adicionar(modelo);
                log.info("Selecciono el filtro azul para la imagen");
            }
        });
        gris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gris_clicked();
                l.adicionar(modelo);
                log.info("Selecciono el filtro gris para la imagen");
            }
        });

        mnu.add(item);
        mnu2.add(rojo);
        mnu2.add(verde);
        mnu2.add(azul);
        mnu2.add(gris);
        mnu2.addSeparator();

        item = new JMenuItem("Deshacer");
        KeyStroke ctrlZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
        item.setAccelerator(ctrlZ);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnu_imagen_deshacer();
                log.info("Se deshizo la imagen");
            }
        });
        mnu2.add(item);

        item = new JMenuItem("Rehacer");
        KeyStroke ctrlY = KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
        item.setAccelerator(ctrlY);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnu_imagen_rehacer();
                log.info("Se deshizo la imagen");
            }
        });
        mnu2.add(item);

        this.setJMenuBar(bar);
        this.pack();
    }

    protected void mnu_imagen_rehacer() {
        panel.rehacer();
    }

    protected void mnu_imagen_deshacer() {
        panel.deshacer();
    }
    private void mostrarImagen_clicked(){
        modelo.leerImagen("c:/imagenes/paisaje.jpg");
    }

    private void gris_clicked() {
        transformacion tonosDeGris = new transformarTonoDeGris(modelo);
        tonosDeGris.transformar();
    }
    private void azul_clicked() {
        transformacion tonosDeAzul = new transformarTonoDeAzul(modelo);
        tonosDeAzul.transformar();
    }
    private void verde_clicked() {
        transformacion tonosDeVerde = new transformarTonoDeVerde(modelo);
        tonosDeVerde.transformar();
    }
    private void rojo_clicked() {
        transformacion tonosDeRojo = new transformarTonoDeRojo(modelo);
        tonosDeRojo.transformar();
    }

}
