package practico3.vista;

import practico3.modelo.Imagen;
import practico3.modelo.transformacion;
import practico3.modelo.transformarTonoDeGris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaImagen extends JFrame {
    private Imagen modelo;
    private panelImagen panel;

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
        JMenuItem rojo = new JMenuItem("Imagen con tonos de rojo");
        JMenuItem verde = new JMenuItem("Imagen con tonos de verde");
        JMenuItem azul = new JMenuItem("Imagen con tonos de azul");
        JMenuItem gris = new JMenuItem("Imagen con tonos de gris");
        JMenuItem blancoYNegro = new JMenuItem("Imagen con tonos de blanco y negro");
        JMenuItem espejoHorizontal = new JMenuItem("Imagen en modo espejo horizontal");
        JMenuItem espejoVertical = new JMenuItem("Imagen en modo espejo vertical");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });
        gris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGris_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });

        mnu.add(item);
        mnu.add(rojo);
        mnu.add(verde);
        mnu.add(azul);
        mnu.add(gris);
        mnu.add(blancoYNegro);
        mnu.add(espejoHorizontal);
        mnu.add(espejoVertical);
        this.setJMenuBar(bar);
        this.pack();
    }

    private void btnMostrarImagen_clicked(){
        modelo.leerImagen("c:/imagenes/paisaje.jpg");
    }

    private void btnGris_clicked() {
        transformacion tonosDeGris = new transformarTonoDeGris(modelo);
        tonosDeGris.transformar();
    }
}
