package Controlador;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TableroController implements Initializable {
    @FXML
    private Label TitleText;
    private static final int tam_cas = 40;       //tamaño de cada casilla
    private static final int ancho = 8;     //ancho del tablero
    private static final int largo = 8;     //largo del tablero

    @FXML
    private GridPane gridPane;
    private boolean isPaused = false;
    private ScheduledExecutorService scheduler;
    private long startTime;
    private Stage stage;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int fila=1; fila < largo+1; fila++) {
            for (int col=1; col < ancho+1; col++) {
                Rectangle casilla = new Rectangle(tam_cas, tam_cas);

                //crea un patrón similar al tablero de ajedrez, de dos colores
                casilla.setFill((fila + col) % 2 == 0 ? Color.AQUA : Color.AZURE);

            }
        }
        //Se crea un ScheduledExecutorService con un solo hilo
        scheduler = Executors.newScheduledThreadPool(1);
        //Se programa la tarea actualizar para realizarse cada 1 segundo
        scheduler.scheduleAtFixedRate(this::actualizar, 0, 1, TimeUnit.SECONDS);
        //Marca el tiempo inicial desde el que se abrió el tablero
        startTime = System.currentTimeMillis();
    }

    private void actualizar() {
        if (!isPaused) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            long elapsedSeconds = elapsedTime / 1000;

            Platform.runLater(() -> {
                if (stage != null) {
                    stage.setTitle("Tiempo transcurrido: " + elapsedSeconds + " segundos");
                }
            });
            //Aquí irán los métodos que actualizarán el estado de cada individuo
        }
    }


    @FXML
    public void onStopButtonClick() {
        isPaused = false;

    }

    @FXML
    public void onPlayButtonclick(){
        isPaused = false;
        startTime = System.currentTimeMillis();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    protected void mostrarNuevoTablero2x3(int fila, int col){
        Platform.runLater(() -> {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("celdaInterior.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 240, 100);
                //Asociamos el controlador de la casilla interior al nuevo fmxl
                CeldaInteriorController controllerCasilla = fxmlLoader.getController();

                controllerCasilla.setStage(stage);
                stage.setTitle("Casilla " + fila + "," + col);
                stage.setScene(scene);
                stage.show();


            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void onPauseButtonClick() {
        isPaused = true;
        // Mostramos un cuadro de diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pausa");
        alert.setHeaderText("El juego está pausado");
        alert.setContentText("¿Qué deseas hacer?");

        // Agregamos botones de opción al cuadro de diálogo
        ButtonType continuarButton = new ButtonType("Continuar");
        ButtonType configuracionButton = new ButtonType("Ver configuración");
        alert.getButtonTypes().setAll(continuarButton, configuracionButton);

        // Mostramos el cuadro de diálogo y esperamos la respuesta del usuario
        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == continuarButton) {
                // No hacemos nada, simplemente cerramos el cuadro de diálogo
                alert.close();
            } else if (buttonType == configuracionButton) {
                // Cerramos el cuadro de diálogo y abrimos la ventana de configuración
                Stage TableroStage = (Stage) TitleText.getScene().getWindow();
                TableroStage.close();
                alert.close();

                openConfiguracionWindow();
            }
        });
    }

    // Método para abrir la ventana de configuración tras dar click en ver configuración
    private void openConfiguracionWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Configuracion.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Configuración");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}