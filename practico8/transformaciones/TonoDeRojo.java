package practico8.transformaciones;

import practico8.modelo.Imagen;

public class TonoDeRojo extends transformaciones{

    public TonoDeRojo(Imagen img){
        this.imagen = img;
    }

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int color = pixeles[i][j];
                int r = (color >> 16);

                color = (r << 16) | (0 << 8) | 0;
                imagen.setColor(color,i,j);
            }
        }
        imagen.transformada();
    }
}
