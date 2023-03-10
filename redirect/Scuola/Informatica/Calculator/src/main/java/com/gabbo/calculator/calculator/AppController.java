package com.gabbo.calculator.calculator;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import


public class AppController {
    @FXML
    private Label result, history;
    private Button close_button;
    private Button percent_button;
    private Button ce_button;
    private Button c_button;
    private Button delete_button;
    private Button onedividedx_button;
    private Button raisedtosecond_button;
    private Button square_button;
    private Button zero, one, two, three, four, five, six, seven, eight, nine, plus_or_minus, comma;
    private Button calc, addiction_button, subtraction_button, multiplication_button, division_button;
    private String operation = "";
    private String displayed_operation = "";


    @FXML
    private void getButtonValue(Event e) {
        Object node = e.getSource();
        Button btn = (Button) node;
        String button_text = btn.getText();
        String button_id = btn.getId();
        switch (button_id) {
            case "calc" -> {
                if (operation != "0") {
                    history.setText(operation);
                    result.setText("0");
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
                        StringBuffer sb = new StringBuffer(operation);
                        sb.deleteCharAt(sb.length() - 1);
                        operation = sb.toString();
                    } catch (StringIndexOutOfBoundsException ev) {
                        System.out.println("error");
                        result.setText("0");
                    }
                }

            }
            case "onedividedx_button" -> {}
            case "raisedtosecond_button" -> {}
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

    private void calc() {
        String symbols = "[+\\-*/^v]";
    }

}
