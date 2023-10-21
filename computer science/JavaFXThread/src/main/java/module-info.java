module com.gabbo.javafxthread {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.gabbo.javafxthread to javafx.fxml;
    exports com.gabbo.javafxthread;
}