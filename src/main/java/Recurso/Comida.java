package Recurso;

import javafx.scene.image.Image;

public class Comida extends Recurso{

    public Comida(int posN, int posM ) {
        super(posN, posM, new Image(Comida.class.getResource("/imagenes/Comida-Recursos.png").toExternalForm()));
    }
}
