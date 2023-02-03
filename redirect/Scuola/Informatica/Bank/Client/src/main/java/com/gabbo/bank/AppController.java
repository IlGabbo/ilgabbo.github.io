package com.gabbo.bank;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.awt.EventQueue;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class AppController {
    ClientSock sock = new ClientSock();

    public boolean checkForEmptyValues(String username, String password) {
        boolean statement = true;
        if (username.equals("") || password.equals("")) {
            statement = false;
        }
        return statement;
    }

    public boolean login(String username, String password) {
        if (sock.login(username, password).equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void textStyleSheet(Label balance) {
        float value = Float.parseFloat(balance.getText());
        if (value <= 600 && value >= 201) {
            balance.setTextFill(Color.color(1, 1, 0));
        } else if (value < 200) {
            balance.setTextFill(Color.color(1, 0, 0));
        }
    }


    public void showActionPane(String action, Pane pane, Scene scene) {
        pane.setVisible(true);
        Button action_button = (Button) scene.lookup("#action");
        Button mv_list = (Button) scene.lookup("#movement_list");
        TextField value_import = (TextField) scene.lookup("#value_import");
        Label action_status = (Label) scene.lookup("#action_status");
        Label balance = (Label) scene.lookup("#balance");
        ClientSock socket = new ClientSock();
        final boolean[] network_error = {false};
        if (action.equalsIgnoreCase("withdrawal")) {
            action_button.setText("Pour");
            action_button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(moneyAction(value_import.getText(), action_status)) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                String bal = socket.sendCmd("withdrawal", value_import.getText());
                                String[] balnc = bal.split("\\s+");
                                balance.setText("€" + balnc[0]);
                                updateActions(scene, balnc[1]);
                            }
                        });
                    }
                }
            });
        } else if (action.equalsIgnoreCase("deposit")) {
            action_button.setText("Deposit");
            action_button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(moneyAction(value_import.getText(), action_status)) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                String bal = socket.sendCmd("deposit", value_import.getText());
                                String[] balnc = bal.split("\\s+");
                                balance.setText("€" + balnc[0]);
                                updateActions(scene, balnc[1]);  // Doesn't work
                            }
                        });
                    }
                }
            });
        }
    }

    public void updateActions(Scene scene, String values) {
        ScrollPane mv_box = (ScrollPane) scene.lookup("#movement_box");
        VBox list_box = (VBox) scene.lookup("#list_box");
        mv_box.setVisible(true);
        if (values != null && values.equalsIgnoreCase("")) {
            Button action = new Button(values);
            list_box.getChildren().add(action);
        }
        mv_box.setContent(list_box);
    }




    public boolean moneyAction(String amount, Label action_status) {
        if (isNumber(amount)) {
            action_status.setTextFill(Color.color(0,1,0));
            action_status.setText("Success");
            return true;
        } else {
            action_status.setTextFill(Color.color(1,0,0));
            action_status.setText("Type a number");
            return false;
        }
    }
}

