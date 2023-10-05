package Models;

public class Education {
    int uddID;
    String navn;

    public Education(int uddID, String navn) {
        this.uddID = uddID;
        this.navn = navn;
    }

    public int getUddID() {
        return uddID;
    }

    public String getNavn() {
        return navn;
    }
}
