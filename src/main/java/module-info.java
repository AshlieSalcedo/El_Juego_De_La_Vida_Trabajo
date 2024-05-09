module org.example.el_juego_de_la_vida {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.el_juego_de_la_vida to javafx.fxml;
    exports org.example.el_juego_de_la_vida;
}