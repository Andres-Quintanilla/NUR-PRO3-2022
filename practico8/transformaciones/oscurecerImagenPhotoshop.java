package practico8.transformaciones;

import practico8.modelo.Imagen;

public class oscurecerImagenPhotoshop extends transformaciones{
    private int nivel;

    public oscurecerImagenPhotoshop(Imagen img, int nivel){
        this.imagen = img;
        this.nivel = nivel;
    }
    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int b = pixeles[i][j] & 0x000000ff;
                int g = (pixeles[i][j] >>> 8) & 0x000000ff;
                int r = (pixeles[i][j] >>> 16) & 0x000000ff;

                r -= nivel;
                g -= nivel;
                b -= nivel;

                if (r < 0) {
                    r = 0;
                }
                if (g < 0) {
                    g = 0;
                }
                if (b < 0) {
                    b = 0;
                }

                pixeles[i][j] = (r << 16) | ((g << 8) | b);
            }
        }
        imagen.transformada();
    }
}
