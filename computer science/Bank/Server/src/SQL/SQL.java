package SQL;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQL {
    static Connection conn = null;

    private static void errorlog(String filename, String errors) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String path = "C:\\Bank Service\\logs\\";
            BufferedWriter out = new BufferedWriter(new FileWriter(path + filename, true));
            out.write(errors + "            " + formatter.format(date));
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


    public static boolean connectDb(String db) {
        String db_path = "C:\\Bank Service\\User\\";
        boolean status;
        try {
            if (Files.notExists(Paths.get(db_path))) {
                new File("C:\\Bank Service\\User").mkdirs();
            }
            if (Files.notExists(Paths.get("C:\\Bank Service\\logs\\"))) {
                new File("C:\\Bank Service\\logs\\").mkdirs();
            }
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Bank Service\\User\\" + db + ".db");
            createTable();
            status = true;
        } catch (Exception e) {  // blu arancione viola giallo marrone giallo
            errorlog("error.log", e.getMessage()+"\n");
            print("Error on connectDb (SQL) function");
            status = false;
        }

        return status;
    }

    public static String createTable() {
        String user_sql = "CREATE TABLE IF NOT EXISTS user(user, password)";
        String list_sql = "CREATE TABLE IF NOT EXISTS movement_list(action)";
        String balance = "CREATE TABLE IF NOT EXISTS balance(value)";
        String status = null;
        try {
            Statement stat = conn.createStatement();
            stat.execute(user_sql);
            stat.execute(list_sql);
            stat.execute(balance);
            status = "New tables created";
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on createDb (SQL) function");
        }
        return status;
    }


    public static void insertCredentials(String username, String password) {
        String sql_insert_crd = "INSERT INTO user(user, password) VALUES (?, ?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql_insert_crd);
            stat.setString(1, username);
            stat.setString(2, password);
            stat.executeUpdate();
            print("Values added");
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on insertCredentials (SQL) function");
        }
    }

    public static boolean insertAction(String action) {
        String sql_action = "INSERT INTO movement_list(action) VALUES (?)";
        boolean status;
        try {
            PreparedStatement stat = conn.prepareStatement(sql_action);
            stat.setString(1, action);
            stat.executeUpdate();
            status = true;
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on insertAction (SQL) function");
            status = false;
        }
        return status;
    }

    public static boolean login(String user, String password) {
        if (connectDb("gabbo")) {
            String sql_login = "SELECT * FROM user";
            boolean isLogged = false;
            try {
                Statement stat = conn.createStatement();
                ResultSet result = stat.executeQuery(sql_login);
                while (result.next()) {
                    if (result.getString("user").equals(user) && result.getString("password").equals(password)) {
                        isLogged = true;
                        break;
                    } else {
                        isLogged = false;
                    }
                }
            } catch (Exception e) {
                errorlog("error.log", e.getMessage());
                print("Error on login (SQL) function");
            }
            return isLogged;
        } else {
            return false;
        }
    }

    public static boolean cashAction(String value, String action) {
        String sql_get_current_balance = "SELECT * FROM balance";
        String sql_remove_previous_balance = "DELETE FROM balance";
        String sql_deposit = "INSERT INTO balance(value) VALUES (?)";
        try {
            Statement get_balance = conn.createStatement();
            ResultSet result = get_balance.executeQuery(sql_get_current_balance);
            float new_balance = 0;
            if (action.equalsIgnoreCase("deposit")) {
                if (result.getString("value") == null) {
                    new_balance = 0 + Float.parseFloat(value);
                    insertAction("Depositati->€"+value);
                } else {
                    new_balance = Float.parseFloat(result.getString("value")) + Float.parseFloat(value);
                    insertAction("Depositati->€"+value);
                }

            } else {
                if (result.getString("value") == null) {
                    new_balance = 0 - Float.parseFloat(value);
                    insertAction("Prelevati->€"+value);
                } else {
                    new_balance = Float.parseFloat(result.getString("value")) - Float.parseFloat(value);
                    insertAction("Prelevati->€"+value);
                }
            }
            PreparedStatement remove_stat = conn.prepareStatement(sql_remove_previous_balance);
            remove_stat.executeUpdate();
            PreparedStatement deposit_stat = conn.prepareStatement(sql_deposit);
            deposit_stat.setString(1, String.valueOf(new_balance));
            deposit_stat.executeUpdate();
            return true;
        } catch (SQLException e) {
            errorlog("error.log", e.getMessage());
            print("Error on cashAction (SQL) function");
            return false;
        }
    }

    public static String showBalance() {
        String sql_balance = "SELECT * FROM balance";
        try {
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(sql_balance);
            return result.getString("value");
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on showBalance (SQL) function");
            return "Error while reading balance";
        }
    }

    public static String readFromTable(String table, String type) {  // Accepted types: user, action; tables: user, action
        String sql_read = String.format("SELECT * FROM %s", table);
        String rs = "";

        try {
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(sql_read);
            if (type.equals("user")) {
                while (result.next()) {
                    rs = result.getString("user") + " " + result.getString("password");
                    print(rs);
                }
            } else if (type.equals("action")) {
                while (result.next()) {
                    rs = rs + result.getString("action") + "\n";
                }
            } else {
                print("Unknown type, exit...");
                System.exit(-1);
            }
        } catch (Exception e) {
            errorlog("error.log", e.getMessage());
            print("Error on readFromTable (SQL) function");
            rs = "Error";
        }

        return rs;
    }

    public static void del() {
        String sql = "DELETE FROM movement_list";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
