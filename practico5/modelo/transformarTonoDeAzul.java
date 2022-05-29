package practico5.modelo;

public class transformarTonoDeAzul extends transformacion {
    public transformarTonoDeAzul(Imagen img){
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
