package com.gabbo.calculator.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class StartApplication extends Application {
    @FXML
    private double x, y;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 292, 500);
        Pane drag_bar = (Pane) scene.lookup("#drag_bar");
        Button minimize = (Button) scene.lookup("#minimize_button");
        Button close = (Button) scene.lookup("#close_button");

        drag_bar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                x = stage.getX() - mouseEvent.getScreenX();
                y = stage.getY() - mouseEvent.getScreenY();
            }
        });
        drag_bar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setX(mouseEvent.getScreenX() + x);
                stage.setY(mouseEvent.getScreenY() + y);
            }
        });
        minimize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setIconified(true);
            }
        });
        minimize.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                minimize.setStyle("-fx-background-color: #3b3b3b");
            }
        });
        minimize.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                minimize.setStyle("-fx-background-color: transparent");
            }
        });
        close.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                close.setStyle("-fx-background-color: red");
            }
        });
        close.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                close.setStyle("-fx-background-color: transparent");
            }
        });

        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/5/55/Windows_Calculator_icon.png"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}