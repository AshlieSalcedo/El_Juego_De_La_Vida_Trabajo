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
    public int mover(ListaEnlazada matriz){
        Celda celdaSiguiente = calcularRuta(matriz);
        int resultado = celdaSiguiente.realizarMovimientos(this);
        return resultado;

    }


    public int getID() {
        return ID;
    }

    public int getPosN() {
        return posN;
    }

    public int getPosM() {
        return posM;
    }

    public int getTurnoVida() {
        return turnoVida;
    }

    public double getReproduccion() {
        return reproduccion;
    }

    public double getClon() {
        return clon;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPosN(int posN) {
        this.posN = posN;
    }

    public void setPosM(int posM) {
        this.posM = posM;
    }

    public void setTurnoVida(int turnoVida) {
        this.turnoVida = turnoVida;
    }

    public void setReproduccion(double reproduccion) {
        this.reproduccion = reproduccion;
    }

    public void setClon(double clon) {
        this.clon = clon;
    }


}
