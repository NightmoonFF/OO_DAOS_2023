package Models;

import java.sql.Date;

public class ExamInstance {

    int examInstanceID;
    String semester;
    Date startDate;
    Date endDate;
    int fk_ExamID;

    public ExamInstance(int examInstanceID, String semester, Date startDate, Date endDate, int fk_ExamID) {
        this.examInstanceID = examInstanceID;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fk_ExamID = fk_ExamID;
    }

    public int getExamInstanceID() {
        return examInstanceID;
    }

    public void setExamInstanceID(int examInstanceID) {
        this.examInstanceID = examInstanceID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getFk_ExamID() {
        return fk_ExamID;
    }

    public void setFk_ExamID(int fk_ExamID) {
        this.fk_ExamID = fk_ExamID;
    }
    @Override
    public String toString(){
        return getSemester() + getStartDate();
    }
}
