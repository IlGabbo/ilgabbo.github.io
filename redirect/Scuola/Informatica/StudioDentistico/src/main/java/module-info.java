module com.gabbo.studiodentistico {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.security.jgss;
    requires org.json;

    opens com.gabbo.studiodentistico to javafx.fxml;
    exports com.gabbo.studiodentistico;
}