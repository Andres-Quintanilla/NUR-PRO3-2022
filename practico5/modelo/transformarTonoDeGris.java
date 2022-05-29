package practico5.modelo;

public class transformarTonoDeGris extends transformacion{

    public transformarTonoDeGris(Imagen img){
        this.imagen = img;
    }

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int color = pixeles[i][j];

                int r = (color >> 16);
                int g = (color >> 8) & 0x000000ff;
                int b = color & 0x000000ff;

                int gris = (int)(((double)r + (double)g + (double)b) / 3.0 );
                int intGris = gris + gris * 256 + gris * 256 * 256;
                imagen.setColor(intGris,i,j);
            }
        }
        imagen.transformada();
    }
}