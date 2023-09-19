package com.gabbo.hardwaremonitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HardwareMonitor extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HardwareMonitor.class.getResource("sas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 739, 507);
        stage.setTitle("Giglo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}