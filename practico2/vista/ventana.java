package practico2.vista;

import practico2.modelo.arbol;

import javax.swing.*;
import java.awt.*;

public class ventana extends JFrame {
    private arbol modelo;
    private panel panel;

    public ventana(){
        init();
    }

    private void init() {
        this.setTitle("Paisaje");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        modelo = new arbol(Color.white,250);
        panel = new panel(modelo);

        this.getContentPane().add(panel,BorderLayout.CENTER);

        this.pack();
    }

}
