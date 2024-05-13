package org.example.el_juego_de_la_vida;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TableroController {

    @FXML
    private void onPauseButtonClick() {
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