package Application;

import javafx.scene.control.Alert;

public abstract class Utility {

    public static void errorAlert(String alertMsg){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertMsg);
        alert.showAndWait();
    }

}
