package Modelo;

import javafx.scene.image.Image;

public class IndividuoNormal extends Individuo{
    public IndividuoNormal( int posN, int posM, double reproduccion, double clon,int turnoVida) {
        super( posN, posM, reproduccion, clon,turnoVida,new Image(IndividuoNormal.class.getResource("/imagenes/IndividuoNormal.png").toExternalForm()));
    }
}
