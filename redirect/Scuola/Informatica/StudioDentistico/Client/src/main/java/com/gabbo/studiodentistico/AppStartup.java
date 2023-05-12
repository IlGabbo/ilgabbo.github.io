package com.gabbo.studiodentistico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppStartup extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppStartup.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 768, 470);
        stage.setTitle("Studio Dentistico Rossi");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
