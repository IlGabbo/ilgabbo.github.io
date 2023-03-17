package com.gabbo.calculator.calculator;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



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
                    history.setText(operation);
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

    private void calc(String operation) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("rhino");
        String op = "40+2";
        try {
            System.out.println(engine.eval(op));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

}
