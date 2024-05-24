package Modelo;

import javafx.scene.image.Image;

public class IndividuoAvanzado extends Individuo{
    public IndividuoAvanzado(int posN, int posM, double reproduccion, double clon,int turnoVida) {
        super(posN, posM, reproduccion, clon,turnoVida,new Image(IndividuoAvanzado.class.getResource("/imagenes/IndividuoAvanzado.png").toExternalForm()));
    }
    //Calculamos la ruta, obtenemos la casilla a la que queremos mover el individuo y llamamos al método mover (3 métodos distintos)
}
