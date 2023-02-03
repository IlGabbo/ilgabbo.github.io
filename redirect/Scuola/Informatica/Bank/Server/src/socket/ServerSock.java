package socket;

import SQL.SQL;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerSock {
    private int port;
    private ServerSocket server;

    static Socket s1 = null;

    static SQL sql = new SQL();

    private static void errorlog(String filename, String errors) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String path = "C:\\Bank Service\\logs\\";
            BufferedWriter out = new BufferedWriter(new FileWriter(path + filename, true));
            out.write(errors + "    " + formatter.format(date));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <Undefined> void print(Undefined ... args) {
        for (Undefined arg: args) {
            System.out.println(arg);
        }
    }

    public ServerSock(int port) {
        this.port = port;
        if (!startServer()) {
            System.out.println("Errore");
        }
    }

    private boolean startServer() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server online");
            return true;
        } catch (IOException e) {
            errorlog("error.log", e.getMessage());
            print("Error on startServer (Socket) function");
            return false;
        }
    }

    public void runServer() {
        try {
            s1 = server.accept();
            System.out.println(s1 + " connected");
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on runServer (Socket, handling connection) function");
            System.exit(0);
        }
        if (!sql.connectDb("gabbo")) {
            System.out.println("Error");
            System.exit(1);
        } /* else {
            sql.insertCredentials("gabbo", "gabry(22)");
        } */
        while (true) {
            try {
                InputStream input_stream = s1.getInputStream();
                DataInputStream data = new DataInputStream(input_stream);
                String msg = data.readUTF();
                if(login(msg.split("\\s+"))) {
                    break;
                }
            } catch (IOException e) {
                errorlog("error.log", e.getMessage());
                print("Error on startServer (Socket, get data) function");
                System.exit(1);
            }
        }
    }

    public boolean login(String credentials[]) {
        System.out.println(credentials[0] + " " + credentials[1]);
        boolean is_logged = false;
        if (sql.login(credentials[0], credentials[1])) {
            sendingResponse("true");
            is_logged = true;
            String balance = sql.showBalance();
            if (balance == null) {
                sendingResponse("0");
            } else {
                sendingResponse(sql.showBalance());
            }
            waitingFor();
        } else {
            sendingResponse("false");
            is_logged = false;
        }
        return is_logged;
    }

    public void waitingFor() {
        while (true) {
            try {
                InputStream input_stream = s1.getInputStream();
                DataInputStream data = new DataInputStream(input_stream);
                String msg = data.readUTF();
                System.out.println(msg);
                String[] command = msg.split("\\s+");
                if (command[0].equals("withdrawal")) {
                    withdrawal(command[1]);
                } else if (command[0].equals("deposit")) {
                    deposit(command[1]);
                } else if (command[0].equals("mv_list")) {
                    System.out.println("MV_LIST received");
                    mv_list();
                } else {
                    System.out.println("Error");
                }
            } catch (IOException e) {
                errorlog("error.log", e.getMessage());
                print("Error on waitingFor (Socket) function");
                System.exit(1);
            }

        }
    }

    public static void sendingResponse(String argument) {
        try {
            OutputStream output = s1.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeUTF(argument);
            data.flush();
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on sendingResponse (Socket) function");
        }
    }


    public static void withdrawal(String value) {
        if (sql.cashAction(value, "withdrawal")) {
            sendingResponse(sql.showBalance() + " " + sql.readFromTable("movement_list", "action"));
        }
    }

    public static void deposit(String value) {
        if (sql.cashAction(value, "deposit")) {
            sendingResponse(sql.showBalance() + " " + sql.readFromTable("movement_list", "action"));
        }
    }

    public static void mv_list() {
        sendingResponse(sql.readFromTable("movement_list", "action"));
    }

    public static void main(String[] args) {
        ServerSock ss = new ServerSock(4444);
        ss.runServer();
    }
}
