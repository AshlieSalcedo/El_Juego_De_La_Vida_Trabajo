package Recurso;

import Modelo.IndividuoAvanzado;
import javafx.scene.image.Image;

public class Biblioteca extends Recurso{

    public Biblioteca(int posN, int posM) {
        super(posN, posM,  new Image(IndividuoAvanzado.class.getResource("/imagenes/Biblioteca-Recursos.png").toExternalForm()));
    }
}
