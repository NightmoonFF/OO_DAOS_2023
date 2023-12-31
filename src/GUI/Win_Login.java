package GUI;

import Application.Connection;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Win_Login extends Stage {

    public Win_Login(){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(true);
        this.setTitle("Server Login - (localhost)");
        this.requestFocus();
        GridPane pane = new GridPane();
        this.initGUI(pane);
        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initGUI(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDbName = new Label("Database URL:");
        Label lblUsername = new Label("Username:");
        Label lblPassword = new Label("Password:");
        TextField txfDbName = new TextField();
        TextField txfUsername = new TextField();
        PasswordField psfPassword = new PasswordField();
        Button btnConnect = new Button("Connect");

        // Add nodes to pane
        pane.add(lblDbName, 0, 0);
        pane.add(txfDbName, 0, 1);
        pane.add(lblUsername, 0, 2);
        pane.add(txfUsername, 0, 3);
        pane.add(lblPassword, 0, 4);
        pane.add(psfPassword, 0, 5);
        pane.add(btnConnect, 0, 6);

        txfDbName.setText("jdbc:sqlserver://localhost;databaseName=Semester2_Aflevering1");
        txfUsername.setText("sa");

        this.setWidth(450);
        txfDbName.setMinWidth(430);
        txfUsername.setMinWidth(430);
        psfPassword.setMinWidth(430);
        psfPassword.setPromptText("Your Password");

        btnConnect.setOnAction(event -> btnConnectAction(txfDbName.getText(), txfUsername.getText(), psfPassword.getText()));
    }

    private void btnConnectAction(String dbName, String user, String pass){
        if (Connection.connect(dbName, user, pass)){
            //Connection Success
            System.out.println("Login Success");
            this.close();
        }
    }

}
