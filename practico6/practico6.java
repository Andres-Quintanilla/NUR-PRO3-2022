package practico6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practico6.vista.ventanaArbol;

public class practico6 {
    private static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        log.info("Se ha iniciado el practico 6 - Explorador de Archivos");
        ventanaArbol v = new ventanaArbol();
        v.setVisible(true);
    }
}
