package Controlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class ConfiguracionController {
    @FXML
    private Label configuracion;


    @FXML
    private void showTablero() {
        try {
            Stage configuracionStage = (Stage) configuracion.getScene().getWindow();
            configuracionStage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Tablero.fxml"));
            Parent root = loader.load();
            Stage tablero = new Stage();
            tablero.setTitle("Tablero");
            tablero.setScene(new Scene(root));
            tablero.initModality(Modality.APPLICATION_MODAL);
            tablero.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onIniciarButtonClick() {
        showTablero();
    }
}