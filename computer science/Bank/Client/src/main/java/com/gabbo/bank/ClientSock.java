package com.gabbo.bank;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;


public class ClientSock {
    static Socket s2 = null;

    public static boolean init() {
        try {
            s2 = new Socket("192.168.1.96", 4444);
            return true;
        } catch (Exception e) {
            // e.printStackTrace();
            return false;
        }
    }

    public static String login(String username, String password) {
        try {
            OutputStream output = s2.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeUTF(username + " " + password);
            data.flush();
            InputStream input_stream = s2.getInputStream();
            DataInputStream data2 = new DataInputStream(input_stream);
            String msg = data2.readUTF();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error while login";
        }
    }

    public static String getBalance() {
        try {
            InputStream in = s2.getInputStream();
            DataInputStream data = new DataInputStream(in);
            return data.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public static String sendCmd(String cmd, String value) {
        String response = null;
        try {
            OutputStream output = s2.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeUTF(cmd + " " + value);
            data.flush();
            InputStream input_stream = s2.getInputStream();
            DataInputStream data2 = new DataInputStream(input_stream);
            String msg = data2.readUTF();
            response = msg;
        } catch (IOException e) {
            response = "Error";
        }

        return response;
    }
}
