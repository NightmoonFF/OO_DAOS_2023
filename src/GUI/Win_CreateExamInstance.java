package GUI;

import Application.Insert;
import Application.Select;
import Application.Utility;
import Application.Validation;
import Models.Exam;
import Models.ExamInstance;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.Date;

public class Win_CreateExamInstance extends Stage {

    public Win_CreateExamInstance(){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(true);
        this.setTitle("Opret Eksamensforsøg");
        this.requestFocus();
        GridPane pane = new GridPane();
        this.initGUI(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    ComboBox<Exam> cbxExam;
    TextField txfSemester;
    DatePicker dpStart;
    DatePicker dpEnd;

    private void initGUI(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblExam = new Label("Eksamen:");
        cbxExam = new ComboBox<>();
        Label lblSemester = new Label("Termin:");
        txfSemester = new TextField();
        Label lblStart = new Label("Start Dato:");
        dpStart = new DatePicker();
        Label lblEnd = new Label("Slut Dato:");
        dpEnd = new DatePicker();
        Button btnConfirm = new Button("Opret");

        pane.add(lblExam, 0, 0);
        pane.add(cbxExam, 0, 1);
        pane.add(lblSemester, 0, 2);
        pane.add(txfSemester, 0, 3);
        pane.add(lblStart, 0, 4);
        pane.add(dpStart, 0, 5);
        pane.add(lblEnd, 0, 6);
        pane.add(dpEnd, 0, 7);
        pane.add(btnConfirm, 0, 8);

        cbxExam.getItems().addAll(Select.getAllExams());
        cbxExam.setPromptText("---");
        txfSemester.setPromptText("---");

        btnConfirm.setOnAction(event -> btnConfirmAction());
    }

    private void btnConfirmAction(){

        if (!Validation.nullValidation(Select.getNewExamInstanceID(), "Intern ID Oprettelse")) { return; }
        if (!Validation.nullValidation(cbxExam.getValue(), "Eksamen")) { return; }
        if (!Validation.nullValidation(txfSemester.getText(), "Termin")) { return; }
        if (!Validation.nullValidation(dpStart.getValue(), "Start Dato")) { return; }
        if (!Validation.nullValidation(dpEnd.getValue(), "Slut Dato")) { return; }
        if(txfSemester.getText() == "") { Utility.errorAlert("Semester er ikke udfyldt"); return;}

        ExamInstance examInstance = new ExamInstance(
                Select.getNewExamInstanceID(),
                txfSemester.getText(),
                Date.valueOf(dpStart.getValue()),
                Date.valueOf(dpEnd.getValue()),
                cbxExam.getValue().getEksID()
        );

       if(Insert.createExamInstance(examInstance)){
           Utility.successAlert("Eksamensavfklaring Oprettet i Databasen!");
           this.close();

       }

    }

}
