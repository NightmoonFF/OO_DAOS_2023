package Application;

import Models.ExamAttempt;
import Models.ExamInstance;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Insert {

    //TODO: Will not create Attempt if Grade is -3
    public static boolean createExamAttempt(ExamAttempt examAttempt){
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
            return true;
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            { case 547 : {if (e.getMessage().contains("fk_afviklID")) {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Eksamensafvikling ikke fundet");
                return false;
            }
            else if (e.getMessage().contains("fk_studID")) {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Studerende ikke fundet");
                return false;
            }
            else {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Ukendt Foreign Key Fejl");
                return false;
            }
            }
                case 2627: {
                    System.out.println("fejl:  "+e.getMessage());
                    Utility.errorAlert("Eksamensforsøg allerede oprettet");
                    return false;
                }
                default: {
                    System.out.println("fejl:  "+e.getMessage());
                    Utility.errorAlert(e.getMessage());
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return false;
        }
    }

    public static boolean createExamInstance(ExamInstance examInstance){
        try {

            String sql = "insert into eksamensAfvikling values (?,?,?,?,?)";

            PreparedStatement ps = Connection.minConnection.prepareStatement(sql);

            ps.clearParameters();
            ps.setInt(1, examInstance.getAfviklID());
            ps.setString(2, examInstance.getTermin());
            ps.setDate(3, examInstance.getStartDato());
            ps.setDate(4, examInstance.getSlutDato());
            ps.setInt(5, examInstance.getFk_eksID());
            ps.execute();
            return true;
        }
        catch (SQLException e) {
            switch (e.getErrorCode())
            { case 547 : {if (e.getMessage().contains("fk_eksID")) {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Eksamen ikke fundet");
                return false;
            }
            else {
                System.out.println("fejl:  "+e.getMessage());
                Utility.errorAlert("Ukendt Foreign Key Fejl");
                return false;
            }
            }
                case 2627: {
                    System.out.println("fejl:  "+e.getMessage());
                    Utility.errorAlert("Eksamensafvikling allerede oprettet");
                    return false;
                }
                default: {
                    System.out.println("fejl:  "+e.getMessage());
                    Utility.errorAlert(e.getMessage());
                    return false;
                }
            }
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return false;
        }
    }

}
