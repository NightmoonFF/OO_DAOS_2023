package Models;

import Application.Select;

public class Student {
    int studID;
    String navn;
    boolean erAktiv;
    int fk_uddID;

    public Student(int studID, String navn, boolean erAktiv, int fk_uddID) {
        this.studID = studID;
        this.navn = navn;
        this.erAktiv = erAktiv;
        this.fk_uddID = fk_uddID;
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isErAktiv() {
        return erAktiv;
    }

    public void setErAktiv(boolean erAktiv) {
        this.erAktiv = erAktiv;
    }

    public int getFk_uddID() {
        return fk_uddID;
    }

    public void setFk_uddID(int fk_uddID) {
        this.fk_uddID = fk_uddID;
    }
    @Override
    public String toString(){

        if(erAktiv){
            return navn + " - " + Select.getEducationByID(fk_uddID).getNavn() + " (Aktiv)";
        }
        else{
            return navn + " - " + Select.getEducationByID(fk_uddID).getNavn() + " (Ophørt)";
        }


    }
}
