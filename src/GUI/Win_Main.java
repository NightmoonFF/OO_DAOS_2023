package GUI;

import Application.Connection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

        Label lblEx1 = new Label("Opgave 8.a");
        vbxMain.getChildren().add(lblEx1);

        Button btnCreateExamAttempt = new Button("Opret Eksamensforsøg");
        btnCreateExamAttempt.setOnAction(event -> btnCreateExamAttemptAction());
        vbxMain.getChildren().add(btnCreateExamAttempt);

        Label lblEx2 = new Label("Opgave 8.b");
        vbxMain.getChildren().add(lblEx2);

        Button btnCreateExamInstance = new Button("Opret Eksamensafvikling");
        btnCreateExamInstance.setOnAction(event -> btnCreateExamInstanceAction());
        vbxMain.getChildren().add(btnCreateExamInstance);

        Label lblEx3 = new Label("Opgave 8.c");
        vbxMain.getChildren().add(lblEx3);

        Button btnGetStudentsForExam = new Button("Hent Studerende for Eksamen/Termin");
        btnGetStudentsForExam.setOnAction(event -> btnGetStudentsForExamAction());
        vbxMain.getChildren().add(btnGetStudentsForExam);

        ////

        Label lblSpacer = new Label();
        vbxMain.getChildren().add(lblSpacer);

        Label lblShow = new Label("Vis Alle:");
        vbxMain.getChildren().add(lblShow);

        HBox hbxSelects = new HBox(10);
        vbxMain.getChildren().add(hbxSelects);

        Button btnSelectExamAttempts = new Button("Eksamensforsøg");
        btnSelectExamAttempts.setOnAction(event -> btnSelectExamAttemptsAction());
    }

    private void btnCreateExamAttemptAction(){
        new Win_CreateExamAttempt().showAndWait();
    }

    private void btnCreateExamInstanceAction(){

    }

    private void btnGetStudentsForExamAction(){

    }


    private void btnSelectExamAttemptsAction(){

    }
    private void btnSelectExamInstancesAction(){

    }
    private void btnSelectStudentsAction(){

    }
}
