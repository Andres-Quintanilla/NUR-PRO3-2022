package practico5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico5.vista.ventanaImagen;

public class practico5 {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        log.info("Se ha iniciado el practico 5 - UNDO y REDO");
        ventanaImagen v = new ventanaImagen();
        v.setVisible(true);
    }
}
