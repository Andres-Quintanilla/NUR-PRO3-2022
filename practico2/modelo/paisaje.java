package practico2.modelo;

import java.awt.*;

    public class paisaje {
        private int tamano;

        public paisaje(int tamano) {
            this.tamano = tamano;
        }

        public void dibujarPaisaje(Graphics g){
        //Cielo
        g.setColor(Color.blue);
        g.fillRect(0,0,650 + tamano,100 + tamano);
        //suelo
        g.setColor(Color.GREEN);
        g.fillRect(0,0 + 350,650 + tamano,200 + tamano);
        //sol
        g.setColor(Color.yellow);
        g.fillOval(0 + 645,0 + 5,tamano - 50,tamano - 50);


    }
}
