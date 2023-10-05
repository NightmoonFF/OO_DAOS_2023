import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Login {
            public static void connect() {
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
