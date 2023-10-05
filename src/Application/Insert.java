package Application;

import Models.ExamAttempt;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Insert {

    public static void createExamAttempt(ExamAttempt examAttempt){
        try {

            String sql = "insert into eksamensForsøg values (?,?,?,?,?,?,?)";

            PreparedStatement ps = Connection.minConnection.prepareStatement(sql);

            ps.clearParameters();
            ps.setInt(1, examAttempt.getForsøgsID());
            ps.setInt(2, examAttempt.getKarakter());
            ps.setString(3, examAttempt.getAdmBedøm());
            ps.setInt(4, examAttempt.getForsøgsNr());
            ps.setDate(5, examAttempt.getDato());
            ps.setInt(6, examAttempt.getFk_afviklID());
            ps.setInt(7, examAttempt.getFk_studID());
            ps.execute();
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            { case 547 : {if (e.getMessage().contains("fk_afviklID")) {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Eksamensafvikling ikke fundet");
            }
            else if (e.getMessage().contains("fk_studID")) {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Studerende ikke fundet");
            }
            else {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Ukendt Foreign Key Fejl");
                break;
            }
            }
                case 2627: {
                    System.out.println("fejl:  "+e.getMessage());
                    Utility.errorAlert("Eksamensforsøg allerede oprettet");
                    break;
                }
                default: {
                    System.out.println("fejl:  "+e.getMessage());
                    Utility.errorAlert(e.getMessage());
                }
            };
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
        }
    }

}
