package com.gabbo.dentista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import java.io.File;
import java.io.IOException;


public class AppStartup extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        File f = new File("file.json");
        if (!f.exists()) {
            System.out.println("File does not exists");
            FileManager file = new FileManager("file.json");
            file.manage("w", new JSONArray());
        }
        FXMLLoader fxmlLoader = new FXMLLoader(AppStartup.class.getResource("MainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 768, 470);
        stage.setTitle("Studio Dentistico Rossi");
        stage.setScene(scene);
        stage.getIcons().add(new Image("https://media.tenor.com/TbUEIHfVoRcAAAAC/valentino-rossi-rossi.gif"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
