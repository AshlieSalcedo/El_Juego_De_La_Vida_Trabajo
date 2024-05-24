package org.example.el_juego_de_la_vida;

import Modelo.Tablero;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ConfiguracionController {
    @FXML
    private Label configuracion;

    @FXML
    private Slider sliderN;

    @FXML
    private Slider sliderM;




    private void showTablero(int n, int m) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tablero.fxml"));
            Parent root = loader.load();

            TableroController tableroController = loader.getController();
            tableroController.generateBoard(n, m);

            Stage tableroStage = new Stage();
            tableroStage.setTitle("Tablero");
            tableroStage.setScene(new Scene(root));
            tableroStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onIniciarButtonClick() {
        showTablero((int) sliderN.getValue(), (int) sliderM.getValue());
    }

}