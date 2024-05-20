package Modelo;

import Estructuras.ListaEnlazada;

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

