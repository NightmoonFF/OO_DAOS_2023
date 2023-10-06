package Models;

import Application.Select;

public class Exam {

    int eksID;
    String navn;
    boolean erStopPrøve;
    String form;
    int fk_uddID;

    public Exam(int eksID, String navn, boolean erStopPrøve, String form, int fk_uddID) {
        this.eksID = eksID;
        this.navn = navn;
        this.erStopPrøve = erStopPrøve;
        this.form = form;
        this.fk_uddID = fk_uddID;
    }

    //region Getters & Setters
    public int getEksID() {
        return eksID;
    }
    public void setEksID(int eksID) {
        this.eksID = eksID;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public boolean isErStopPrøve() {
        return erStopPrøve;
    }
    public void setErStopPrøve(boolean erStopPrøve) {
        this.erStopPrøve = erStopPrøve;
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public int getFk_uddID() {
        return fk_uddID;
    }
    public void setFk_uddID(int fk_uddID) {
        this.fk_uddID = fk_uddID;
    }
    //endregion

    @Override
    public String toString(){
        return navn + " - " + form + " - " + Select.getEducationByID(fk_uddID).getNavn();
    }
}
