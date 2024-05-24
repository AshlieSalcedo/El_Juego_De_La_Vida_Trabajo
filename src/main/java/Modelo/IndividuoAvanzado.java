package Modelo;

import javafx.scene.image.Image;

public class IndividuoAvanzado extends Individuo{
    public IndividuoAvanzado(int posN, int posM, double reproduccion, double clon) {
        super(posN, posM, reproduccion, clon,new Image(IndividuoAvanzado.class.getResource("/imagenes/IndividuoAvanzado.png").toExternalForm()));
    }
}
