package Modelo;

import Estructuras.Enlazada.ListaEnlazada;

public class Tablero {
    private int N;
    private int M;
    private ListaEnlazada listaIndividuos;

    static ListaEnlazada matriz;

//Añadido
    public Tablero() {
        this.N = 1;
        this.M = 1;
        this.listaIndividuos = new ListaEnlazada();
        this.matriz = new ListaEnlazada();
    }

    public void setN(int n) {
        N = n;
    }

    public void setM(int m) {
        M = m;
    }

    public void setListaIndividuos(ListaEnlazada listaIndividuos) {
        this.listaIndividuos = listaIndividuos;
    }

    public static void setMatriz(ListaEnlazada matriz) {
        Tablero.matriz = matriz;
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public ListaEnlazada getListaIndividuos() {
        return listaIndividuos;
    }

    public static ListaEnlazada getMatriz() {
        return matriz;
    }

    public void crearTablero(){
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                Casilla casilla = new Casilla(i,j);
                matriz.add(casilla);
            }
        }
    }
    public void agregarIndividuoEnCasilla(int fila, int columna, Individuo individuo) {
        // Obtener la casilla correspondiente
        Casilla casilla = getCasilla(fila, columna);

        // Agregar el individuo a la lista de individuos de la casilla
        casilla.getListaIndividuos().add(individuo);

        // Agregar el individuo a la lista de individuos del tablero
        listaIndividuos.add(individuo);
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
    public static Casilla getCasilla(int M, int N){
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

