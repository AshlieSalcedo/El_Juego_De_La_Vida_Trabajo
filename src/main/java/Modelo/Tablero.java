package Modelo;

import Estructuras.ListaEnlazada;

public class Tablero {
    private int N;
    private int M;
    private ListaEnlazada listaIndividuos;
    static ListaEnlazada matriz;
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
                Casilla casilla = new Casilla(i,j);
                matriz.add(casilla);
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
    public static Casilla getCelda(int M, int N){
        boolean encontrado = false;
        Casilla casillaActual = null;
        for(int i = 0; i < matriz.getNumeroElementos() && !encontrado; i++){
            casillaActual = (Casilla) matriz.getElemento(i).getData();
            if (casillaActual.getPosM()==M && casillaActual.getPosN()==N){
                encontrado = true;
            }
        }
        return casillaActual;
    }
    public void bucleControl(){

    }
}

