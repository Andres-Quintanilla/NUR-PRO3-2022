package practico3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico3.vista.ventanaImagen;

public class practico3 {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        ventanaImagen v = new ventanaImagen();
        log.info("Se ha iniciado el proyecto filtro para imagenes");
        v.setVisible(true);
    }
}
