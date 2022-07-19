package practico8.transformaciones;

import practico8.modelo.Imagen;

public class convolucionarImagenPhotoshop extends transformaciones{
    private Imagen img;
    private int kernel[][] = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public convolucionarImagenPhotoshop(Imagen img) {
        this.imagen = img;
    }

    @Override
    public void transformar() {
        int[][] pixeles = imagen.getPixeles();
        int tope = kernel.length / 2;
        for (int i = tope; i < pixeles.length - tope; i++) {
            for (int j = tope; j < pixeles[0].length - tope; j++) {
                pixeles[i][j] = convolucionar(imagen.getPixeles(), kernel, i, j);
            }
        }
        this.imagen.setPixeles(pixeles);
        this.imagen.transformada();
    }

    public int convolucionar(int[][] imagen, int[][] kernel, int fila, int columna) {
        int tope = kernel.length / 2; //variable que sirve de control para evitar que se desborde la mascara de la matriz
        //short pixel = 0;
        int b = 0;
        int g = 0;
        int r = 0;

        int factor = 1;

        for (int i = 0; i < kernel.length; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                factor += kernel[i][j];
                b +=  blue(imagen[fila - tope + i][columna - tope + j]) * kernel[i][j];
                g +=  green(imagen[fila - tope + i][columna - tope + j]) * kernel[i][j];
                r +=  red(imagen[fila - tope + i][columna - tope + j]) * kernel[i][j];
            }
        }

        if (factor > 0) {
            b /= factor;
            g /= factor;
            r /= factor;
        }
        return (r << 16) | ((g << 8) | b);

    }

    public int blue(int b){
        int blue = b & 0x000000ff;
        return blue;
    }

    public int green(int g){
        int green = (g >>> 8) & 0x000000ff;
        return green;
    }

    public int red(int r){
        int red = (r >>> 16) & 0x000000ff;
        return red;
    }
}

