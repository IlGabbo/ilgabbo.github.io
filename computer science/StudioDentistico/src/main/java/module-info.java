module com.gabbo.dentista {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.security.jgss;
    requires json.simple;

    opens com.gabbo.dentista to javafx.fxml;

    exports com.gabbo.dentista;
}