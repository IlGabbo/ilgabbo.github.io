package com.gabbo.bank;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLogged {
    String user;
    public UserLogged(String user) {
        this.user = user;
    }
    public void launchSession(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("logged.fxml")));
        Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        ClientSock sock = new ClientSock();
        AppController controller = new AppController();

        Button withdrawal = (Button) scene.lookup("#withdrawal");
        Button deposit = (Button) scene.lookup("#deposit");
        Button movement_list = (Button) scene.lookup("#movement_list");
        Button exit = (Button) scene.lookup("#exit");
        ScrollPane movement_box = (ScrollPane) scene.lookup("#movement_box");
        VBox list_box = (VBox) scene.lookup("#list_box");
        Pane actions_box = (Pane) scene.lookup("#actions_box");

        Label balance = (Label) scene.lookup("#balance");
        balance.setText("€" + sock.getBalance());



        movement_box.setVisible(false);
        actions_box.setVisible(false);

        withdrawal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.showActionPane("withdrawal", actions_box, scene);
            }
        });

        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.showActionPane("deposit", actions_box, scene);
            }
        });

        movement_list.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String actions = sock.sendCmd("mv_list", "");
                String[] actions_split = actions.split("\n");
                movement_box.setVisible(true);
                list_box.getChildren().clear();
                for (int i = 0; i < actions_split.length; i++) {
                    if (actions_split[i] != null) {
                        Button action = new Button(actions_split[i]);
                        action.setPrefWidth(200.0);
                        list_box.getChildren().add(action);
                    }
                }
                movement_box.setContent(list_box);
                }
            });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        appStage.setScene(scene);
        appStage.setResizable(false);
        appStage.setTitle("Welcome, " + user);
        appStage.getIcons().add(new Image("https://pbs.twimg.com/media/FfcccGkXEAIvfEW.png"));
        appStage.show();
    }
}
