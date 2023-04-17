package com.gabbo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Quesito> q = new ArrayList<>();
        q.add(new Quesito("come mi chiamo", "gabbo", 10));
        q.add(new Quesito("come si chiama", "a", 2));

        for (int i = 0; i < q.size(); i++) {
            System.out.println(q.get(i).ask());
        }
    }
}
