package org.example.el_juego_de_la_vida;

import Estructuras.Enlazada.ListaEnlazada;
import Modelo.*;
import Recurso.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
        tablero.setN(rows);
        tablero.setM(cols);
        tablero.crearTablero();
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
                tablero.getMatriz().add(new Casilla(row,col));
            }
        }

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
                ContextMenu contextMenu = new ContextMenu();
                MenuItem normalItem = new MenuItem("Individuo Normal");
                normalItem.setOnAction(e -> {
                    agregarIndividuo(new IndividuoNormal(parentRow, parentCol, 0.5, 0.5), rect);
                });

                MenuItem basicoItem = new MenuItem("Individuo Básico");
                basicoItem.setOnAction(e -> {
                    agregarIndividuo(new IndividuoBasico(parentRow, parentCol, 0.5, 0.5), rect);
                });

                MenuItem avanzadoItem = new MenuItem("Individuo Avanzado");
                avanzadoItem.setOnAction(e -> {
                    agregarIndividuo(new IndividuoAvanzado(parentRow, parentCol, 0.5, 0.5), rect);
                });

                MenuItem aguaItem = new MenuItem("Agua");
                aguaItem.setOnAction(e -> {
                    agregarRecurso(new Agua(parentRow, parentCol), rect);
                });

                MenuItem bibliotecaItem = new MenuItem("Biblioteca");
                bibliotecaItem.setOnAction(e -> {
                    agregarRecurso(new Biblioteca(parentRow, parentCol), rect);
                });

                MenuItem comidaItem = new MenuItem("Comida");
                comidaItem.setOnAction(e -> {
                    agregarRecurso(new Comida(parentRow, parentCol), rect);
                });

                MenuItem montanaItem = new MenuItem("Montaña");
                montanaItem.setOnAction(e -> {
                    agregarRecurso(new Montana(parentRow, parentCol), rect);
                });

                MenuItem pozoItem = new MenuItem("Pozo");
                pozoItem.setOnAction(e -> {
                    agregarRecurso(new Pozo(parentRow, parentCol), rect);
                });

                MenuItem tesoroItem = new MenuItem("Tesoro");
                tesoroItem.setOnAction(e -> {
                    agregarRecurso(new Tesoro(parentRow, parentCol), rect);
                });

                contextMenu.getItems().addAll(normalItem, basicoItem, avanzadoItem, aguaItem, bibliotecaItem, comidaItem, montanaItem, pozoItem, tesoroItem);
                ContextMenu contextMenu2 = new ContextMenu();
                MenuItem pregunta = new MenuItem("Mover recurso");
                pregunta.setOnAction(e -> {
                    mostrarRecursos(rect);
                });
                MenuItem normalItem2 = new MenuItem("Individuo Normal");
                normalItem.setOnAction(e -> {
                    agregarIndividuo(new IndividuoNormal(parentRow, parentCol, 0.5, 0.5), rect);
                });

                MenuItem basicoItem2= new MenuItem("Individuo Básico");
                basicoItem.setOnAction(e -> {
                    agregarIndividuo(new IndividuoBasico(parentRow, parentCol, 0.5, 0.5), rect);
                });

                MenuItem avanzadoItem2 = new MenuItem("Individuo Avanzado");
                avanzadoItem.setOnAction(e -> {
                    agregarIndividuo(new IndividuoAvanzado(parentRow, parentCol, 0.5, 0.5), rect);
                });

                MenuItem aguaItem2 = new MenuItem("Agua");
                aguaItem.setOnAction(e -> {
                    agregarRecurso(new Agua(parentRow, parentCol), rect);
                });

                MenuItem bibliotecaItem2 = new MenuItem("Biblioteca");
                bibliotecaItem.setOnAction(e -> {
                    agregarRecurso(new Biblioteca(parentRow, parentCol), rect);
                });

                MenuItem comidaItem2 = new MenuItem("Comida");
                comidaItem.setOnAction(e -> {
                    agregarRecurso(new Comida(parentRow, parentCol), rect);
                });

                MenuItem montanaItem2 = new MenuItem("Montaña");
                montanaItem.setOnAction(e -> {
                    agregarRecurso(new Montana(parentRow, parentCol), rect);
                });

                MenuItem pozoItem2 = new MenuItem("Pozo");
                pozoItem.setOnAction(e -> {
                    agregarRecurso(new Pozo(parentRow, parentCol), rect);
                });

                MenuItem tesoroItem2 = new MenuItem("Tesoro");
                tesoroItem.setOnAction(e -> {
                    agregarRecurso(new Tesoro(parentRow, parentCol), rect);
                });

                contextMenu2.getItems().addAll(normalItem2, basicoItem2, avanzadoItem2, aguaItem2, bibliotecaItem2, comidaItem2, montanaItem2, pozoItem2, tesoroItem2,pregunta);

                rect.setOnMouseClicked(e -> {
                    if (e.getButton() == MouseButton.SECONDARY) {
                        if (!juegoEnCurso) {
                            // Mostrar el menú 1 si el juego no ha comenzado
                            contextMenu.show(rect, e.getScreenX(), e.getScreenY());
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
            if (casilla == null) {
                casilla = new Casilla(row, col);
                tablero.getMatriz().add(casilla);
            }
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
            if (casilla == null) {
                casilla = new Casilla(row, col);
                tablero.getMatriz().add(casilla);
            }
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
    private void mostrarRecursos(Rectangle rect){
        ListaEnlazada copia = new ListaEnlazada<>();
        for(int i=0; i<tablero.getMatriz().getNumeroElementos();i++){
            Casilla casilla = (Casilla) tablero.getMatriz().getElemento(i).getData();
            copia.copiarLista(casilla.getListaRecursos());
        }
        ContextMenu contextMenu = new ContextMenu();
        for (int i = 0; i < copia.getNumeroElementos(); i++) {
            Recurso recurso = (Recurso) copia.getElemento(i).getData();
            MenuItem menuItem = new MenuItem(recurso.getClass().getSimpleName() + " - ID: " + recurso.getID());

            menuItem.setOnAction(e -> {
                System.out.println("Recurso seleccionado: " + recurso.getClass().getSimpleName() + " - ID: " + recurso.getID());
                // Aquí puedes agregar el código para manejar la selección del recurso
            });

            contextMenu.getItems().add(menuItem);
        }

        rect.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(rect, e.getScreenX(), e.getScreenY());
            }
        });
    }

    @FXML
    private void onContinueButtonClick() {
        juegoPausado = false;
        timeline.play();

    }
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