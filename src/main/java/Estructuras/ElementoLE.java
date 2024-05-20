package Estructuras;

public class ElementoLE<Object> {
    private ElementoLE<Object> siguiente;
    private Object data;

    public ElementoLE() {
    }

    public ElementoLE(ElementoLE<Object> siguiente, Object data) {
        this.siguiente = siguiente;
        this.data = data;
    }

    void insertarmeEn(ElementoLE<Object> el){//metodo privado según UMl (Hemos puesto como público)
        el.siguiente = this.siguiente;//??
        this.siguiente = el;
    }

    ElementoLE<Object> getSiguiente(){//metodo privado según UMl (Hemos puesto como público)
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
