package Modelo;

import Estructuras.ListaEnlazada;

public class Tablero {
    int N;
    int M;
    ListaEnlazada listaIndividuos;
    ListaEnlazada matriz;
    public Tablero(int N, int M) {
        this.N = N;
        this.M = M;
        this.listaIndividuos = new ListaEnlazada();
        this.matriz = new ListaEnlazada();
        crearTablero();
    }
    public void crearTablero(){
        for (int i = 0; i<N; i++){
            for (int j = 0; i<M; j++){
                Celda celda = new Celda(i,j);
                matriz.add(celda);
            }
        }
    }
    public void upDateTurno(){
        //Vamos a hacer el divide y vencerás de las celdas para calcular los porcentajes de clonación y reproducción.
        //Además activará los recursos de cada celda
        for(int i = 0; i< listaIndividuos.getNumeroElementos();i++){
            Individuo individuoActual = (Individuo) listaIndividuos.getElemento(i).getData();
            int resultado = individuoActual.upDateTurno(matriz);
            if (resultado<0){
                listaIndividuos.del(i);
            }
            //upDateLog
            }
        }
    }
    public Celda getCelda(int M,int N){
        for(int i = 0; i < matriz.getNumElementos(); i++){
            Celda celdaActual = (Celda) matriz.getElemento(i).getData();
    }
}

