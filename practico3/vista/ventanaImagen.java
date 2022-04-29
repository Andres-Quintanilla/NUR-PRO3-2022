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
        JMenu mnu2 = new JMenu("Efectos");
        bar.add(mnu2);
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
                mostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
            }
        });
        gris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gris_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
            }
        });
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarImagen_clicked();
            }
        });

        mnu.add(item);
        mnu2.add(rojo);
        mnu2.add(verde);
        mnu2.add(azul);
        mnu2.add(gris);
        mnu2.add(blancoYNegro);
        mnu2.add(espejoHorizontal);
        mnu2.add(espejoVertical);
        this.setJMenuBar(bar);
        this.pack();
    }

    private void mostrarImagen_clicked(){
        modelo.leerImagen("c:/imagenes/paisaje.jpg");
    }

    private void gris_clicked() {
        transformacion tonosDeGris = new transformarTonoDeGris(modelo);
        tonosDeGris.transformar();
    }
}
