package GUI;

import Application.Select;
import Models.Exam;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Win_GetStudentsForExam extends Stage {

    public Win_GetStudentsForExam(){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(true);
        this.setTitle("Find Beståede Studerende");
        this.requestFocus();
        GridPane pane = new GridPane();
        this.initGUI(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    Label lblExam, lblSemester;
    ComboBox<Exam> cbxExam;
    ComboBox<String> cbxTermin;
    private void initGUI(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        lblExam = new Label("Eksamen:");
        cbxExam = new ComboBox<>();
        lblSemester = new Label("Termin:");
        cbxTermin = new ComboBox<>();

        Button btnConfirm = new Button("Godkend");
        btnConfirm.setOnAction(event -> btnConfirmAction());

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


    }


    private void btnConfirmAction(){

        //TODO: Make query for finding:
        //But like, this requires Termin to be on Eksamen, right?

//        c.	Lav et java-program, der anvender JDBC.
//        Via programmet skal du indtaste navnet på en given eksamen og en given termin.
//        Programmet skal som resultat vise en liste af de studerende,
//        der har deltaget i denne afvikling af denne eksamen i denne termin.
//        Udover den studerendes navn og id, skal karakteren også være med i resultatet.

    }




}