package practico4.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.modelo.lista;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ventana extends JFrame {
    private lista modelo;
    private JLabel lbmensaje = new JLabel("Selecciona el archivo que quieres leer:");
    private JButton btnseleccionar = new JButton("Seleccionar");
    private JButton btnborrar = new JButton("Borrar");
    private TextArea txtareaArchivo = new TextArea();
    private static Logger log = LogManager.getRootLogger();
    private String expresion = "^([A-z])([a-z]+)\\s([A-z])([a-z]+)\\s([A-z])([a-z]+)\\s([1-9]+)$";
    private String texto = "";
    private String linea = "";
    private String resultado;

    public ventana(){
        init();
    }

    public void init(){
        this.setTitle("Practico 4 - lector de archivos de texto");
        setSize(600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        int x = 30;
        int y = 30;
        lbmensaje.setBounds(x,y,219,24);
        x+=250;
        btnseleccionar.setBounds(x,y,102,24);
        x-=250;
        x+=370;
        btnborrar.setBounds(x,y,102,24);
        x-=370;
        y+=50;
        txtareaArchivo.setBounds(x,y,400,400);
        txtareaArchivo.setEditable(false);

        add(lbmensaje);
        add(btnseleccionar);
        add(txtareaArchivo);
        add(btnborrar);

        cargarListener();
    }

    private void cargarListener(){
        btnseleccionar.addActionListener(actionEvent -> {
            mostrarTextoDelArchivo();
        });

        btnborrar.addActionListener(actionEvent -> {
            txtareaArchivo.setText("");
            log.info("Se limpio el campo de texto");
        });
    }
    private void mostrarTextoDelArchivo(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(fr);
            while((linea = lector.readLine()) != null){
                texto+= linea + "\n";

                /*for (int i = 0; i < tests2.length(); i++) {
                    Pattern r = Pattern.compile(expresion);
                    Matcher m = r.matcher(tests2[i]);

                    if(m.find()){
                        resultado = m.group(1).toUpperCase() + m.group(2).toLowerCase() + " " + m.group(3).toUpperCase() + m.group(4).toLowerCase + " " +
                            m.group(5).toUpperCase() + m.group(6).toLowerCase();
                    }
                }*/

            }
            txtareaArchivo.setText(texto);
            log.info("Archivo leído correctamente");
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
        }
    }
}
