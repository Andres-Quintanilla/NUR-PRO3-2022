package practico8.transformaciones;

import practico8.modelo.Imagen;

public class aclararImagenPhotoshop extends transformaciones{
   private int nivel;

    public aclararImagenPhotoshop(Imagen img, int nivel){
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

                r += nivel;
                g += nivel;
                b += nivel;

                if (r > 255) {
                    r = 255;
                }
                if (g > 255) {
                    g = 255;
                }
                if (b > 255) {
                    b = 255;
                }

                pixeles[i][j] = (r << 16) | ((g << 8) | b);
            }
        }
        imagen.transformada();
    }
}
