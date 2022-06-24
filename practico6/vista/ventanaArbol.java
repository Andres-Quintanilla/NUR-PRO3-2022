package practico6.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico6.arbol;
import practico6.modelo.documentos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class ventanaArbol extends JFrame implements PropertyChangeListener {
    private static Logger log = LogManager.getRootLogger();
    private arbol<documentos> modelo;
    private JLabel lbRutaDelArchivo = new JLabel("Ruta del archivo");
    private TextField txtRutaDelArchivo = new TextField();

    public ventanaArbol(){
        init();
    }

    public void init(){
        this.setTitle("Practico 6 - Explorador de Archivos");
        this.setSize(600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JMenuBar bar = new JMenuBar();
        JMenu mnu = new JMenu("Archivo");
        bar.add(mnu);
        JMenuItem item = new JMenuItem("Subir archivo");
        mnu.add(item);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                subirArchivos();
            }
        });

        JMenu mnu2 = new JMenu("Carpeta");
        bar.add(mnu2);
        JMenuItem item2 = new JMenuItem("Crear nueva carpeta");
        mnu2.add(item2);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                crearNuevaCarpeta();
            }
        });

        lbRutaDelArchivo.setBounds(10,0,91,50);
        txtRutaDelArchivo.setBounds(105,15,470,25);
        txtRutaDelArchivo.setEditable(false);

        add(lbRutaDelArchivo);
        add(txtRutaDelArchivo);

        this.setJMenuBar(bar);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    private void subirArchivos(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        String rutaDelArchivo = archivo.getPath();
        txtRutaDelArchivo.setText(rutaDelArchivo);
        log.info("La ruta actual es: " + rutaDelArchivo);
    }

    private void crearNuevaCarpeta(){

    }
}
