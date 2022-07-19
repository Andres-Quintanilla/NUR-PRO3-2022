package practico8.vista;

import practico8.modelo.usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaLogin extends JFrame {
    private JLabel lbusuario = new JLabel("Usuario");
    private TextField txtusuario = new TextField();
    private JLabel lbcontraseña = new JLabel("Contraseña");
    private JPasswordField txtcontraseña = new JPasswordField();
    private  JButton btnentrar = new JButton("Entrar");
    private int x = 30;
    private int y = 30;
    private String usuario, password, nombre;
    private boolean entrar = false;
    usuario u = new usuario();

    public ventanaLogin() {
        init();
    }

    public void init() {
        this.setTitle("Login para entrar a PhotoShop");
        this.setSize(500, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        lbusuario.setBounds(x, y, 100, 24);
        x += 150;
        txtusuario.setBounds(x, y, 150, 24);
        x -= 150;
        y += 30;
        lbcontraseña.setBounds(x, y, 100, 24);
        x += 150;
        txtcontraseña.setBounds(x, y, 150, 24);
        x -= 150;
        y += 30;
        btnentrar.setBounds(x, y, 120, 24);

        add(lbusuario);
        add(txtusuario);
        add(lbcontraseña);
        add(txtcontraseña);
        add(btnentrar);
        cargarListener();
    }

    private void cargarListener(){
        btnentrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario = txtusuario.getText();
                password = txtcontraseña.getText();
                if(usuario.equals("") && password.equals("")){
                    JOptionPane.showMessageDialog(null, "Los espacios estan vacios, por favor ingrese sus datos");
                    entrar = true;
                }else if (usuario.equals("admin") && password.equals("admin")) {
                    u.setNombre("Andres Quintanilla Cuellar");
                    JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNombre());
                    ventanaPhotoshop v2 = new ventanaPhotoshop();
                    v2.setVisible(true);
                    dispose();
                    entrar = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    txtusuario.setText("");
                    txtcontraseña.setText("");
                }
            }
        });
    }
}
