module com.gabbo.hardwaremonitor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.gabbo.hardwaremonitor to javafx.fxml;
    exports com.gabbo.hardwaremonitor;
}