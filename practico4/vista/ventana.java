package practico4.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.lista;


import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ventana extends JFrame {
    private JLabel lbmensaje = new JLabel("Selecciona el archivo que quieres leer:");
    private JButton btnseleccionar = new JButton("Seleccionar");
    private JButton btnborrar = new JButton("Borrar");
    private TextArea txtareaArchivo = new TextArea();
    private String expresion = "^([A-z])([A-z]+)\\s([A-z])([A-z]+)\\s([A-z])([A-z]+)\\s([0-9]+)$";
    private String texto = "";
    private String linea = "";
    private String resultado;
    private int x = 30;
    private int y = 30;
    private int numero = 1;
    lista<String> l = new lista();
    private static Logger log = LogManager.getRootLogger();


    public ventana(){
        init();
    }

    public void init(){
        this.setTitle("Practico 4 - lector de archivos de texto");
        setSize(600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
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
       // add(btnborrar);

        cargarListener();
    }

    private void cargarListener(){
        btnseleccionar.addActionListener(actionEvent -> {
            mostrarTextoDelArchivo();
        });

        btnborrar.addActionListener(actionEvent -> {

        });
    }
    private void mostrarTextoDelArchivo(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        try{
            FileReader fr = new FileReader(archivo);// nos permite leer el archivo
            BufferedReader lector = new BufferedReader(fr);// es una clase que nos permite leer el texto del archivo
            while((linea = lector.readLine()) != null){
                texto += numero + ".- " + linea + "\n";
                l.adicionar(texto);
                numero++;
            }
            for (int i = 0; i < l.tamano(); i++) {
               Pattern r = Pattern.compile(expresion);// Nos permite obtener la expresion regular
                Matcher m = r.matcher(l.obtener(i));// Nos permite comprobar si un string cumple la expresion regular
                // find nos permite buscar que se cumplan una seria de reglas de busqueda
                if(m.find()){
                    resultado = m.group(1).toUpperCase() + m.group(2).toLowerCase() + " " + m.group(3).toUpperCase() +
                            m.group(4).toLowerCase() + " " + m.group(5).toUpperCase() + m.group(6).toLowerCase() + " " + m.group(7);

                }
                log.info(resultado);
                txtareaArchivo.setText(l.obtener(i));
            }
            log.info("Archivo leído correctamente");
        } catch (Exception e) {
            log.error("Error sin entrar " + e.getMessage());
        }
    }
}
