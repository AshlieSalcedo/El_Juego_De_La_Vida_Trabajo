package Recurso;


import javafx.scene.image.Image;

public class Montana extends Recurso{

    public Montana(int posN, int posM) {
        super(posN, posM, new Image(Montana.class.getResource("/imagenes/Montanas-Recursos.png").toExternalForm()));
    }
}
