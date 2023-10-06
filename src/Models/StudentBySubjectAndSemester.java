package Models;

public class StudentBySubjectAndSemester {

    int id;
    String navn;
    int karakter;

    public StudentBySubjectAndSemester(int id, String navn, int karakter) {
        this.id = id;
        this.navn = navn;
        this.karakter = karakter;
    }

    //region Get + Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getKarakter() {
        return karakter;
    }

    public void setKarakter(int karakter) {
        this.karakter = karakter;
    }
    //endregion

    @Override
    public String toString(){
        return id + " - " + navn + " - " + "Karakter: " + karakter;
    }
}
