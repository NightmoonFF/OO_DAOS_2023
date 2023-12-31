package Application;

import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {

    public static java.sql.Connection minConnection;
    public static Statement stmt;
    public static boolean isConnected = false;
    public static boolean connect(String dbName, String user, String password) {

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=" + dbName +
                    ";user=" + user + ";password=" + password + ";");
            stmt = minConnection.createStatement();
            isConnected = true;
            return true;
        }
        catch (Exception e){
            Utility.errorAlert(e.getMessage());
            return false;
        }

    }
}
