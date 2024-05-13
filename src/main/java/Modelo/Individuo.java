package Modelo;
import Estructuras.*;
public abstract class Individuo {
    private int ID;
    private int posN;
    private int posM;
    private int turnoVida;
    private double reproduccion;
    private double clon;

    public Individuo(int ID, int posN, int posM, double reproduccion, double clon) {
        this.ID = ID;
        this.posN = posN;
        this.posM = posM;
        this.turnoVida = 3;
        this.reproduccion = reproduccion;
        this.clon = clon;
    }

    public int upDateTurno(ListaEnlazada celda){
        int resultado=0;
        if (turnoVida==1){
            resultado = -1;
        }
        else {
            turnoVida--;
            reproduccion= reproduccion-0.1;
            clon=clon-0.1;
            mover(celda);
        }
        return resultado;
    }
    public void mover(ListaEnlazada celda){

    }
}
