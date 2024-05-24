package Modelo;

import Estructuras.Enlazada.ListaEnlazada;
import javafx.scene.image.Image;

import java.util.Random;


public class IndividuoBasico extends Individuo{

    public IndividuoBasico( int posN, int posM, double reproduccion, double clon,int turnoVida) {
        super(posN, posM, reproduccion, clon,turnoVida,new Image(IndividuoBasico.class.getResource("/imagenes/IndividuoBasico.png").toExternalForm()));
    }
    public Casilla calcularRuta(ListaEnlazada matriz){
        int M = this.getPosM();
        int N = this.getPosN();
        Random random = new Random();
        int siguienteM;
        int siguienteN;
        siguienteM = random.nextInt(-1,1);
        siguienteN = random.nextInt(-1,1);
        return Tablero.getCasilla(siguienteM,siguienteN);

    }
}
