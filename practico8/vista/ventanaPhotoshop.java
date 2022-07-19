package practico8.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico8.modelo.Imagen;
import practico8.transformaciones.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaPhotoshop extends JFrame {
    private Imagen modelo;
    private panelPhotoshop panel;
    private static Logger log = LogManager.getRootLogger();

    public ventanaPhotoshop(){
        init();
    }


    public void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        modelo = new Imagen(1280,880);
        panel = new panelPhotoshop(modelo);
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
        JMenuItem aclarar = new JMenuItem("Aclarar Imagen");
        JMenuItem oscurecer = new JMenuItem("oscurecer Imagen");
        JMenuItem convolucionar = new JMenuItem("convolucionar Imagen");

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
                log.info("Selecciono el filtro rojo para la imagen");
            }
        });
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verde_clicked();
                log.info("Selecciono el filtro verde para la imagen");
            }
        });
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                azul_clicked();
                log.info("Selecciono el filtro azul para la imagen");
            }
        });
        gris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gris_clicked();
                log.info("Selecciono el filtro gris para la imagen");
            }
        });
        aclarar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aclarar_clicked();
                log.info("Selecciono el filtro para aclarar la imagen");
            }
        });
        oscurecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oscurecer_clicked();
                log.info("Selecciono el filtro para aclarar la imagen");
            }
        });
        convolucionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convolucionar_clicked();
                log.info("Selecciono el filtro para aclarar la imagen");
            }
        });

        mnu.add(item);
        mnu2.add(rojo);
        mnu2.add(verde);
        mnu2.add(azul);
        mnu2.add(gris);
        mnu2.add(aclarar);
        mnu2.add(oscurecer);
        mnu2.add(convolucionar);
        this.setJMenuBar(bar);
        this.pack();
    }

    private void mostrarImagen_clicked(){
        modelo.leerImagen("c:/imagenes/paisaje.jpg");
    }

    private void gris_clicked() {
        mostrarImagen_clicked();
        transformaciones tonosDeGris = new TonoDeGris(modelo);
        tonosDeGris.transformar();

    }
    private void azul_clicked() {
        mostrarImagen_clicked();
        transformaciones tonosDeAzul = new TonoDeAzul(modelo);
        tonosDeAzul.transformar();

    }
    private void verde_clicked() {
        mostrarImagen_clicked();
        transformaciones tonosDeVerde = new TonoDeVerde(modelo);
        tonosDeVerde.transformar();

    }
    private void rojo_clicked() {
        mostrarImagen_clicked();
        transformaciones tonosDeRojo = new TonoDeRojo(modelo);
        tonosDeRojo.transformar();

    }
    private void aclarar_clicked() {
        transformaciones aclarar = new aclararImagenPhotoshop(modelo,20);
        aclarar.transformar();

    }
    private void oscurecer_clicked() {
        transformaciones oscurecer = new oscurecerImagenPhotoshop(modelo,20);
        oscurecer.transformar();

    }
    private void convolucionar_clicked() {
        transformaciones convolucionar = new convolucionarImagenPhotoshop(modelo);
        convolucionar.transformar();
    }

}

