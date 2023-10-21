package com.gabbo.javafxthread;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onThreadClick() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(i+1);
                        Thread.sleep(2000);
                    }
                } catch (java.lang.InterruptedException e) {
                    System.out.println(e);
                }
            }
        });
        t1.start();
    }
}