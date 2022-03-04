import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyseFrame  extends JFrame {
    String buttonName = "";
    JPanel neueAnfrage;
    JTextArea neuDatum;
    JTextArea neuBezeichnung;
    JTextArea neuGewerk;

    public AnalyseFrame( ){
       super("Thyssen Schachtbau GmbH                                     Anfragen in ZD ");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int height = dim.height;
        height = (int) (height * 0.9);
        int width = dim.width;
        width = (int) (width * 0.95);
        //  this.setSize(dim);
        this.setSize(width, height);
        this.setLocation(50, 35);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// панель для корзины
        JPanel korbPan = new JPanel();
        JScrollPane korb = new JScrollPane(korbPan,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        korbPan.setLayout(new GridLayout(100, 8, 3, 3));
        ArrayList<Anfrage> anfragen_korb = new ArrayList();
        for(Anfrage af: XmlReader.anfrageList){

            if(af.getKennZahl() == 5){

                    ButtonAnfrage jb =  new ButtonAnfrage();
                    jb.setToolTipText( "Anfrage" + af.getId() + " "+ af.getGewerk() + " " + af.getBezeichnung() + " " + af.getAnfragendeFa() + " " + af.getLand());
                    jb.setText( "Anfrage " + af.getId() + "/  " + af.getBezeichnung());
                    jb.anfrButton = af;
                jb.addActionListener(new OpenButtonEventListener(af) );

                    anfragen_korb.add(af);
                    korbPan.add( jb);

        }


        }
        // панель для внесения заявки в систему
        neueAnfrage = new JPanel();
        JScrollPane neueAnfPanel = new JScrollPane(neueAnfrage,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        neueAnfrage.setLayout(new GridLayout(15, 2, 3, 3));
        neuDatum = new JTextArea();
        neuDatum.setText("здесь должна быть актуальная дата");

        neuDatum.setBorder(genTitleBorder("Datum der Anfrage"));
        neuBezeichnung = new JTextArea();
        neuBezeichnung.setText("vvvvvvvvv");
        neuBezeichnung.setBorder(genTitleBorder("Bezeichnung"));
        neuGewerk = new JTextArea();
        neuGewerk.setBorder(genTitleBorder("Gewerk"));
        JTextArea neuFirma = new JTextArea();
        neuFirma.setBorder(genTitleBorder("Firma"));
        JTextArea neuLand = new JTextArea();
        neuLand.setBorder(genTitleBorder("Land"));
        JTextArea neuDeadLine = new JTextArea();
        neuDeadLine.setBorder(genTitleBorder("Deadline"));
        JTextArea neuSumme = new JTextArea();
        neuSumme.setBorder(genTitleBorder("Summe"));
        JTextArea neuKennzahl = new JTextArea();
        neuKennzahl.setBorder(genTitleBorder("KennZahl"));
        JTextArea neuAngebotsNummer = new JTextArea();
        neuAngebotsNummer.setBorder(genTitleBorder("Angebotsnummer"));
        JTextArea neuBeschreibung = new JTextArea();
        neuBeschreibung.setBorder(genTitleBorder("Beschreibung"));

        JButton saveButt = new JButton("Eintragen(Speichern)");
        saveButt.setForeground(Color.BLUE);
// создаем getter-ы для полей формы



        neueAnfrage.add(neuDatum);
        neueAnfrage.add(neuBezeichnung);
        neueAnfrage.add(neuGewerk);
        neueAnfrage.add(neuFirma);
        neueAnfrage.add(neuLand);
        neueAnfrage.add(neuDeadLine);
        neueAnfrage.add(neuSumme);
        neueAnfrage.add(neuKennzahl);
        neueAnfrage.add(neuAngebotsNummer);
        neueAnfrage.add(neuBeschreibung);
        neueAnfrage.add(saveButt);





        JPanel mainPan = new JPanel(); // главная панель, на которой собираем все этапы работы
        mainPan.setLayout(new BorderLayout());


        JPanel anfrage = new JPanel();// панель с вновь пришедшими запросами
        //  JScrollPane feld1 = new JScrollPane(anfrage,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        anfrage.setBackground(Color.getHSBColor(341, 61, 63));
        anfrage.setOpaque(rootPaneCheckingEnabled);
        anfrage.setToolTipText("Feld für aktuelle Anfragen");
        anfrage.setLayout(new GridLayout(8, 10, 3, 3));
        //  inKalkulation.setLayout(new FlowLayout());
        ArrayList<Anfrage> anfragen_neu = new ArrayList<>();
        for(Anfrage af: XmlReader.anfrageList){

            if(af.getKennZahl() == 1){

                ButtonAnfrage jb = new ButtonAnfrage();
                jb.setToolTipText( "Anfrage" + af.getId() + " "+ af.getGewerk() + " " + af.getBezeichnung() + " " + af.getAnfragendeFa() + " " + af.getLand());
                jb.setText( "Anfrage " + af.getId() + "/  " + af.getBezeichnung());
                // нужно еще прописать связь кнопки с Anfrage
                jb.anfrButton = af;
                jb.addActionListener(new OpenButtonEventListener(af) );

                anfragen_neu.add(af);
                anfrage.add( jb);

            }


        }

        JPanel inKalkulation = new JPanel(); // панель с запросами, находящимися в калькуляции
        // JScrollPane feld2 = new JScrollPane(inKalkulation,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //JScrollPane neuFeld = new JScrollPane();
        inKalkulation.setBackground(new Color(230, 227, 135, 170));
        inKalkulation.setToolTipText("Feld für die Anfragen in Kalkulation");
        inKalkulation.setLayout(new GridLayout(10, 10, 3, 3));
        //   inKalkulation.setLayout(new FlowLayout());
ArrayList<Anfrage> anfr_kalkul = new ArrayList<>();
        for(Anfrage af: XmlReader.anfrageList){

            if(af.getKennZahl() == 2){

                ButtonAnfrage jb = new ButtonAnfrage();
                jb.setToolTipText( "Anfrage" + af.getId() + " "+ af.getGewerk() + " " + af.getBezeichnung() + " " + af.getAnfragendeFa() + " " + af.getLand());
                jb.setText( "Anfrage " + af.getId() + "/  " + af.getBezeichnung());
                // нужно еще прописать связь кнопки с Anfrage
                jb.anfrButton = af;
                jb.addActionListener(new OpenButtonEventListener(af) );
                anfr_kalkul.add(af);
                inKalkulation.add( jb);

            }


        }

        JPanel abgabeAnKunde = new JPanel();// панель с запросами в стадии передачи клиентам
        JScrollPane feld3 = new JScrollPane(abgabeAnKunde,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Color color = new Color(51,117, 18, 230); //создаем темно зеленый цвет (первые три цифры RGB) и глубина (чертвертая цифра)
        Color colBackGreen = new Color(138, 188, 105, 80);
        abgabeAnKunde.setBackground(colBackGreen);
        abgabeAnKunde.setToolTipText("Feld mit Anfragen, die abgabereif sind");
        abgabeAnKunde.setLayout(new GridLayout(10, 10, 3, 3));
        //  inKalkulation.setLayout(new FlowLayout());
        ArrayList<Anfrage> anfr_abgabe = new ArrayList<>();
        for(Anfrage af: XmlReader.anfrageList){

            if(af.getKennZahl() == 3){

                ButtonAnfrage jb = new ButtonAnfrage();
                jb.setToolTipText( "Anfrage" + af.getId() + " "+ af.getGewerk() + " " + af.getBezeichnung() + " " + af.getAnfragendeFa() + " " + af.getLand());
                jb.setText( "Anfrage " + af.getId() + "/  " + af.getBezeichnung());
                // нужно еще прописать связь кнопки с Anfrage
                jb.anfrButton = af;
                jb.addActionListener(new OpenButtonEventListener(af) );

                anfr_abgabe.add(af);
                abgabeAnKunde.add( jb);

            }


        }

        JPanel inAusfuehrung = new JPanel(); // панель с проектами в стадии реализации
        JScrollPane feld4 = new JScrollPane(inAusfuehrung,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        Color colBackBlue = new Color(136, 179, 188, 100);
        inAusfuehrung.setBackground(colBackBlue);
        inAusfuehrung.setToolTipText("Anfragen, die in Ausführung sind");
        inAusfuehrung.setLayout(new GridLayout(10, 10, 3, 3));
        //  inKalkulation.setLayout(new FlowLayout());
        ArrayList<Anfrage> anfr_ausfuehr = new ArrayList<>();
        for(Anfrage af: XmlReader.anfrageList){

            if(af.getKennZahl() == 4){

                ButtonAnfrage jb = new ButtonAnfrage();
                jb.setToolTipText( "Anfrage" + af.getId() + " "+ af.getGewerk() + " " + af.getBezeichnung() + " " + af.getAnfragendeFa() + " " + af.getLand());
                jb.setText( "Anfrage " + af.getId() + "/  " + af.getBezeichnung());
                // нужно еще прописать связь кнопки с Anfrage
                jb.addActionListener(new OpenButtonEventListener(af));
                jb.anfrButton = af;



                anfr_ausfuehr.add(af);// добавляем заявку в малый список
                inAusfuehrung.add( jb);

            }


        }



        mainPan.add(inKalkulation, BorderLayout.CENTER);
        mainPan.add(anfrage, BorderLayout.WEST);
        mainPan.add(abgabeAnKunde, BorderLayout.EAST);
        mainPan.add(inAusfuehrung, BorderLayout.SOUTH);





        JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        setContentPane(tabbedPanel);
        tabbedPanel.add("Aktuelle Anfragen", mainPan);

        tabbedPanel.add("Korb", korb);
        tabbedPanel.add("Neue Anfrage", neueAnfPanel);


    }
    Border genTitleBorder(String title){

        Border etchedBorder = BorderFactory.createRaisedBevelBorder();
        Border titledBorder = BorderFactory.createTitledBorder(etchedBorder, title);
        return titledBorder; }


    public String getNewDate(){
        String date = this.neuDatum.getText();
        return date;
    }


    public class ButtonAnfrage extends JButton {
        Anfrage anfrButton;

          ButtonAnfrage createButton(){

            ButtonAnfrage neuButton = new ButtonAnfrage();
            String stopper = "Stoppertextbbbbbbbbbbbbbb";
            neuButton.setText(stopper);
          //  neuButton.addActionListener(new OpenButtonEventListener(af));
            // neuButton.setText(anf.bezeichnung);
            // ActionListener l = new OpenButtonEventListener();
            //neuButton.addActionListener(l);


            return neuButton;
        }



    }
    class OpenButtonEventListener implements ActionListener {
        //  ExcelParcer epa = new ExcelParcer();
Anfrage anf_Bearb;

public OpenButtonEventListener(Anfrage a){
    this.anf_Bearb = a;
}
        BearbForm bearb;
        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("кнопка нажата");
            try {
                bearb = new BearbForm();
                bearb.idText.setText(String.valueOf(anf_Bearb.getId()));
                bearb.datumText.setText(anf_Bearb.getDatumS());
                bearb.bezeichnungText.setText(anf_Bearb.getBezeichnung());
                bearb.datumText.setText(anf_Bearb.getGewerk());
                bearb.firmaText.setText(anf_Bearb.getAnfragendeFa());
                bearb.landText.setText(anf_Bearb.getLand());
                bearb.deadText.setText(anf_Bearb.getDeadline());
                bearb.summeText.setText(String.valueOf(anf_Bearb.getSumme()));
                bearb.statusText.setText(String.valueOf(anf_Bearb.getKennZahl()));
                bearb.angebNumText.setText(anf_Bearb.getAngebotsNummer());
                bearb.bezeichnungText.setText(anf_Bearb.getBeschreibung());
                bearb.kommText.setText(anf_Bearb.getKomments());



                bearb.setVisible(true);

            }catch (IOException ex) {
                Logger.getLogger(AnalyseFrame.class.getName()).log(Level.SEVERE, " Я не могу создать  форму для обработки!!!", ex);
            }

        }

    }


}
