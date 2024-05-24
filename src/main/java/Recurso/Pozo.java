package Recurso;

import Modelo.IndividuoAvanzado;
import javafx.scene.image.Image;

public class Pozo extends Recurso{

    public Pozo(int posN, int posM) {
        super(posN, posM, new Image(Pozo.class.getResource("/imagenes/Pozo-Recursos.png").toExternalForm()));
    }
}
