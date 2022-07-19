package practico8;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico8.vista.ventanaLogin;

public class practico8 {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        ventanaLogin v = new ventanaLogin();
        log.info("Se ha iniciado el login para entrar al programa de photoshop");
        v.setVisible(true);
    }
}
