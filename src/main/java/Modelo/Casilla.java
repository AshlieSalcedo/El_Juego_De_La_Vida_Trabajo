package Modelo;

import Estructuras.Enlazada.ListaEnlazada;
import Recurso.*;

public class Casilla {
    private int posN;
    private int posM;
    private ListaEnlazada listaRecursos;
    private ListaEnlazada listaIndividuos;

    public Casilla(int posN, int posM) {
        this.posN = posN;
        this.posM = posM;
        this.listaRecursos = new ListaEnlazada();
        this.listaIndividuos = new ListaEnlazada();
    }
    public int realizarMovimientos(Individuo nuevo){
        listaIndividuos.add(nuevo);
        int resultado=-1;
        if (listaIndividuos.getNumeroElementos()>3){
            int numMenorVida=4;
            int menorIndPos=0;
            for (int i=0; i< listaIndividuos.getNumeroElementos();i++){
                Individuo individuo1  = (Individuo)listaIndividuos.getElemento(i).getData();
                if(individuo1.getTurnoVida()<numMenorVida){
                    numMenorVida = individuo1.getTurnoVida();
                    resultado= individuo1.getID();
                    menorIndPos = i;
                }
            }
            listaIndividuos.del(menorIndPos);
        }
        return resultado;
    }
    public int buscarPosicionRecursoPorID(int id) {
        for (int i = 0; i < listaRecursos.getNumeroElementos(); i++) {
            Recurso recurso = (Recurso) listaRecursos.getElemento(i).getData();
            if (recurso.getID() == id) {
                return i; // Devolver el índice del recurso con el ID dado
            }
        }
        return -1; // Devolver -1 si no se encuentra el recurso con el ID dado
    }

    public int getPosN() {
        return posN;
    }

    public int getPosM() {
        return posM;
    }

    public ListaEnlazada getListaRecursos() {
        return listaRecursos;
    }

    public ListaEnlazada getListaIndividuos() {
        return listaIndividuos;
    }
}

