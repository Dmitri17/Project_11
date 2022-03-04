import java.util.HashMap;
import java.util.Map;

public class Anfrage1 {
    int id = 1;
    String datumS = "BBBBBBBB";
    String bezeichnung ="CCCCCCCCC";
    String gewerk = "DDDDDDDDD";
    String firma = "EEEEEE";
    String land = "FFFFFFFFF";
    String deadline = "rrrr";
    double summe = 0;
    int kennzahl = 1;
    String angNummer = "Angebotsnummer_Platzhalter";
    String beschreing = "Beschreibung_Platzhalter";
    String arbeitszeit = "Arbeitszeit_Platzhalter";
    String komments= "Komments_Platzhalter";; // нужен метод для формирования строки с комментами из файла


    public void setId(int id) {
        this.id = id;
    }

    public void setDatumS(String datumS) {
        this.datumS = datumS;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setGewerk(String gewerk) {
        this.gewerk = gewerk;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setSumme(double summe) {
        this.summe = summe;
    }

    public void setKennzahl(int kennzahl) {
        this.kennzahl = kennzahl;
    }

    public void setAngNummer(String angNummer) {
        this.angNummer = angNummer;
    }

    public void setBeschreing(String beschreing) {
        this.beschreing = beschreing;
    }

    public void setArbeitszeit(String arbeitszeit) {
        this.arbeitszeit = arbeitszeit;
    }

    public void setKomments(String komments) {
        this.komments = komments;
    }



    public int getId() {
        return id;
    }

    public String getDatumS() {
        return datumS;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getGewerk() {
        return gewerk;
    }

    public String getFirma() {
        return firma;
    }

    public String getLand() {
        return land;
    }

    public String getDeadline() {
        return deadline;
    }

    public double getSumme() {
        return summe;
    }

    public int getKennzahl() {
        return kennzahl;
    }

    public String getAngNummer() {
        return angNummer;
    }

    public String getBeschreing() {
        return beschreing;
    }

    public String getArbeitszeit() {
        return arbeitszeit;
    }

    public String getKomments() {
        return komments;
    }






    public String  toString(){
String result = "";
result  = "Anfrage:  - " + id + " _ " + datumS + " _ " + bezeichnung+ " _ " + gewerk + " _ " + firma + " _ " + land + " _ " + deadline +
         " _ " + Double.toString(summe) +  " _ " + Integer.toString(kennzahl) + " _ " + angNummer + " _ " +beschreing + " _ " +arbeitszeit + " _ "
        + System.lineSeparator() + komments;
        return result;
    }


}
