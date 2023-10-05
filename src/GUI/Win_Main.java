package GUI;

import Application.Connection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Win_Main extends Application {

    BorderPane rootPane;
    Label lblNotifier;
    ListView lvwDisplay;

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

        //region Opgave-Buttons
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
        //endregion

        //region HBOX for Select-Buttons
        Label lblSpacer = new Label();
        vbxMain.getChildren().add(lblSpacer);

        Label lblShow = new Label("Vis Alle:");
        vbxMain.getChildren().add(lblShow);


        HBox hbxSelects = new HBox(20);
        vbxMain.getChildren().add(hbxSelects);
        hbxSelects.setAlignment(Pos.BASELINE_CENTER);

        Button btnSelectExamAttempts = new Button("Eksamensforsøg");
        btnSelectExamAttempts.setOnAction(event -> btnSelectExamAttemptsAction());
        hbxSelects.getChildren().add(btnSelectExamAttempts);

        Button btnSelectExamInstances = new Button("Eksamensafviklinger");
        btnSelectExamInstances.setOnAction(event -> btnSelectExamInstancesAction());
        hbxSelects.getChildren().add(btnSelectExamInstances);

        Button btnSelectStudents = new Button("Studerende");
        btnSelectStudents.setOnAction(event -> btnSelectStudentsAction());
        hbxSelects.getChildren().add(btnSelectStudents);
        //endregion

        Label lblSpacer2 = new Label();
        vbxMain.getChildren().add(lblSpacer2);

        lblNotifier = new Label();
        vbxMain.getChildren().add(lblNotifier);

        lvwDisplay = new ListView();
        vbxMain.getChildren().add(lvwDisplay);
        lvwDisplay.setEditable(false);
        lvwDisplay.setFocusTraversable(false);


    }

    private void btnCreateExamAttemptAction(){
        new Win_CreateExamAttempt().showAndWait();
        lvwDisplay.getItems().clear();
    }

    private void btnCreateExamInstanceAction(){

        lvwDisplay.getItems().clear();
    }

    private void btnGetStudentsForExamAction(){

        lvwDisplay.getItems().clear();
    }


    private void btnSelectExamAttemptsAction(){
        lblNotifier.setText("Alle Eksamensforsøg i Databasen:");
        lvwDisplay.getItems().clear();
    }
    private void btnSelectExamInstancesAction(){
        lblNotifier.setText("Alle Eksamensafviklinger i Databasen:");
        lvwDisplay.getItems().clear();

    }
    private void btnSelectStudentsAction(){
        lblNotifier.setText("Alle Studerende i Databasen:");
        lvwDisplay.getItems().clear();
    }
}
