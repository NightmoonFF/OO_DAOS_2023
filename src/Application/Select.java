package Application;

import Models.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class Select {
    // Education
    public static Education getEducationByID(int id){
        Education education = null;
        try{
            String sql = "select * from uddannelse where uddID = " + id;
            ResultSet res = Connection.stmt.executeQuery(sql);

            while(res.next()){
                education = new Education(res.getInt(1), res.getString(2));
            }
            return education;
        }
        catch(Exception e){
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }
    }

    // Student
    //TODO: Student-String is giga long? Tons of blank space
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
    public static Student getStudentByID(int id){

        Student student = null;
        try {

            String sql = "select * from studerende where studID = " + id;
            ResultSet res = Connection.stmt.executeQuery(sql);

            while (res.next()) {
                student = new Student(
                        res.getInt(1),
                        res.getString(2),
                        res.getBoolean(3),
                        res.getInt(4));
            }
            return student;
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }
    }

    public static ArrayList<StudentBySubjectAndSemester> GetAllStudentsByExamAndSemester(Exam exam, String examInstance){
        ArrayList<StudentBySubjectAndSemester> students = new ArrayList();
        try {

            String sql = "SELECT studerende.studID,  studerende.navn, eksamensForsøg.karakter\n" +
                    "FROM eksamensAfvikling\n" +
                    "JOIN eksamensForsøg ON eksamensForsøg.fk_afviklID = eksamensAfvikling.afviklID \n" +
                    "JOIN studerende ON studerende.studID = eksamensForsøg.fk_studID\n" +
                    "JOIN eksamen on eksamen.eksID = eksamensAfvikling.fk_eksID\n" +
                    "WHERE eksamen.eksID = "+ exam.getEksID() +" AND eksamensAfvikling.termin LIKE '"+ examInstance +"';";

            ResultSet res = Connection.stmt.executeQuery(sql);

            while (res.next()) {
                students.add(new StudentBySubjectAndSemester(
                        res.getInt(1),
                        res.getString(2),
                        res.getInt(3)));
            }

            if(students.size() < 1) { Utility.errorAlert("Ingen Resultater Fundet!"); }
            return students;
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }

    }

    // Exam
    public static ArrayList<Exam> getAllExams(){
        ArrayList<Exam> exams = new ArrayList();
        try {
            String sql = "select * from eksamen";
            ResultSet res = Connection.stmt.executeQuery(sql);
            while (res.next()) {
                exams.add(new Exam(
                        res.getInt(1),
                        res.getString(2),
                        res.getBoolean(3),
                        res.getString(4),
                        res.getInt(5)));
            }
            return exams;
        }
        catch (Exception e) {
            System.out.println("fejl:  "+e.getMessage());
            Utility.errorAlert(e.getMessage());
            return null;
        }
    }

    // Exam Instance
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
    public static Integer getNewExamInstanceID(){
        try {
            String sql = "select MAX(afviklID) from eksamensAfvikling";
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

    // Exam Attempt
    public static ArrayList<ExamAttempt> getAllExamAttempts(){
        ArrayList<ExamAttempt> attempts = new ArrayList();
        try {

            String sql = "select * from eksamensForsøg";
            ResultSet res = Connection.stmt.executeQuery(sql);

            while (res.next()) {

                attempts.add(new ExamAttempt(
                        res.getInt(1),
                        res.getInt(2),
                        res.getString(3),
                        res.getInt(4),
                        res.getDate(5),
                        res.getInt(6),
                        res.getInt(7)));
            }
            return attempts;
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