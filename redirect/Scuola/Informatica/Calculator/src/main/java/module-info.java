module com.gabbo.calculator.calculator {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                    requires org.kordamp.bootstrapfx.core;
    requires java.scripting;

    opens com.gabbo.calculator.calculator to javafx.fxml;
    exports com.gabbo.calculator.calculator;
}