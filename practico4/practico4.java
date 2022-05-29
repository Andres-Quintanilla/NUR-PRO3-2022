package practico4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico4.vista.ventana;

public class practico4 {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        log.info("Se ha iniciado el practico 4 - lector de archivos texto");
        ventana v = new ventana();
        v.setVisible(true);
    }
}
