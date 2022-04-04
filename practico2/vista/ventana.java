package practico2.vista;

import practico2.modelo.arbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ventana extends JFrame implements MouseListener {
    private arbol modelo;
    private panel panel;

    public ventana(){
        init();
        addMouseListener(this);
    }

    private void init() {
        this.setTitle("Paisaje");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        modelo = new arbol(Color.white,250);
        panel = new panel(modelo);
        this.getContentPane().add(panel,BorderLayout.CENTER);

        //Menu
        JMenuBar bar = new JMenuBar();
        JMenu mnu = new JMenu("Archivo");
        bar.add(mnu);
        JMenuItem item = new JMenuItem("Borrar Arboles");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se ilimnaron los arboles dibujados");
                init();
            }
        });

        mnu.add(item);
        this.setJMenuBar(bar);

        this.pack();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 1){
            //modelo.dibujarArbol();
            System.out.println("Click... se dibuja el arbol");
            repaint();
        }
    }


    // Sin usar
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
