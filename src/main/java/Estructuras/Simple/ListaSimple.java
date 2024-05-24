package Estructuras.Simple;


public class ListaSimple {
    private ElementoLS[] datos;
    private int maximo;



    public ListaSimple(ElementoLS[] datos,int max) {
        this.datos = datos;
        this.maximo = max;
    }


    public boolean isVacia(){
        boolean vacio = false;
        if (datos[0]==null){
            vacio=true;
        }
        return vacio;
    }
    public void vaciar(){
        for (int i= 0; i <datos.length;i++){
            datos[i]=null;
        }
    }
    //cambiado a package protected
    int add(ElementoLS el){


        if (getNumeroElementos() < maximo) {

            datos[getNumeroElementos()] = el;
            return 1;

        }else{

            return -1; // si no hay una posicion vacia menor que el largo de la cadena entonces está llena.
        }

    }
    public int add(String s) {
        if (getNumeroElementos() < maximo) {
            ElementoLS nuevo = new ElementoLS();
            nuevo.setData(s);
            datos[getNumeroElementos()] = nuevo;
            return 1;

        }else{

            return -1; // si no hay una posicion vacia menor que el largo de la cadena entonces está llena.
        }
    }
    public int add(Object o) {
        if (getNumeroElementos() < maximo) {
            ElementoLS nuevo = new ElementoLS();
            nuevo.setData(o);
            datos[getNumeroElementos()] = nuevo;
            return 1;

        }else{

            return -1; // si no hay una posicion vacia menor que el largo de la cadena entonces está llena.
        }
    }


    public int getNumeroElementos() {
        int contador = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) {
                contador++;
            }
        }
        return contador;
    }
    public int getPosicion(ElementoLS el){
        for (int i = 0; i < maximo; i++) {
            if (datos[i] == el) {
                return i;
            }
        }
        return -1; //Si el elemento no se ha encontrado en toda la lista
    }
    public ElementoLS getPrimero(){
        if(isVacia()){
            return null;
        }
        return datos[0];
    }
    public ElementoLS getUltimo(){
        if(isVacia()){
            return null;
        }
        int i;
        for (i = maximo-1; i>=0;i--){
            if (datos[i]!=null){
                break;
            }
        }
        return datos[i];
    }
    ElementoLS getSiguiente(ElementoLS el){
        int posicion = getPosicion(el);
        if (posicion < getNumeroElementos() && datos[posicion+1] != null){
            return datos[posicion + 1];
        }
        return null;
    }
    public ElementoLS getElemento(int posicion){
        if (posicion<0 || posicion>=getNumeroElementos()){
            return null;
        }
        if (posicion == 0){
            return datos[0];
        }
        return datos[posicion];
    }
    public void insert(String s,int posicion){
        if (posicion<0 || posicion > maximo){
            throw new IndexOutOfBoundsException ("La posición está fuera de rango");
        } else{
            if(maximo==getNumeroElementos()) {
                throw new IndexOutOfBoundsException ("No se pueden insertar más elementos");
            }else{
                for (int i = getNumeroElementos(); i >= posicion; i--) {
                    datos[i] = datos[i-1];}
                ElementoLS nuevo = new ElementoLS();
                nuevo.setData(s);
                datos[posicion]=nuevo;
            }
        }
    }
    public void insert(Object o, int posicion){
        if (posicion<0 || posicion > maximo){
            throw new IndexOutOfBoundsException("La posición está fuera de rango");
        } else{
            if(maximo==getNumeroElementos()) {
                throw new IndexOutOfBoundsException("No es unas opción válida");
            }else{
                for (int i = getNumeroElementos(); i >= posicion; i--) {
                datos[i] = datos[i-1];}
                ElementoLS nuevo = new ElementoLS();
                nuevo.setData(o);
                datos[posicion]=nuevo;}
        }
    }
    public int del(int posicion){
        datos[posicion]=null;
        return getNumeroElementos();
    }
}
