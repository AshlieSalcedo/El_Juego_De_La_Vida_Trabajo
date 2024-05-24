package Estructuras.Simple;
import javafx.scene.image.Image;

public class ElementoLS {
    private Object data;
    private Image imagen;
    public ElementoLS(){
    }

    public ElementoLS(Object data) {
      this.data = data;
    }

    public Object getData(){
        return this.data;
    }
    public Object setData(Object o){
        this.data = o;
        Object objeto;
        objeto = this.getData();
        return objeto;
    }

}
