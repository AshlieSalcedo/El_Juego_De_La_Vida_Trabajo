package Controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private void showConfiguracion() {
        try {
            Stage helloStage = (Stage) welcomeText.getScene().getWindow();
            helloStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controlador/configuracion.fxml"));
            Parent root = loader.load();
            Stage configuracion = new Stage();
            configuracion.setTitle("Configuración");
            configuracion.setScene(new Scene(root));
            configuracion.initModality(Modality.APPLICATION_MODAL);
            configuracion.initOwner(welcomeText.getScene().getWindow());
            configuracion.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        showConfiguracion();
    }
}