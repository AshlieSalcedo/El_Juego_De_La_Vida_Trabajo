package Modelo;
import Estructuras.Enlazada.ListaEnlazada;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public abstract class Individuo {
    private static int contadorID = 0;
    private Image imagen;
    private int ID;
    private int posN;
    private int posM;
    private int turnoVida;
    private double reproduccion;
    private double clon;

    public Individuo(int posN, int posM, double reproduccion, double clon, Image imagen) {
        this.posN = posN;
        this.posM = posM;
        this.turnoVida = 3;
        this.reproduccion = reproduccion;
        this.clon = clon;
        this.ID = ++contadorID;
        this.imagen = imagen;
    }

    public int upDateTurno(ListaEnlazada celda){
        int resultado=0;
        if (turnoVida==1){
            resultado = -1;
        }
        else {
            turnoVida--;
            reproduccion= reproduccion-0.1;
            clon=clon-0.1;
            mover(celda);
        }
        return resultado;
    }
    public int mover(ListaEnlazada matriz){
        Casilla casillaSiguiente = calcularRuta(matriz);
        int resultado = casillaSiguiente.realizarMovimientos(this);
        return resultado;
    }
    public Casilla calcularRuta(ListaEnlazada matriz){
        return null;
    }
    //método para obtener la imagen de cada invididuo con su ID, lo usamos para poder ver los individuos en cada casilla
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
    public void upDateVida(){
        this.turnoVida--;
    }


    public int getID() {
        return ID;
    }

    public int getPosN() {
        return posN;
    }

    public int getPosM() {
        return posM;
    }

    public int getTurnoVida() {
        return turnoVida;
    }

    public double getReproduccion() {
        return reproduccion;
    }

    public double getClon() {
        return clon;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPosN(int posN) {
        this.posN = posN;
    }

    public void setPosM(int posM) {
        this.posM = posM;
    }

    public void setTurnoVida(int turnoVida) {
        this.turnoVida = turnoVida;
    }

    public void setReproduccion(double reproduccion) {
        this.reproduccion = reproduccion;
    }

    public void setClon(double clon) {
        this.clon = clon;
    }

    public Image getImagen() {
        return imagen;
    }
}
