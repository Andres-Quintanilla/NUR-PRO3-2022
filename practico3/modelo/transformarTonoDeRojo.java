package practico3.modelo;

public class transformarTonoDeRojo extends transformacion{

    public transformarTonoDeRojo(Imagen img){
        this.imagen = img;
    }

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int color = pixeles[i][j];
                int r = (color >> 16);
                int g = (color >> 8) & 0xff;
                int b = color & 0xff;

                int rojo = (int)(((double)r + (double)g + (double)b)/3.0);
                int intRojo = rojo * 0+ rojo * 0 + rojo * 256 * 256;
                imagen.setColor(intRojo,i,j);
            }
        }
        imagen.transformada();
    }


}
