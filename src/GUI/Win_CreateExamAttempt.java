package GUI;

import Application.Insert;
import Application.Select;
import Application.Utility;
import Application.Validation;
import Models.ExamAttempt;
import Models.ExamInstance;
import Models.Student;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Win_CreateExamAttempt extends Stage{

    public Win_CreateExamAttempt(){
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

    ComboBox<String> cbxAdm;
    ComboBox<ExamInstance> cbxExam;
    ComboBox<Student> cbxStudent;
    ComboBox<Integer> cbxGrade;
    Spinner<Integer> spnAttempt;

    private void initGUI(GridPane pane){

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblGrade = new Label("Karakter:");
        cbxGrade = new ComboBox<Integer>();
        Label lblAdm = new Label("Administrativ Bedømmelse");
        cbxAdm = new ComboBox<String>();
        Label lblAttempt = new Label("Forsøgsnummer:");
        spnAttempt =  new Spinner<>(1, 15, 1);
        Label lblExam = new Label("Eksamen");
        cbxExam = new ComboBox<ExamInstance>();
        Label lblStudent = new Label("Student");
        cbxStudent = new ComboBox<Student>();
        Label lblSpacer = new Label();
        Button btnConfirm = new Button("Opret");

        pane.add(lblGrade, 0, 0);
        pane.add(cbxGrade, 0, 1);
        pane.add(lblAdm, 0, 2);
        pane.add(cbxAdm, 0, 3);
        pane.add(lblAttempt, 0, 4);
        pane.add(spnAttempt, 0, 5);
        pane.add(lblExam, 0, 6);
        pane.add(cbxExam, 0, 7);
        pane.add(lblStudent, 0, 8);
        pane.add(cbxStudent, 0, 9);
        pane.add(lblSpacer, 0 ,10);
        pane.add(btnConfirm, 0, 11);

        cbxAdm.getItems().addAll("Ingen Bemærkning", "Sygdom", "Ikke Fremmødt", "Ikke Afleveret");
        cbxGrade.getItems().addAll(-3, 00, 02, 4, 7, 10, 12);
        cbxExam.getItems().addAll(Select.getAllExamInstances());
        cbxStudent.getItems().addAll(Select.getAllStudents());

        cbxAdm.setValue("Ingen Bemærkning");
        cbxExam.setPromptText("---");
        cbxGrade.setPromptText("---");
        cbxStudent.setPromptText("---");

        btnConfirm.setOnAction(event -> btnConfirmAction());

    }

    private void btnConfirmAction(){

        String adm;
        switch (String.valueOf(cbxAdm.getValue())) {
            case "Sygdom":
                adm = "SY";
                break;
            case "Ikke Fremmødt":
                adm = "IM";
                break;
            case "Ikke Afleveret":
                adm = "IA";
                break;
            default:
                adm = null;
                System.out.println("Debug Log: Administrative Notice set to null (Win_CreateExamAttempt)");
                break;
        }

        if (!Validation.nullValidation(Select.getNewExamAttemptID(), "Intern ID Oprettelse")) { return; }
        if (!Validation.nullValidation(cbxGrade.getValue(), "Karakter")) { return; }
        if (!Validation.nullValidation(spnAttempt.getValue(), "Forsøgsnummer")) { return; }
        if (!Validation.nullValidation(cbxExam.getValue(), "Eksamen")) { return; }
        if (!Validation.nullValidation(cbxStudent.getValue(), "Studerende")) { return; }

        ExamAttempt examAttempt = new ExamAttempt(
                Select.getNewExamAttemptID(),
                cbxGrade.getValue(),
                adm,
                spnAttempt.getValue(),
                cbxExam.getValue().getStartDato(),
                cbxExam.getValue().getAfviklID(),
                cbxStudent.getValue().getStudID()
        );

        if (Insert.createExamAttempt(examAttempt)){
            Utility.successAlert("Eksamensforsøg Oprettet i Databasen!");
            this.close();
        }

    }

}
