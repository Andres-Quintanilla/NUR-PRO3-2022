package practico4.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.lista;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ventana extends JFrame {
    private JLabel lbmensaje = new JLabel("Selecciona el archivo que quieres leer:");
    private TextField txtborrar = new TextField();
    private JButton btnseleccionar = new JButton("Seleccionar");
    private JButton btnborrar = new JButton("Borrar");
    private TextArea txtareaArchivo = new TextArea();
    private String expresion = "^([A-z])([A-z]+)\\s([A-z])([A-z]+)\\s([A-z])([A-z]+)\\s([0-9]+)$";
    private String texto = "";
    private String linea = "";
    private String resultado;
    private int x = 30;
    private int y = 30;
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
        x+=490;
        txtborrar.setBounds(x,y,45,25);
        x-=490;
        y+=50;
        txtareaArchivo.setBounds(x,y,400,400);
        txtareaArchivo.setEditable(false);

        add(lbmensaje);
        add(btnseleccionar);
        add(txtareaArchivo);
        add(txtborrar);
        add(btnborrar);

        cargarListener();
    }

    private void cargarListener(){
        btnseleccionar.addActionListener(actionEvent -> {
            mostrarTextoDelArchivo();
        });

        btnborrar.addActionListener(actionEvent -> {
            borrarTextoDelArchivo();
        });
    }
    private void mostrarTextoDelArchivo(){
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile();
        try{
            Scanner s = new Scanner(archivo);
            while (s.hasNextLine()){
                linea = s.nextLine();
                l.adicionar(linea);
            }
            comparar();
            log.info("Archivo leído correctamente" + "\n");
        } catch (Exception e) {
            log.error("Error sin entrar " + e.getMessage());
        }
    }

    private void borrarTextoDelArchivo(){
        if(txtareaArchivo != null){
            txtareaArchivo.setText("");
            Iterator<String> iter = l.iterator();
            while(iter.hasNext()) {
                String elemento = iter.next();
            }

            try {
                l.eliminar(Integer.parseInt(txtborrar.getText()));
                comparar();
                log.info("Elemento eliminado correctamente");
            } catch(Exception e) {
                System.out.println("No se puede eliminar: " + e.getMessage());
            }

        }
    }

    private void comparar(){
        for (int i = 0; i < l.tamano(); i++) {
            Pattern p = Pattern.compile(expresion);
            Matcher m = p.matcher(l.obtener(i));
            if (m.find()) {
                resultado = m.group(1).toUpperCase() + m.group(2).toLowerCase() + " " + m.group(3).toUpperCase() +
                        m.group(4).toLowerCase() + " " + m.group(5).toUpperCase() + m.group(6).toLowerCase() + " " + m.group(7);
                txtareaArchivo.append(resultado + "\n");
            }
            log.info(l.obtener(i));
        }
    }
}
