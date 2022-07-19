package practico3.conexion;

import java.sql.*;

public class conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/loginPhotoShop";
    public static final String USUARIO = "root";
    public static final String CONTRASENA = "root";

    private static conexion instance;

    private Connection conexion;

    private conexion() {

    }

    public static conexion getInstance() {
        if (instance == null){
            instance = new conexion();
        }
        return instance;
    }

    public void conectar() throws SQLException {
        conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet consulta(Statement sentencia, String sql) throws SQLException {
        return sentencia.executeQuery(sql);
    }

    public void ejecutar(Statement sentencia, String sql) throws SQLException {
        sentencia.execute(sql);
    }

}
