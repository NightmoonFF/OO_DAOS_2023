package GUI;

import Application.Select;
import Application.Validation;
import Models.Exam;
import Models.ExamInstance;
import Models.StudentBySubjectAndSemester;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class Win_GetStudentsForExam extends Stage {

    public Win_GetStudentsForExam(Win_Main main){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(true);
        this.setTitle("Find Beståede Studerende");
        this.requestFocus();
        GridPane pane = new GridPane();
        this.initGUI(pane, main);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    Label lblExam, lblSemester;
    ComboBox<Exam> cbxExam;
    ComboBox<String> cbxTermin;
    private void initGUI(GridPane pane, Win_Main main){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblExam = new Label("Eksamen:");
        cbxExam = new ComboBox<>();
        lblSemester = new Label("Termin:");
        cbxTermin = new ComboBox<>();

        Button btnConfirm = new Button("Godkend");
        btnConfirm.setOnAction(event -> btnConfirmAction(main));

        pane.add(lblExam, 0, 0);
        pane.add(cbxExam, 0, 1);
        pane.add(lblSemester, 2, 0);
        pane.add(cbxTermin, 2, 1);
        pane.add(btnConfirm, 1, 3);

        cbxExam.setMinWidth(150);
        cbxExam.setPrefWidth(150);

        cbxExam.setMaxWidth(150);
        cbxTermin.setMinWidth(150);
        cbxTermin.setPrefWidth(150);
        cbxTermin.setMaxWidth(150);


        cbxExam.getItems().setAll(Select.getAllExams());
        cbxExam.setPromptText("---");
        cbxTermin.setPromptText("---");

        ArrayList<String> terminer = new ArrayList<>();
        for (ExamInstance e : new ArrayList<>(Select.getAllExamInstances())){
            terminer.add(e.getTermin());
        }
        cbxTermin.getItems().setAll(terminer);

    }


    private void btnConfirmAction(Win_Main main){

        if (!Validation.nullValidation(cbxExam, "Examen")) { return; }
        if (!Validation.nullValidation(cbxTermin, "Termin")) {return; }

        main.lvwDisplay.getItems().setAll(Select.GetAllStudentsByExamAndSemester(cbxExam.getValue(), cbxTermin.getValue()));
        this.close();
    }




}