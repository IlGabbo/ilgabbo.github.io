package com.gabbo.calculator.calculator;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AppController {
    @FXML
    private Label result, history;
    private String operation = "";
    private String displayed_operation = "";



    @FXML
    private void getButtonValue(Event e) throws ScriptException {
        Object node = e.getSource();
        Button btn = (Button) node;
        String button_text = btn.getText();
        String button_id = btn.getId();
        switch (button_id) {
            case "calc" -> {
                if (operation != "0") {
                    history.setText(displayed_operation);
                    result.setText("0");
                    calc(operation);
                } else {
                    history.setText("");
                }

            }
            case "ce_button", "c_button" -> {
                operation = "";
                history.setText("");
                displayed_operation = "0";
            }
            case "delete_button" -> {
                if (result.getText() != "0") {
                    try {
                        operation = operation.substring(0, operation.length()-1);
                        displayed_operation = displayed_operation.substring(0, displayed_operation.length()-1);
                        result.setText(displayed_operation);
                    } catch (StringIndexOutOfBoundsException ev) {
                        System.out.println("error");
                        result.setText("0");
                    }
                }

            }
            case "onedividedx_button" -> {}
            case "raisedtosecond_button" -> {
                operation += "^2";
                displayed_operation += "²";
            }
            case "square_button" -> {
                operation += "√";
                displayed_operation += "√";
            }
            case "plus_or_minus" -> {
                operation += "-";
                displayed_operation += "-";
            }
            case "comma" -> {
                operation += ".";
                displayed_operation += ",";
            }
            case "multiplication_button" -> {
                operation += "*";
                displayed_operation += "x";
            }
            default -> {
                operation += button_text;
                displayed_operation += button_text;
            }
        }
        result.setText(displayed_operation);
        System.out.println(operation);
    }

    @FXML
    private void closeWindow() {
        System.exit(0);
    }

    private void calc(String operation) {
        String symbols = "[+\\-*/^√]";
        Pattern ptn = Pattern.compile((symbols));
        Matcher m = ptn.matcher(operation);
        if (m.find()) {

        } else {
            System.out.println("Not found");
        }
    }

}
