package Recurso;


import javafx.scene.image.Image;


public class Tesoro extends Recurso{
    public Tesoro( int posN, int posM) {
        super(posN, posM,new Image(Tesoro.class.getResource("/imagenes/Tesoro-Recursos.png").toExternalForm()));
    }
}
