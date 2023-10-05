package Models;

import java.sql.Date;

public class ExamAttempt {

    int forsøgsID;
    int karakter;
    String admBedøm;
    int forsøgsNr;
    Date dato;
    int fk_afviklID;
    int fk_studID;

    public ExamAttempt(int forsøgsID, int karakter, String admBedøm, int forsøgsNr, Date dato, int fk_afviklID, int fk_studID) {
        this.forsøgsID = forsøgsID;
        this.karakter = karakter;
        this.admBedøm = admBedøm;
        this.forsøgsNr = forsøgsNr;
        this.dato = dato;
        this.fk_afviklID = fk_afviklID;
        this.fk_studID = fk_studID;
    }

    public int getForsøgsID() {
        return forsøgsID;
    }

    public void setForsøgsID(int forsøgsID) {
        this.forsøgsID = forsøgsID;
    }

    public int getKarakter() {
        return karakter;
    }

    public void setKarakter(int karakter) {
        this.karakter = karakter;
    }

    public String getAdmBedøm() {
        return admBedøm;
    }

    public void setAdmBedøm(String admBedøm) {
        this.admBedøm = admBedøm;
    }

    public int getForsøgsNr() {
        return forsøgsNr;
    }

    public void setForsøgsNr(int forsøgsNr) {
        this.forsøgsNr = forsøgsNr;
    }

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public int getFk_afviklID() {
        return fk_afviklID;
    }

    public void setFk_afviklID(int fk_afviklID) {
        this.fk_afviklID = fk_afviklID;
    }

    public int getFk_studID() {
        return fk_studID;
    }

    public void setFk_studID(int fk_studID) {
        this.fk_studID = fk_studID;
    }
}
