package practico6.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ventana extends JFrame {
    DefaultTableModel modeloTabla = new DefaultTableModel();
    JTable tabla = new JTable(modeloTabla);
    private JLabel lbrutaDeArchivo = new JLabel("Ruta del archivo");
    private TextField txtrutaDeArchivo = new TextField();
    private static Logger log = LogManager.getRootLogger();
    public ventana() {
        init();
    }

    public void init() {
        this.setTitle("Practico 6 - lector de archivos de texto");
        setSize(600, 600);
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
            public void actionPerformed(ActionEvent e) {
                subirArchivo_clicked();
            }
        });
        JMenu mnu2 = new JMenu("Crear");
        bar.add(mnu2);
        JMenuItem item2 = new JMenuItem("Crear carpeta");
        mnu2.add(item2);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        lbrutaDeArchivo.setBounds(0,0,91,50);
        txtrutaDeArchivo.setBounds(95,15,470,25);
        txtrutaDeArchivo.setEditable(false);
        tabla.setBounds(10,50,550,470);
        add(lbrutaDeArchivo);
        add(txtrutaDeArchivo);
        add(tabla);
        this.setJMenuBar(bar);

    }

    private void subirArchivo_clicked() {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        String rutaDeArchivo = fc.getSelectedFile().getPath();
        txtrutaDeArchivo.setText(rutaDeArchivo);

    }
}
