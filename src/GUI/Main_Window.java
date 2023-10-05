package GUI;

import Application.Connection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_Window extends Application {

    @Override
    public void start(Stage stage) {

        initStage(stage);
        new Login_Window().showAndWait();

        if(Connection.isConnected){
            initStageContent(stage);
        }
        else{
            stage.close();
        }
    }

    private void initStage(Stage stage){

        VBox vbxMain = new VBox(10);
        vbxMain.setAlignment(Pos.TOP_CENTER);
        //vbxMain.getChildren().addAll(lblPkName, txfPackageName, hbxNavigation, lblSpacer, txaDescription);

        BorderPane borderPane = new BorderPane();

        BorderPane.setAlignment(vbxMain, Pos.TOP_CENTER);
        BorderPane.setMargin(vbxMain, new Insets(12, 12, 12, 12));
        borderPane.setCenter(vbxMain);

        /**
        BorderPane.setAlignment(btnConfirm, Pos.BASELINE_CENTER);
        BorderPane.setMargin(btnConfirm, new Insets(12, 12, 12, 12));
        borderPane.setBottom(btnConfirm);
        **/

        Scene scene = new Scene(borderPane, 700, 700);

        stage.setTitle("OO_DAOS_2023");
        stage.setScene(scene);
        stage.show();
    }

    private void initStageContent(Stage stage){



    }
}
