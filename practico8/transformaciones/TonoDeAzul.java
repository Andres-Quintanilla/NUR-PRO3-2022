package practico8.transformaciones;

import practico8.modelo.Imagen;

public class TonoDeAzul extends transformaciones{

    public TonoDeAzul(Imagen img){
        this.imagen = img;
    }

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int color = pixeles[i][j];
                int b = color & 0xff;

                color =(0<<16) | (0 <<8) | b;
                imagen.setColor(color,i,j);
            }
        }
        imagen.transformada();
    }
}
