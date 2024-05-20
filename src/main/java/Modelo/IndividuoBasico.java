package Modelo;

import Estructuras.ListaEnlazada;

import java.util.Random;

public class IndividuoBasico extends Individuo{
    public IndividuoBasico(int ID, int posN, int posM, double reproduccion, double clon) {
        super(ID, posN, posM, reproduccion, clon);
    }
    public Casilla calcularRuta(ListaEnlazada matriz){
        int M = this.getPosM();
        int N = this.getPosN();
        Random random = new Random();
        int siguienteM;
        int siguienteN;
        siguienteM = random.nextInt(-1,1);
        siguienteN = random.nextInt(-1,1);
        return Tablero.getCelda(siguienteM,siguienteN);

    }
}
