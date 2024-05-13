package Modelo;

import Estructuras.ListaEnlazada;

public class Celda {
    private int posN;
    private int posM;
    private ListaEnlazada listaRecursos;

    public Celda(int posN, int posM) {
        this.posN = posN;
        this.posM = posM;
        this.listaRecursos = new ListaEnlazada();
    }

}
