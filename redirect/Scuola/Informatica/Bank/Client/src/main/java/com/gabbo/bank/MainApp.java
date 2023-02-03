package com.gabbo.bank;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class MainApp extends Application {
    public static void labelStyle(Label err) {
        err.setTextFill(Color.color(1,0,0));
        err.setText("Network error, retry later");
    }
    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login.fxml"));
        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml")), 800, 500);

        AppController controller = new AppController();
        TextField username = (TextField) scene.lookup("#username");
        PasswordField password = (PasswordField) scene.lookup("#password");
        Label label_error = (Label) scene.lookup("#error");
        Button login_button = (Button) scene.lookup("#login_button");


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ClientSock socket = new ClientSock();
                if(!socket.init()) {
                    labelStyle(label_error);
                }
            }
        });

        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!controller.checkForEmptyValues(username.getText(), password.getText())) {
                    label_error.setText("Fill all fields");
                } else {
                    if (!controller.login(username.getText(), password.getText())) {
                        label_error.setText("Wrong credentials");
                    } else {
                        try {
                            new UserLogged(username.getText()).launchSession(actionEvent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("Bank service - Login");
        stage.setResizable(false);
        stage.getIcons().add(new Image("https://pbs.twimg.com/media/FfcccGkXEAIvfEW.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

