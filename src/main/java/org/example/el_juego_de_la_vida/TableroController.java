package org.example.el_juego_de_la_vida;

import Estructuras.Enlazada.ListaEnlazada;
import Modelo.*;
import Recurso.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;

public class TableroController {
    @FXML
    private Label TitleText;

    @FXML
    private GridPane gridPaneTablero;
    @FXML
    private Tablero tablero = new Tablero();
    @FXML
    private GridPane gridPaneMinitablero;
    @FXML
    private ChoiceBox<String> choiceBoxIndividuos;
    @FXML
    private Label timerLabel;

    private Timeline timeline;
    private int secondsElapsed = 0;
    @FXML
    private Button playButton;
    @FXML
    private Button pauseButton;
    @FXML
    private Button stopButton;
    private boolean juegoEnCurso = false;
    private boolean juegoPausado = false;

    public void generateBoard(int rows, int cols) {
        Tablero tablero = new Tablero();
        gridPaneTablero.getChildren().clear();
        gridPaneTablero.getColumnConstraints().clear();
        gridPaneTablero.getRowConstraints().clear();

        for (int row = 0; row < rows; row++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            gridPaneTablero.getRowConstraints().add(rowConstraints);
        }
        for (int col = 0; col < cols; col++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.ALWAYS);
            gridPaneTablero.getColumnConstraints().add(colConstraints);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                GridPane smallBoardGrid = createSmallBoard(row, col);
                gridPaneTablero.add(smallBoardGrid, col, row);
                Casilla casilla = new Casilla(row,col);
                tablero.getMatriz().add(casilla);
            }
        }
        System.out.println("Número de elementos en la matriz del tablero: " + tablero.getMatriz().getNumeroElementos());
    }

private GridPane createSmallBoard(int parentRow, int parentCol) {
    GridPane smallBoardGrid = new GridPane();
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            Rectangle rect = new Rectangle(30, 30);
            if ((i + j) % 2 == 0) {
                rect.setFill(Color.MEDIUMAQUAMARINE);
            } else {
                rect.setFill(Color.AZURE);
            }

            // Menú contextual antes de iniciar el juego
            ContextMenu contextMenu1 = createContextMenu1(parentRow, parentCol, rect);

            // Menú contextual cuando el juego está en pausa
            ContextMenu contextMenu2 = createContextMenu2(parentRow, parentCol, rect);

            rect.setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    if (!juegoEnCurso) {
                        // Mostrar el menú 1 si el juego no ha comenzado
                        contextMenu1.show(rect, e.getScreenX(), e.getScreenY());
                    } else if (juegoPausado) {
                        // Mostrar el menú 2 si el juego está en pausa
                        contextMenu2.show(rect, e.getScreenX(), e.getScreenY());
                    }
                }
            });

            smallBoardGrid.add(rect, j, i);
        }
    }
    smallBoardGrid.setGridLinesVisible(true);
    return smallBoardGrid;
}

private ContextMenu createContextMenu1(int parentRow, int parentCol, Rectangle rect) {
    ContextMenu contextMenu = new ContextMenu();

    MenuItem normalItem = new MenuItem("Individuo Normal");
    normalItem.setOnAction(e -> agregarIndividuo(new IndividuoNormal(parentRow, parentCol, 0.5, 0.5,2), rect));

    MenuItem basicoItem = new MenuItem("Individuo Básico");
    basicoItem.setOnAction(e -> agregarIndividuo(new IndividuoBasico(parentRow, parentCol, 0.5, 0.5,2), rect));

    MenuItem avanzadoItem = new MenuItem("Individuo Avanzado");
    avanzadoItem.setOnAction(e -> agregarIndividuo(new IndividuoAvanzado(parentRow, parentCol, 0.5, 0.5,2), rect));

    MenuItem aguaItem = new MenuItem("Agua");
    aguaItem.setOnAction(e -> agregarRecurso(new Agua(parentRow, parentCol), rect));

    MenuItem bibliotecaItem = new MenuItem("Biblioteca");
    bibliotecaItem.setOnAction(e -> agregarRecurso(new Biblioteca(parentRow, parentCol), rect));

    MenuItem comidaItem = new MenuItem("Comida");
    comidaItem.setOnAction(e -> agregarRecurso(new Comida(parentRow, parentCol), rect));

    MenuItem montanaItem = new MenuItem("Montaña");
    montanaItem.setOnAction(e -> agregarRecurso(new Montana(parentRow, parentCol), rect));

    MenuItem pozoItem = new MenuItem("Pozo");
    pozoItem.setOnAction(e -> agregarRecurso(new Pozo(parentRow, parentCol), rect));

    MenuItem tesoroItem = new MenuItem("Tesoro");
    tesoroItem.setOnAction(e -> agregarRecurso(new Tesoro(parentRow, parentCol), rect));

    contextMenu.getItems().addAll(normalItem, basicoItem, avanzadoItem, aguaItem, bibliotecaItem, comidaItem, montanaItem, pozoItem, tesoroItem);

    return contextMenu;
}

    private ContextMenu createContextMenu2(int parentRow, int parentCol, Rectangle rect) {
        ContextMenu contextMenu = new ContextMenu();

        MenuItem moverRecursoItem = new MenuItem("Mover recurso");
        moverRecursoItem.setOnAction(e -> {
            contextMenu.hide();
            mostrarRecursos(rect,1,1);
        });
        MenuItem normalItem = new MenuItem("Individuo Normal");
        normalItem.setOnAction(e -> agregarIndividuo(new IndividuoNormal(parentRow, parentCol, 0.5, 0.5,2), rect));

        MenuItem basicoItem = new MenuItem("Individuo Básico");
        basicoItem.setOnAction(e -> agregarIndividuo(new IndividuoBasico(parentRow, parentCol, 0.5, 0.5,2), rect));

        MenuItem avanzadoItem = new MenuItem("Individuo Avanzado");
        avanzadoItem.setOnAction(e -> agregarIndividuo(new IndividuoAvanzado(parentRow, parentCol, 0.5, 0.5,2), rect));

        MenuItem aguaItem = new MenuItem("Agua");
        aguaItem.setOnAction(e -> agregarRecurso(new Agua(parentRow, parentCol), rect));

        MenuItem bibliotecaItem = new MenuItem("Biblioteca");
        bibliotecaItem.setOnAction(e -> agregarRecurso(new Biblioteca(parentRow, parentCol), rect));

        MenuItem comidaItem = new MenuItem("Comida");
        comidaItem.setOnAction(e -> agregarRecurso(new Comida(parentRow, parentCol), rect));

        MenuItem montanaItem = new MenuItem("Montaña");
        montanaItem.setOnAction(e -> agregarRecurso(new Montana(parentRow, parentCol), rect));

        MenuItem pozoItem = new MenuItem("Pozo");
        pozoItem.setOnAction(e -> agregarRecurso(new Pozo(parentRow, parentCol), rect));

        MenuItem tesoroItem = new MenuItem("Tesoro");
        tesoroItem.setOnAction(e -> agregarRecurso(new Tesoro(parentRow, parentCol), rect));


        contextMenu.getItems().addAll(moverRecursoItem, normalItem, basicoItem, avanzadoItem, aguaItem, bibliotecaItem, comidaItem, montanaItem, pozoItem, tesoroItem);

        return contextMenu;
    }
private void agregarIndividuo(Individuo individuo, Rectangle rect) {
    try {
        // Crear y configurar ImageView
        Image imagenIndividuo = individuo.getImageWithID();
        ImageView imageView = new ImageView(imagenIndividuo);
        imageView.setFitWidth(rect.getWidth());
        imageView.setFitHeight(rect.getHeight());

        // Actualizar el GridPane
        GridPane parent = (GridPane) rect.getParent();
        parent.getChildren().remove(rect);
        parent.add(imageView, GridPane.getColumnIndex(rect), GridPane.getRowIndex(rect));

        // Actualizar la lógica del tablero
        int row = GridPane.getRowIndex(rect);
        int col = GridPane.getColumnIndex(rect);
        Casilla casilla = tablero.getCasilla(row, col);
        casilla.getListaIndividuos().add(individuo);
        tablero.getListaIndividuos().add(individuo);


    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al agregar individuo: " + e.getMessage());
    }
}
private void agregarRecurso(Recurso recurso, Rectangle rect) {
    try {
        // Crear y configurar ImageView
        Image imagenRecurso = recurso.getImageWithID();
        ImageView imageView = new ImageView(imagenRecurso);
        imageView.setFitWidth(rect.getWidth());
        imageView.setFitHeight(rect.getHeight());

        // Actualizar el GridPane
        GridPane parent = (GridPane) rect.getParent();
        parent.getChildren().remove(rect);
        parent.add(imageView, GridPane.getColumnIndex(rect), GridPane.getRowIndex(rect));

        // Actualizar la lógica del tablero
        int row = GridPane.getRowIndex(rect);
        int col = GridPane.getColumnIndex(rect);
        Casilla casilla = tablero.getCasilla(row, col);
        casilla.getListaRecursos().add(recurso);

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al agregar recurso: " + e.getMessage());
    }

}

@FXML
private void onPauseButtonClick() {
    juegoPausado = true;

    if (timeline != null) {
        timeline.stop();
    }
}
@FXML
private void mostrarRecursos(Rectangle rect, double screenX, double screenY) {
    ContextMenu contextMenu = new ContextMenu();

    // Itera sobre la matriz y crea un MenuItem para cada recurso
    for (int i = 0; i < tablero.getMatriz().getNumeroElementos(); i++) {
        Casilla casilla = (Casilla) tablero.getMatriz().getElemento(i).getData();
        ListaEnlazada copia = new ListaEnlazada<>();
        copia.copiarLista(casilla.getListaRecursos());

        // Itera sobre la lista copia y crea un MenuItem para cada recurso
        for (int j = 0; j < copia.getNumeroElementos(); j++) {
            Recurso recurso = (Recurso) copia.getElemento(j).getData();
            MenuItem menuItem = new MenuItem(recurso.getClass().getSimpleName() + " - ID: " + recurso.getID());

            // Configura el evento para cada MenuItem
            menuItem.setOnAction(event -> {
              //agregar nuevo recurso en la nueva celda y eliminar ese recurso de la antigua celda
            });

            // Agrega el MenuItem al menú contextual
            contextMenu.getItems().add(menuItem);
        }
    }

    // Muestra el menú contextual en la posición donde se mostró el menú 2
    contextMenu.show(rect, screenX, screenY);
}


@FXML
private void onContinueButtonClick() {
    juegoPausado = false;
    timeline.play();

}
@FXML
public void onStartGameButtonClick() {
    juegoEnCurso = true;
    if (timeline == null) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }
    timeline.play();
    playButton.setDisable(false);
    pauseButton.setDisable(false);
    stopButton.setDisable(false);
    //lamar al tablero.bucleControl()

}

private void updateTimer() {
    secondsElapsed++;
    timerLabel.setText("Time: " + secondsElapsed + " seconds");
}

@FXML
public void initialize() {
    initializeChoiceBox();
}

private void initializeChoiceBox() {
    choiceBoxIndividuos = new ChoiceBox<>();
    choiceBoxIndividuos.getItems().addAll("Individuo Normal", "Individuo Básico", "Individuo Avanzado");
}


}