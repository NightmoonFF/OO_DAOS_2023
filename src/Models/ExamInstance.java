package Models;

import java.sql.Date;

public class ExamInstance {

    int afviklID;
    String termin;
    Date startDato;
    Date slutDato;
    int fk_eksID;

    public ExamInstance(int afviklID, String termin, Date startDato, Date slutDato, int fk_eksID) {
        this.afviklID = afviklID;
        this.termin = termin;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.fk_eksID = fk_eksID;
    }

    public int getAfviklID() {
        return afviklID;
    }

    public void setAfviklID(int afviklID) {
        this.afviklID = afviklID;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public Date getStartDato() {
        return startDato;
    }

    public void setStartDato(Date startDato) {
        this.startDato = startDato;
    }

    public Date getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(Date slutDato) {
        this.slutDato = slutDato;
    }

    public int getFk_eksID() {
        return fk_eksID;
    }

    public void setFk_eksID(int fk_eksID) {
        this.fk_eksID = fk_eksID;
    }
    @Override
    public String toString(){
        return getTermin() +" - " + getStartDato();
    }
}
