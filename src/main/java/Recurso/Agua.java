package Recurso;

import javafx.scene.image.Image;

public class Agua extends Recurso{
    public Agua( int posN, int posM) {
        super(posN, posM,new Image(Agua.class.getResource("/imagenes/Agua-Recursos.png").toExternalForm()));
    }
}
