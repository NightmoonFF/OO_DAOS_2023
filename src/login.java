import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
            public static void main(String[] args) {
                // Database-forbindelsesoplysninger
                String url = "jdbc:mysql://localhost:3306/din_database_navn";
                String brugernavn = "din_bruger";
                String adgangskode = "din_adgangskode";

                // Opret forbindelse til databasen
                try (Connection forbindelse = DriverManager.getConnection(url, brugernavn, adgangskode)) {
                    System.out.println("Forbindelse til databasen oprettet.");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
