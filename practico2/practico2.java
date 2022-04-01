package practico2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico2.vista.ventana;

public class practico2 {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        ventana v = new ventana();
        log.info("Se ha iniciado el proyecto de paisaje");
        v.setVisible(true);
    }
}
