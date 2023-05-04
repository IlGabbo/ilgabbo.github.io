package com.gabbo.studiodentistico;

import java.io.*;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;

public class FileManager {
    String filename;
    public FileManager(String filename) {
        this.filename = filename;
    }

    public <U> void manage(String mode, U content) {
        switch (mode) {
            case "w" -> {
                try {
                    BufferedWriter file = new BufferedWriter(new FileWriter(this.filename));
                    file.write(String.valueOf(content));
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            case "r" -> {
                try {
                    BufferedReader file = new BufferedReader(new FileReader(this.filename));
                    Stream<String> lines = file.lines();
                    String data = lines.collect(Collectors.joining("\n"));
                    lines.close();
                    file.close();
                    System.out.println(data);
                } catch (IOException e) {
                    manage("w", new JSONArray());
                }
            }
            case "a" -> {
                try {
                    BufferedWriter file = new BufferedWriter(new FileWriter(this.filename, true));
                    file.write(String.valueOf(content));
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            default -> {}
        }
    }
}
