package org.example.el_juego_de_la_vida;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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

public class TableroController {
    @FXML
    private Label TitleText;

    @FXML
    private GridPane gridPaneTablero;

    public void generateBoard(int rows, int cols) {
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
                Rectangle rect = new Rectangle(30, 30);
                if ((row + col) % 2 == 0) {
                    rect.setFill(Color.AQUA);  // Azul claro
                } else {
                    rect.setFill(Color.AZURE);  // Azul
                }
                rect.widthProperty().bind(gridPaneTablero.widthProperty().divide(cols));
                rect.heightProperty().bind(gridPaneTablero.heightProperty().divide(rows));
                gridPaneTablero.add(rect, col, row);
            }
        }
    }

    @FXML
    private void onPauseButtonClick() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pausa");
        alert.setHeaderText("El juego está pausado");
        alert.setContentText("¿Qué deseas hacer?");

        ButtonType continuarButton = new ButtonType("Continuar");
        ButtonType configuracionButton = new ButtonType("Ver configuración");
        alert.getButtonTypes().setAll(continuarButton, configuracionButton);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == continuarButton) {
                alert.close();
            } else if (buttonType == configuracionButton) {
                Stage tableroStage = (Stage) TitleText.getScene().getWindow();
                tableroStage.close();
                alert.close();
                openConfiguracionWindow();
            }
        });
    }

    private void openConfiguracionWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("configuracion.fxml"));
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