import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BearbForm extends JFrame {
Anfrage anf_Save;
    int id_bf;
    String datumS_bf = "";
    String bezeichnung_bf = "";
    String gewerk_bf = "";
    String firma_bf = "";
    String land_bf = "";
    String deadline_bf = "";
    String summe_bf = "";
    int kennzahl_bf = 1;
    String angebotsNr_bf = "";
   String beschreibung_bf = "";
    String arbeitszeit_bf ="";
    String komments_bf = "";
   String neuKomment = "";


    String formName = "Bezeichnung aus der Liste"; // название окна будет соотсветствовать названию запроса

    JPanel pan0 = new JPanel();// главная панель для размещения всего остального

    JPanel pan1 = new JPanel();// панель для размещения верхней группы

    JPanel pan11 = new JPanel();// панель для размещения левого крыла верхней группы

    JPanel pan12 = new JPanel();// панель для размещения средней группы

    JPanel pan13 = new JPanel(); // панель для размещения правой группы
    JPanel pan131 = new JPanel();// панель для логотипа
    JPanel pan2 = new JPanel(); // панель для средней части

    JPanel pan21 = new JPanel(); // панель для нового комментария

    JPanel pan22 = new JPanel(); // панель для кнопки и боксов-переключения
    JPanel pan3 = new JPanel(); // панель для нижней части экрана







    JLabel logo = new JLabel();


    JTextArea idText =  new JTextArea("ID Nummer");
    JTextArea datumText = new JTextArea("Datum der Anfrage");
    JTextArea bezeichnungText = new JTextArea("Bezeichnung der Anfrage " +" ");
    JTextArea gewerkText = new JTextArea("Das Gewerk");
    JTextArea firmaText = new JTextArea("Firmenname");
    JTextArea landText = new JTextArea("Das Land");
    JTextArea deadText = new JTextArea("Deadline");
    JTextArea summeText = new JTextArea("Summe der Anfrage");
    JTextArea statusText = new JTextArea("Statuskennzahl");
    JTextArea angebNumText = new JTextArea("Angebotsnummer");
JTextArea beschreibText = new JTextArea("Beschreibung");
    JTextArea arbZeitText = new JTextArea("");
    JTextArea kommText = new JTextArea(20, 50);// текстовое поле для средней части
JTextArea neuKommentText = new JTextArea("");// поле для новой записи в комментарии




    JButton saveButton = new JButton("Einen Kommentar oder Änderung eintragen");





    public BearbForm(Anfrage a) throws IOException, BadLocationException {
        super();
this.anf_Save = a;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dim.height;
        height = (int) (height * 0.85);
        int width = dim.width;
        width = (int) (width * 0.9);
        //  this.setSize(dim);
        this.setSize(width, height);
        this.setLocation(50, 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(pan0);
        this.setTitle(formName);
        try{
            logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("ts_logo.gif")));

        }catch (Exception e){
            System.out.println("не найден файл для рисунка");
        }


        pan0.setBackground(Color.cyan);
        //  pan0.setLayout(new GridLayout(3, 1, 10,10));
        pan0.setLayout(new BorderLayout());
        pan0.add(pan1, BorderLayout.NORTH);
        pan0.add(pan2, BorderLayout.CENTER);
        pan0.add(pan3, BorderLayout.SOUTH);



        pan1.setLayout(new GridLayout(1, 3, 5, 5));
        pan1.setBackground(Color.GRAY);

        pan11 = generPan("Hauptparameter");
        pan11.setLayout(new GridLayout(4,1,5,5));
        landText.setBorder(genTitleBorder("Land"));

        gewerkText.setBorder(genTitleBorder("Gewerk"));
        angebNumText.setBorder(genTitleBorder("Angebot Nr."));

        pan11.add(landText);// создаем группу в левом окне сверху
        pan11.add(gewerkText);
        pan11.add(angebNumText);
        firmaText.setBorder(genTitleBorder("Firma"));
        pan11.add(firmaText);
        pan1.add(pan11);


        bezeichnungText.setLineWrap(true);
        bezeichnungText.setWrapStyleWord(true);
        bezeichnungText.setBorder(genTitleBorder("Bezeichnung"));
       // JScrollPane bezeichnScroll = new JScrollPane(bezeichnungText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
         //       JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        bezeichnungText.setBorder(genTitleBorder("Projekt"));
bezeichnungText.setText("bez.");
        pan131.add(bezeichnungText);
        pan131.setBackground(Color.WHITE);
        pan131.setAlignmentX(CENTER_ALIGNMENT);

        pan12= generPan(""); // формируем среднюю группу сверху
        pan12.setLayout(new GridLayout(2, 1,5,5));

       // pan12.add(pan131, BorderLayout.NORTH);
beschreibText.setBorder(genTitleBorder("Kurze Zusammenfassung"));

        pan12.add(bezeichnungText);
        pan12.add(beschreibText);
        pan1.add(pan12);

        pan13 = generPan("Anfrageparameter");
        pan13.setAlignmentX(BOTTOM_ALIGNMENT);
        pan13.setLayout(new GridLayout(3, 1, 5, 5));
        datumText.setBorder(genTitleBorder("Datum"));
        pan13.add(datumText);
        deadText.setBorder(genTitleBorder("Deadline"));
        pan13.add(deadText);
        idText.setBorder(genTitleBorder("ID"));
        pan13.add(idText);
        statusText.setBorder(genTitleBorder("Kennzahl"));
        statusText.setToolTipText("1-neue Anfrage; 2- in Bearbeitung; 3- Abgabereif; 4- in Ausführung; 5- Korb");
        pan13.add(statusText);
        arbZeitText.setBorder(genTitleBorder("Arbeitszeit"));
        arbZeitText.setText(a.getArbeitsZeit());
        pan13.add(arbZeitText);

        summeText.setBorder(genTitleBorder("Summe Euro"));
        pan13.add(summeText);
        pan1.add(pan13);// сформировали верхнюю панель
        // kommText.setBackground(Color.LIGHT_GRAY);


        JScrollPane komments = new JScrollPane(kommText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // панель с прокруткой для средней части
        kommText.setLineWrap(true);
        kommText.setWrapStyleWord(true);

         Border etched2 = BorderFactory.createRaisedBevelBorder();
        Border titled2 = BorderFactory.createTitledBorder(etched2, "Ablauf und Komments");

        pan2.setLayout(new BorderLayout());
        pan2.setBorder(titled2);

        pan2.setBackground(Color.LIGHT_GRAY);

        pan2.add(komments, BorderLayout.CENTER);

       JScrollPane neuKom = new JScrollPane(neuKommentText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        neuKommentText.setBorder(genTitleBorder("neue Kommentar"));

        neuKommentText.getLineStartOffset(0);
        pan2.add(neuKommentText, BorderLayout.NORTH);

        saveButton.addActionListener(new SaveButtonEventListener(anf_Save) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("KNOPF SAVE IST GEDRUCKT!!");
                // сохраняем данные из списка в ANFRAGE
                try {idUpdate();
                    anf_Save.setId(Integer.parseInt(idText.getText()));
                }catch (NumberFormatException numberFormatException){
                    System.out.println("falsche Zahlformat!");
                    numberFormatException.printStackTrace();
                }
                datumSUpdate();
                anf_Save.setDatumS(datumText.getText());
                bezeichnungUpdate();
                anf_Save.setBezeichnung(bezeichnungText.getText());
                gewerkUpdate();
                anf_Save.setGewerk(gewerkText.getText());
                firmaUpdate();
                anf_Save.setAnfragendeFa(firmaText.getText());
                landUpdate();
                anf_Save.setLand(landText.getText());
                deadlineUpdate();
                anf_Save.setDeadline(deadText.getText());
                try {
                    summeUpdate();
                    anf_Save.setSumme(Double.parseDouble(summeText.getText()));
                    kennzahlUpdate();
                    anf_Save.setKennZahl(Integer.parseInt(statusText.getText()));
                }catch ( NumberFormatException numberF ){
                    System.out.println("Falsche Format");
                };



                angebotsnummerUpdate();
                anf_Save.setAngebotsNummer(angebNumText.getText());
                beschreibungUpdate();
                anf_Save.setBeschreibung(beschreibText.getText());
                arbeitszeitUpdate();
                anf_Save.setArbeitsZeit(arbZeitText.getText());
                Date heute = new Date();
                if (!neuKommentText.getText().equals("")){
                    anf_Save.setKomments(System.lineSeparator() + heute.toString() + neuKommentText.getText());
                    neuKommentText.setText("");
                    kommText.setText(anf_Save.getKomments());
                }

                System.out.println("вывод после нажатия кнопки--/" + anf_Save.toString());




XmlWriter.writeXML();
            }
        });
        pan3.add(saveButton, BorderLayout.EAST);
 pan3.setBackground(Color.blue);

    }

    JPanel generPan( String name){
        JPanel newPan = new JPanel();
        Border etched = BorderFactory.createRaisedBevelBorder();
        Border title = BorderFactory.createTitledBorder(etched, name);
        newPan.setBorder(title);
        return newPan;
    }

    Border genTitleBorder(String title){

        Border etchedBorder = BorderFactory.createRaisedBevelBorder();
        Border titledBorder = BorderFactory.createTitledBorder(etchedBorder, title);
        return titledBorder; }
    // метод для фиксации в комментариях изменений в поле ID
public void idUpdate(){
    if(anf_Save.getId() != Integer.parseInt(idText.getText())){
           Date h = new Date();
        anf_Save.setKomments(System.lineSeparator() + h.toString() + " -ID wurde geändert. Neue ID:__ " + idText.getText());
        kommText.setText(anf_Save.getKomments());
    }
}
    public void datumSUpdate(){
        if(!anf_Save.getDatumS().equals(datumText.getText())){
           Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Datum wurde geändert. Neues Datum:__ " + datumText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void bezeichnungUpdate(){
       if(!anf_Save.getBezeichnung().equals(bezeichnungText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Bezeichnung wurde geändert. Neue Bezeichnung:__ " + bezeichnungText.getText());
           kommText.setText(anf_Save.getKomments());
       }
    }
    public void gewerkUpdate(){
        if(!anf_Save.getGewerk().equals(gewerkText.getText())){
             Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Gewerk wurde geändert. Neue Gewerk:__ " + gewerkText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void firmaUpdate(){
        if(!anf_Save.getAnfragendeFa().equals(firmaText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Firma wurde geändert. Neue Firma:__ " + firmaText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void landUpdate(){
        if(!anf_Save.getLand().equals(landText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Land wurde geändert. Neues Land:__ " + landText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void deadlineUpdate(){
        if(!anf_Save.getDeadline().equals(deadText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Dead line wurde geändert. Neue dead line:__ " + deadText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void summeUpdate(){
        if(anf_Save.getSumme() != Double.parseDouble(summeText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Summe wurde geändert. Neue Summe:__ " + summeText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void kennzahlUpdate(){
        if(anf_Save.getKennZahl() != Integer.parseInt(statusText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Kennzahl wurde geändert. Neue Kennzahl:__ " + statusText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void angebotsnummerUpdate(){
        if(!anf_Save.getAngebotsNummer().equals(angebNumText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Angebotsnummer wurde geändert. Neue Nummer:__ " + angebNumText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void beschreibungUpdate(){
        if(!anf_Save.getBeschreibung().equals(beschreibText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Beschreibung wurde geändert. Neue Beschreibung:__ " + beschreibText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }
    public void arbeitszeitUpdate(){
        if(!anf_Save.getArbeitsZeit().equals(arbZeitText.getText())){
            Date h = new Date();
            anf_Save.setKomments(System.lineSeparator() + h.toString() + " -Arbeitszeit wurde geändert. Neue Arbeitszeit:__ " + arbZeitText.getText());
            kommText.setText(anf_Save.getKomments());
        }
    }

    class SaveButtonEventListener implements ActionListener {

        Anfrage anf_S;

        public SaveButtonEventListener(Anfrage a){
            this.anf_S = a;
        }
        XmlWriter writer = new XmlWriter();

        @Override
        public void actionPerformed(ActionEvent e) {


        }

    }


}
