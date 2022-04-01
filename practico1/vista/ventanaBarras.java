package practico1.vista;

import practico1.modelo.barra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaBarras extends JFrame {
    panelBarras p;
    JButton btn = new JButton("Barras aleatorias");
    JButton btn2 = new JButton("Ordenar");

    public ventanaBarras()  {
        this.setLayout(null);
        p = new panelBarras();
        p.setBounds(0, 0, 500, 500);
        btn.setBounds(0, 500, 150, 50);
        btn2.setBounds(160, 500, 150, 50);

        this.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                p.agregarNumeroAleatorio();

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                p.ordenar();
            }
        });

        this.add(btn2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        this.setLocationRelativeTo(null);
        setVisible(true);
        this.add(p);
        p.setVisible(true);

    }
}
