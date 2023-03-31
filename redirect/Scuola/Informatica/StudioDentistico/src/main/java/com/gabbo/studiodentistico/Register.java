package com.gabbo.studiodentistico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {
    private Stage stage = new Stage();
    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Register.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    public void close() {
        stage.close();
    }
}
