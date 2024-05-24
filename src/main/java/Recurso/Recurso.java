package Recurso;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class Recurso {
    private Image imagen;
    private int posN;
    private int posM;
    private static int contadorID = 0;
    private int ID;
    private int tiempoA;
    private static double probZ;

    public Recurso(int posN, int posM, Image imagen) {
        this.imagen = imagen;
        this.posN = posN;
        this.posM = posM;
        this.ID = ++contadorID;
    }

    public Image getImagen() {
        return imagen;
    }

    public int getPosN() {
        return posN;
    }

    public int getPosM() {
        return posM;
    }

    public static int getContadorID() {
        return contadorID;
    }

    public int getID() {
        return ID;
    }

    public Image getImageWithID() {
        Image baseImage = getImagen();
        Canvas canvas = new Canvas(baseImage.getWidth(), baseImage.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(baseImage, 0, 0);
        gc.setFill(Color.WHITE);
        gc.setFont(new Font(12));
        gc.fillText(String.valueOf(ID), 5, 15); // Colocar el ID en la esquina superior izquierda
        return canvas.snapshot(new SnapshotParameters(), null);
    }

    public boolean tiempoAgotado() {

        return tiempoA == 0;

    }


}
