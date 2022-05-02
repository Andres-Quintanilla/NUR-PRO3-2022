package practico3.modelo;

public class imagenEspejoHorizontal {
    private Imagen modelo;

    public void transformar() {
        int ancho = modelo.getAncho();
        int alto = modelo.getAlto();
        Imagen nuevaImagen = new Imagen(ancho, alto);

        for (int j = 0; j < modelo.getAlto(); j++) {
            for (int i = 0; i < modelo.getAncho(); i++) {
                nuevaImagen.getPixeles()[i][j] = modelo.getPixeles()[ancho - i - 1][j];
            }
        }

        for (int j = 0; j < modelo.getAlto(); j++) {
            for (int i = 0; i < modelo.getAncho(); i++) {
                modelo.getPixeles()[i][j] = nuevaImagen.getPixeles()[i][j];
            }
        }

        modelo.transformada();
    }

}
