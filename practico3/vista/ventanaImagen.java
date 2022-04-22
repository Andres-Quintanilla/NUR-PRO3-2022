package practico3.vista;

import practico3.modelo.Imagen;

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
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMostrarImagen_clicked();
            }
        });

        mnu.add(item);
        this.setJMenuBar(bar);
        this.pack();
    }

    private void btnMostrarImagen_clicked(){
        modelo.leerImagen("c:/imagenes/paisaje.jpg");
    }
}
