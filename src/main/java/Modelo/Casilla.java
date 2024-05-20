package Modelo;

import Recurso.Recurso;

public class Casilla {

    private int posFilas;
    private int posColum;
    public int getPosFilas() {
        return posFilas;
    }
    public void setPosFilas(int posFilas) {
        this.posFilas = posFilas;
    }
    public int getPosColum() {
        return posColum;
    }
    public void setPosColum(int posColum) {
        this.posColum = posColum;
    }

    private Individuo individuo = null;
    private Recurso recurso = null;

    public Individuo getIndividuo() {
        return individuo;
    }
    public void setIndividuo(Individuo individuo) {
        this.individuo = individuo;
    }
    public Recurso getRecurso() {
        return recurso;
    }
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Casilla(int posFilas, int posColum){
        this.posFilas = posFilas;
        this.posColum = posColum;
    }

    public Casilla(int posFilas, int posColum, Individuo individuo){
        this.posFilas = posFilas;
        this.posColum = posColum;
        this.individuo = individuo;
    }

    public Casilla(int posFilas, int posColum, Recurso recurso){
        this.posColum = posColum;
        this.posFilas = posFilas;
        this.recurso = recurso;
    }

    public boolean isVacia(){
        return (this.individuo == null && this.recurso == null);
    }



}
