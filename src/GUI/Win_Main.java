package GUI;

import Application.Connection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Win_Main extends Application {

    BorderPane rootPane;

    @Override
    public void start(Stage stage) {

        initStage(stage);
        new Win_Login().showAndWait();

        if(Connection.isConnected){
            initStageContent(stage);
        }
        else{
            stage.close();
        }
    }

    private void initStage(Stage stage){

        rootPane = new BorderPane();
        Scene scene = new Scene(rootPane, 700, 700);
        stage.setTitle("OO_DAOS_2023");
        stage.setScene(scene);
        stage.show();
    }

    private void initStageContent(Stage stage){

        VBox vbxMain = new VBox(10);
        vbxMain.setAlignment(Pos.TOP_CENTER);
        //vbxMain.getChildren().addAll(lblPkName, txfPackageName, hbxNavigation, lblSpacer, txaDescription);

        BorderPane.setAlignment(vbxMain, Pos.TOP_CENTER);
        BorderPane.setMargin(vbxMain, new Insets(12, 12, 12, 12));
        rootPane.setCenter(vbxMain);

        // Border bottom
//        BorderPane.setAlignment(btnConfirm, Pos.BASELINE_CENTER);
//        BorderPane.setMargin(btnConfirm, new Insets(12, 12, 12, 12));
//        rootPane.setBottom(btnConfirm);

        Button btnCreateExamAttempt = new Button("Opret Eksamensforsøg");
        vbxMain.getChildren().add(btnCreateExamAttempt);

        Button btnCreateExamSettlement = new Button("Opret Eksamensafvikling");
    }
}
