package Estructuras;

public class ListaEnlazada {
    private ElementoLE primero;
    public ListaEnlazada(){}

    public ListaEnlazada(ElementoLE primero) {
        this.primero = primero;
    }

    public boolean isVacia(){

        return primero == null;
    }

    public void vaciar(){
        while (primero!=null){
            ElementoLE temp = primero.getSiguiente();
            primero = null;
            primero = temp;
        }
    }
    int add(ElementoLE el){
        if (isVacia()) {
            primero = el;
            return 1;
        }else{
            ElementoLE ultimo = getUltimo();
            el.insertarmeEn(ultimo); //insertamos el nuevo elemento despues del ultimo
            return -1;
        }
    }
    public void add(String s){
        ElementoLE nuevoElementoLE = new ElementoLE();
        nuevoElementoLE.setData(s);
        if (primero == null) {
            primero = nuevoElementoLE;
        }else{
            ElementoLE actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();}
            actual.insertarmeEn(nuevoElementoLE);
        }

    }
    public void add(Object o){
        ElementoLE nuevoElementoLE = new ElementoLE();
        nuevoElementoLE.setData(o);
        if (primero == null) {
            primero = nuevoElementoLE;
        }else{
            ElementoLE actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.insertarmeEn(nuevoElementoLE);
        }
    }
    public int getNumeroElementos(){
        if (isVacia()){
            return 0;
        }else{
            int numElementos=1;
            ElementoLE actual = primero;
            while (actual.getSiguiente() != null){
                actual = actual.getSiguiente();
                numElementos++;
            }
            return numElementos;
        }
    }
    public int getPosicion(ElementoLE el){
        int pos=0;
        ElementoLE actual = primero;
        while (actual != null) {
            if (actual == el) {
                return pos;}
            pos++;
            actual = actual.getSiguiente();}
        return -1; //Se indica con -1 que el elemento no se encuentra en la lista
    }
    public ElementoLE getPrimero(){return primero;}

    public ElementoLE getUltimo(){
        ElementoLE actual = primero;
        while (actual.getSiguiente() != null){
            actual = actual.getSiguiente();}
        return actual;}
    public void insert(String s, int posicion){
        if (posicion<0){
            throw new IndexOutOfBoundsException("La posición indicada no es correcta");
        } else {
            ElementoLE nuevoElementoLE = new ElementoLE();
            nuevoElementoLE.setData(s);
            if (posicion == 0){
                nuevoElementoLE.insertarmeEn(primero);
                primero = nuevoElementoLE;
            }else{
                ElementoLE actual = primero;//usamos actual como puntero
                int posicionActual = 0;
                while(actual != null && posicionActual < posicion -1){
                    actual = actual.getSiguiente();
                    posicionActual++;
                }
                if (actual == null){
                    throw new IllegalArgumentException("La posición buscada no se encuentra dentro de la lista ");
                }else{
                    nuevoElementoLE.insertarmeEn(actual.getSiguiente());
                    actual.insertarmeEn(nuevoElementoLE);
                }

            }

        }
    }
    public void insert(Object o, int posicion){
        if (posicion<0){
            throw new IndexOutOfBoundsException("La posición indicada no es correcta");
        } else {
            ElementoLE nuevoElementoLE = new ElementoLE();
            nuevoElementoLE.setData(o);
            if (posicion == 0){
                primero.insertarmeEn(nuevoElementoLE);
                primero = nuevoElementoLE;
            }else{
                ElementoLE actual = primero;
                int posicionActual = 0;
                while(actual != null && posicionActual < posicion -1){
                    actual = actual.getSiguiente();
                    posicionActual++;
                }
                if (actual == null){
                    throw new IllegalArgumentException("La posición buscada no se encuentra dentro de la lista ");
                }else{
                    nuevoElementoLE.insertarmeEn(actual.getSiguiente());
                    actual.insertarmeEn(nuevoElementoLE);
                }
            }

        }
    }

    public ElementoLE getSiguiente(ElementoLE el){
        return el.getSiguiente();
    }
    public ElementoLE getElemento(int posicion){

        if (posicion < 0){
            return null; //no existen posiciones negativas
        }
        ElementoLE actual = primero;
        int contador = 0;
        while (actual!=null && contador < posicion){
            actual = actual.getSiguiente();
            contador++;
        }
        if (actual == null){
            return null;
        }
        return actual;
    }
    public int del(int posicion){
        if (posicion<0 || posicion >= getNumeroElementos()){
            return 1;//No se puede eliminar un elemento de una posición que no pertenece a la lista
        }
        ElementoLE anterior = null;
        ElementoLE actual = primero;
        for(int i = 0; i < posicion-1;i++){
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (anterior == null){//significa que se quiere eliminar el primer elemento
            primero = actual.getSiguiente();
        }else{
            ElementoLE siguiente = actual.getSiguiente();
            siguiente.insertarmeEn(anterior);
        }
        return -1; //Se ha eliminado el elemento

    }
}
