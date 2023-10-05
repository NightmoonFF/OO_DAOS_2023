package Application;

import Models.ExamInstance;
import Models.Student;
import javafx.scene.control.Alert;

import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class Select {

    public static ArrayList<Student> getAllStudents(){

        ArrayList<Student> students = new ArrayList();
        try {

            String sql = "select * from studerende";
            ResultSet res = Connection.stmt.executeQuery(sql);

            while (res.next()) {
                students.add(new Student(
                        res.getInt(1),
                        res.getString(2),
                        res.getBoolean(3),
                        res.getInt(4)));
            }
            return students;
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }
    }

    public static ArrayList<ExamInstance> getAllExamInstances(){

        ArrayList<ExamInstance> instances = new ArrayList();
        try {

            String sql = "select * from eksamensAfvikling";
            ResultSet res = Connection.stmt.executeQuery(sql);

            while (res.next()) {

                instances.add(new ExamInstance(
                        res.getInt(1),
                        res.getString(2),
                        res.getDate(3),
                        res.getDate(4),
                        res.getInt(5)));
            }
            return instances;
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }

    }

    public static Integer getNewExamAttemptID(){

        try {
            String sql = "select MAX(forsøgsID) from eksamensForsøg";
            ResultSet res = Connection.stmt.executeQuery(sql);
            Integer i = null;
            while (res.next()) {
                i = res.getInt(1);
            }
            return i + 1;
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }
    }

}