package GUI;

import Application.Connection;
import Application.Insert;
import Application.Select;
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
import org.w3c.dom.Text;

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

    ComboBox cbxGrade, cbxAdm, cbxExam, cbxStudent;
    Spinner spnAttempt;

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
        Spinner<Integer> spnAttempt = new Spinner<>(1, 15, 1);
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

        //Null, SY, IM, IA
        cbxAdm.getItems().addAll("Ingen Bemærkning", "Sygdom", "Ikke Fremmødt", "Ikke Afleveret");
        cbxGrade.getItems().addAll(-3, 00, 02, 4, 7, 10, 12);
        cbxExam.getItems().addAll(Select.getAllExamInstances());
        cbxStudent.getItems().addAll(Select.getAllStudents());

        cbxAdm.setValue("Ingen Bemærkning");
        cbxExam.setPromptText("(Vælg Eksamen)");
        cbxGrade.setPromptText("(Vælg Karakter)");
        cbxStudent.setPromptText("(Vælg Studerende)");

        btnConfirm.setOnAction(event -> btnConfirmAction());

    }

    private void btnConfirmAction(){

        String adm = null;

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

        // Apparently you can't just return objects from JavaFX controls. Hurray
        Integer grade = (Integer) cbxGrade.getValue();
        ExamInstance examInstance = (ExamInstance) cbxExam.getValue();
        Student student = (Student) cbxStudent.getValue();
        Integer attempt = (Integer) spnAttempt.getValue();

        ExamAttempt examAttempt = new ExamAttempt(
                Select.getNewExamAttemptID(),
                grade,
                adm,
                attempt,
                examInstance.getStartDate(),
                examInstance.getExamInstanceID(),
                student.getId()
        );

        Insert.createExamAttempt(examAttempt);
    }

}