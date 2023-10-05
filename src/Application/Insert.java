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
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Eksamensafvikling ikke fundet");
                alert.showAndWait();
            }
            else if (e.getMessage().contains("fk_studID")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Studerende ikke fundet");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Ukendt Foreign Key Fejl");
                alert.showAndWait();
                break;
            }
            }
                case 2627: {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Eksamensforsøg allerede oprettet");
                    alert.showAndWait();
                    break;
                }
                default: {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            };
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}
