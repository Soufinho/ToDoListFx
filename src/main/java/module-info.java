module appli.javafxtodolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens appli to javafx.fxml;
    exports appli;
    exports appli.Accueil;
    opens appli.Accueil to javafx.fxml;
}