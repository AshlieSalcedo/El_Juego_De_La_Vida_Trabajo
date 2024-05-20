package Controlador;

import Estructuras.ListaEnlazada;
import Modelo.*;
import Recurso.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CeldaInteriorController implements Initializable {
    private Stage stage;

    //ATRIBUTOS PARA LA CREACION DEL TABLERO 2X3
    //tamaño de cada casilla (celda dentro del tablero 2x3)
    private static final int tam_cas_ancho = 80;
    private static final int tam_cas_largo = 50;
    private static final int tam_imagen = 40;

    //ancho del tablero
    private static final int filas = 2;

    //largo del tablero
    private static final int columnas = 3;
    @FXML
    private GridPane gridPane;

    //ATRIBUTOS PARA EL INTERIOR DE LA CASILLA

    private Celda celda;
    private ListaEnlazada<Recurso> listaRecursos;
    private ListaEnlazada<Individuo> listaIndividuos;

    //CONSTRUCTORES
    public CeldaInteriorController(){
        this.listaRecursos = new ListaEnlazada<>();
        this.listaIndividuos = new ListaEnlazada<>();
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) { //Creamos un tablero de 2 filas y 3 columnas (con 6 casillas)

                Rectangle casilla= new Rectangle(tam_cas_ancho, tam_cas_largo);

                casilla.setFill((fila + col) % 2 == 0 ? Color.DARKSEAGREEN : Color.GREEN);

                //Creamos una instancia para cada casilla dentro del tablero
                Casilla casilla = new Casilla(fila, col);

                if(casilla.isVacia()){
                    gridPane.add(casilla, col, fila);
                } else{
                    gridPane.add(casilla, col, fila);
                    //Vamos a añadir las imágenes de los recursos
                    //Creamos una imagen visible con ImageView para cada individuo y recurso
                    Image individuoBasico = new Image(getClass().getResourceAsStream("/Images/IndividuoBasico.png"));
                    Image individuoNormal = new Image(getClass().getResourceAsStream("/Images/IndividuoNormal.png"));
                    Image individuoAvanzado = new Image(getClass().getResourceAsStream("/Images/IndividuoAvanzado.png"));
                    Image agua = new Image(getClass().getResourceAsStream("/Images/Agua-Recursos.png"));
                    Image biblio = new Image(getClass().getResourceAsStream("/Images/Biblioteca-Recursos.png"));
                    Image Comida = new Image(getClass().getResourceAsStream("/Images/Comida-Recursos.png"));
                    Image montanas = new Image(getClass().getResourceAsStream("/Images/Montanas-Recursos.png"));
                    Image pozo = new Image(getClass().getResourceAsStream("/Images/Pozo-Recursos.png"));

                    if(!celda.getIndividuo().isVacia()) {
                        if (celda.getIndividuo().getClass() == IndividuoBasico.class) {
                            ImageView imagVisible = new ImageView(individuoBasico);
                            //Establecemos el tamaño
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            //metemos la imagen en la casilla
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        } else if (celda.getIndividuo().getClass() == IndividuoAvanzado.class) {
                            ImageView imagVisible = new ImageView(individuoAvanzado);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        } else if (celda.getIndividuo().getClass() == IndividuoNormal.class) {
                            ImageView imagVisible = new ImageView(individuoNormal);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        }
                    } else{
                        if(celda.getRecurso().getClass() == Agua.class){
                            ImageView imagVisible = new ImageView(agua);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        } else if (celda.getRecurso().getClass() == Pozo.class) {
                            ImageView imagVisible = new ImageView(pozo);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        } else if (celda.getRecurso().getClass() == Biblioteca.class) {
                            ImageView imagVisible = new ImageView(biblio);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        } else if (celda.getRecurso().getClass() == Montana.class) {
                            ImageView imagVisible = new ImageView(montanas);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        } else if (celda.getRecurso().getClass() == Comida.class) {
                            ImageView imagVisible = new ImageView(Comida);
                            imagVisible.setFitWidth(tam_imagen);
                            imagVisible.setFitHeight(tam_imagen);
                            gridPane.add(imagVisible, col, fila, 1, 1);
                        }
                    }
                }

            }
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    //Metodos propios de los individos y recursos de la casilla
    public int addIndiv(Individuo nuevo){
        listaIndividuos.add(nuevo);
        int resultado=-1;
        if (listaIndividuos.getNumeroElementos()>3){
            int numMenorVida=4;
            int menorIndPos=0;
            for (int i=0; i< listaIndividuos.getNumeroElementos();i++){
                Individuo individuo1  = listaIndividuos.getElemento(i).getData();
                if(individuo1.getTurnosVida()<numMenorVida){
                    numMenorVida = individuo1.getTurnosVida();
                    resultado= individuo1.getID();
                    menorIndPos = i;
                }
            }
            listaIndividuos.del(menorIndPos);
        }
        return resultado;
    }

    public boolean isVacia(){
        return ((listaIndividuos.getNumeroElementos() == 0) && (listaRecursos.getNumeroElementos() == 0));
    }

    public ListaEnlazada<Recurso> getListaRecursos() {
        return listaRecursos;
    }
    public void setListaRecursos(ListaEnlazada<Recurso> listaRecursos) {
        this.listaRecursos = listaRecursos;
    }
    public ListaEnlazada<Individuo> getListaIndividuos() {
        return listaIndividuos;
    }
    public void setListaIndividuos(ListaEnlazada<Individuo> listaIndividuos) {
        this.listaIndividuos = listaIndividuos;
    }

    public static void main(String[] args){

    }
}
