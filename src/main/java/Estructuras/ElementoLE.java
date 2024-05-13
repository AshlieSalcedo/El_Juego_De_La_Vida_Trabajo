package Estructuras;

public class ElementoLE {
    private ElementoLE siguiente;
    private Object data;

    public ElementoLE() {
    }

    public ElementoLE(ElementoLE siguiente, Object data) {
        this.siguiente = siguiente;
        this.data = data;
    }

    void insertarmeEn(ElementoLE el){//metodo privado según UMl (Hemos puesto como público)
        el.siguiente = this.siguiente;//??
        this.siguiente = el;
    }

    ElementoLE getSiguiente(){//metodo privado según UMl (Hemos puesto como público)
        return siguiente;

    }
    public Object getData(){
        return this.data;
    }

    public Object setData(Object data){
        this.data = data;
        return data;
    }

}
