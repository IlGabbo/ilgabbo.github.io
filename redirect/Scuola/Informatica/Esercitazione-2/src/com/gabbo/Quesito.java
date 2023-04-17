package com.gabbo;
import java.util.Objects;
import java.util.Scanner;

public class Quesito {
    String dom;
    String answer;
    int score = 0;
    public Quesito(String dom, String answer, int score) {
        this.dom = dom;
        this.answer = answer;
        this.score = score;
    }
    Scanner k = new Scanner(System.in);
    public int ask() {
        System.out.println(dom);
        String answer = k.next();
        if (Objects.equals(this.answer, answer)) {
            return this.score;
        }
        return 0;
    }
}
