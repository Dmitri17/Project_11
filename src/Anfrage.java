import java.util.Date;

public class Anfrage {
    int id; // 1

    public String getDatumS() {
        return datumS;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getGewerk() {
        return gewerk;
    }

    public String getAnfragendeFa() {
        return anfragendeFa;
    }

    public String getLand() {
        return land;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getSumme() {
        return summe;
    }

    public int getKennZahl() {
        return kennZahl;
    }

    public String getAngebotsNummer() {
        return angebotsNummer;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getArbeitsZeit() {
        return arbeitsZeit;
    }

    public String getKomments() {
        return komments;
    }


    String datumS; // 2
    String bezeichnung = "Muster_Bezeichnung";  //3
    String gewerk = "";  // 4
    String anfragendeFa = "XML GmbH";  // 5
    String land = "";  //  6
    String deadline =  " "; // 7
    String summe = "000.00";  // 8
    int kennZahl;  // 9
    String angebotsNummer = "xxx_000_22";  // 10
    String beschreibung = "Das ist eine neue Anfrage # ";  // 11
    String arbeitsZeit = " ";  // 12
    String komments = "- ";//13
    public Anfrage(int id, String datumS,  String bezeichnung, String gewerk, String anfragendeFa, String land, String deadline, String summe,
                   int kennZahl, String angebotsNummer, String beschreibung, String arbeitsZeit, String komments ){
        this.id = id;
        this.datumS = datumS;
        this.bezeichnung = bezeichnung;
        this.gewerk = gewerk;
        this.anfragendeFa = anfragendeFa;
        this.land = land;
        this.deadline = deadline;
        this.summe = summe;
        this.kennZahl = kennZahl;
        this.angebotsNummer = angebotsNummer;
        this.beschreibung = beschreibung;
        this.arbeitsZeit = arbeitsZeit;
        this.komments = komments;


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

    public void setAnfragendeFa(String anfragendeFa) {
        this.anfragendeFa = anfragendeFa;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setSumme(String summe) {
        this.summe = summe;
    }

    public void setKennZahl(int kennZahl) {
        this.kennZahl = kennZahl;
    }

    public void setAngebotsNummer(String angebotsNummer) {
        this.angebotsNummer = angebotsNummer;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setArbeitsZeit(String arbeitsZeit) { this.arbeitsZeit = arbeitsZeit; }



    public void setKomments(String neuKomment) {this.komments = this.komments  + neuKomment ;}

    public Anfrage(int id, String dateS, String bezeichnung, String gewerk, int kennZahl, String land ){
        this.id = id;
        this.datumS = dateS;
        this.bezeichnung = bezeichnung;
        this.gewerk = gewerk;
        this.kennZahl = kennZahl;
        this.land = land;

    }
    public Anfrage(){}

    int getId(){
        return id;
    }
    void setId(int newId){
        id = newId;
    }


    void setDatumS(Date newDatum){
        datumS = newDatum.toString();
    }

    public String toString(){

        String  result  = "Anfrage:  - " + getId() + " _ " + getDatumS() + " _ " + getBezeichnung()+ " _ " + getGewerk() + " _ " + getAnfragendeFa() + " _ "
                + getLand() + " _ " + getDeadline() +
                " _ " + getSumme() +  " _ " + getKennZahl() + " _ " + getAngebotsNummer() + " _ " +getBeschreibung() + " _ " +getArbeitsZeit() + " _ "
                + System.lineSeparator() + getKomments();
        return result;
    }

}
