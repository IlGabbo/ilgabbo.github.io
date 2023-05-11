package com.gabbo.studiodentistico;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FileManager {
    String filename;
    public FileManager(String filename) {
        this.filename = filename;
    }

    public JSONArray manage(String openmode, JSONArray content) {
        JSONArray status = new JSONArray();
        JSONObject key = new JSONObject();
        String st;
        switch (openmode) {
            case "w" -> {
                try {
                    BufferedWriter file = new BufferedWriter(new FileWriter(this.filename));
                    file.write(content.toJSONString());
                    file.close();
                    st = "SuccessfullyWritten";
                    key.put("status", st);
                    status.add(key);
                } catch (IOException e) {
                    e.printStackTrace();
                    st = "WriteError";
                    key.put("status", st);
                    status.add(key);
                }
            }
            case "r" -> {
                try {
                    BufferedReader file = new BufferedReader(new FileReader(this.filename));
                    Stream<String> lines = file.lines();
                    String data = lines.collect(Collectors.joining("\n"));
                    lines.close();
                    file.close();
                    try {
                        JSONParser parser = new JSONParser();
                        JSONArray arr = (JSONArray) parser.parse(data);
                        status = arr;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        key.put("status", "ParseError");
                        status.add(key);
                    }

                } catch (IOException e) {
                    manage("w", new JSONArray());
                    st = "ReadError";
                    key.put("status", st);
                    status.add(key);
                }
            }
            default -> {
                st = "sas";
                key.put("status", st);
                status.add(key);
            }
        }

        return status;
    }
}
