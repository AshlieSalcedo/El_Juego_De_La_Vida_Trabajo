module org.example.el_juego_de_la_vida {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens Controlador to javafx.fxml;
    exports Controlador;
}