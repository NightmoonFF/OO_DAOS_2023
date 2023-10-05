package Models;

public class Student {

    int id;
    String name;
    boolean isActive;
    int fk_EducationID;

    public Student(int id, String name, boolean isActive, int fk_EducationID) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.fk_EducationID = fk_EducationID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getFk_EducationID() {
        return fk_EducationID;
    }

    public void setFk_EducationID(int fk_EducationID) {
        this.fk_EducationID = fk_EducationID;
    }
    @Override
    public String toString(){
        return name;
    }
}
