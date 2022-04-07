package practico2.modelo;

import java.awt.*;

    public class paisaje {
        private int tamano;

        public paisaje(int tamano) {
            this.tamano = tamano;
        }

        public void dibujarPaisaje(Graphics g){
        //Cielo
        g.setColor(Color.cyan);
        g.fillRect(0,0,tamano + 650,tamano + 60);
        //suelo
        g.setColor(Color.GREEN);
        g.fillRect(0,0 + 310, tamano + 650,tamano + 240);
        //sol
        g.setColor(Color.yellow);
        g.fillOval(0 + 645,0 + 5,tamano - 50,tamano - 50);


    }
}
