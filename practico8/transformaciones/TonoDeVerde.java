package practico8.transformaciones;

import practico8.modelo.Imagen;

public class TonoDeVerde extends transformaciones{

    public TonoDeVerde(Imagen img){
        this.imagen = img;
    }

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int color = pixeles[i][j];
                int g = (color>>8) & 0xff;

                color =(0<<16) | (g<<8) | 0;
                imagen.setColor(color,i,j);
            }
        }
        imagen.transformada();
    }
}
