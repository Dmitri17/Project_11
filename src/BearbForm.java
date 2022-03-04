import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;


public class BearbForm extends JFrame {

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
   String neuKommentText = "";


    String formName = "Bezeichnung aus der Liste"; // название окна будет соотсветствовать названию запроса

    JPanel pan0 = new JPanel();// главная панель для размещения всего остального

    JPanel pan1 = new JPanel();// панель для размещения верхней группы

    JPanel pan11 = new JPanel();// панель для размещения левого крыла верхней группы

    JPanel pan12 = new JPanel();// панель для размещения средней группы

    JPanel pan13 = new JPanel(); // панель для размещения правой группы
    JPanel pan131 = new JPanel();// панель для логотипа
    JPanel pan2 = new JPanel(); // панель для средней части


    JPanel pan3 = new JPanel(); // панель для нижней части экрана

    JPanel pan31 = new JPanel(); // панель для нового комментария

    JPanel pan32 = new JPanel(); // панель для кнопки и боксов-переключения


    JTextArea kommText = new JTextArea(20, 50);// текстовое поле для средней части

    JTextArea neuKomment = new JTextArea();// поле для новой записи в комментарии
    JLabel logo = new JLabel();
    JTextArea landText = new JTextArea("Das Land");
    JTextArea gewerkText = new JTextArea("Das Gewerk");
    JTextArea idText =  new JTextArea("ID Nummer");
    JTextArea summeText = new JTextArea("Summe der Anfrage");
    JTextArea firmaText = new JTextArea("Firmenname");
    JTextArea bezeichnungText = new JTextArea("Bezeichnung der Anfrage  nbdfbhfgbx" +
            "fgndfbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbnnnnnnnnnxxxxxxxxx");
    JTextArea angebNumText = new JTextArea("Angebotsnummer");
    JTextArea datumText = new JTextArea("Datum der Anfrage");
    JTextArea deadText = new JTextArea("Deadline");
    JTextArea statusText = new JTextArea("Statuskennzahl");
    JTextArea arbZeitText = new JTextArea("Arbeitszeit");
    Container container = null;
    JButton saveButton = new JButton("Einen Kommentar Schreiben und speichern");
    JCheckBox editButton = new JCheckBox();




    public BearbForm() throws IOException{
        super();


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

        pan131.setBorder(genTitleBorder(""));


        pan131.add(logo);
        pan131.setBackground(Color.WHITE);
        pan131.setAlignmentX(CENTER_ALIGNMENT);

        pan12= generPan(""); // формируем среднюю группу сверху
        pan12.setLayout(new BorderLayout());
        pan12.add(pan131, BorderLayout.NORTH);

        bezeichnungText.setLineWrap(true);
        bezeichnungText.setWrapStyleWord(true);
        bezeichnungText.setBorder(genTitleBorder("Bezeichnung"));
        JScrollPane bezeichnScroll = new JScrollPane(bezeichnungText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        bezeichnScroll.setBorder(genTitleBorder(""));
        pan12.add(bezeichnScroll, BorderLayout.CENTER);
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
        pan13.add(arbZeitText);

        summeText.setBorder(genTitleBorder("Summe Euro"));
        pan13.add(summeText);
        pan1.add(pan13);// сформировали верхнюю панель
        // kommText.setBackground(Color.LIGHT_GRAY);


        JScrollPane komments = new JScrollPane(kommText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // панель с прокруткой для средней части
        kommText.setLineWrap(true);
        kommText.setWrapStyleWord(true);
        for (int i = 0; i <= 200; i++){kommText.append("Область для ввода текстового содержимого ");}



//kommText.setText("некоторый декст комментариев по теме mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmзаявки заказа или общей процедуре рррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррррр");
        Border etched2 = BorderFactory.createRaisedBevelBorder();
        Border titled2 = BorderFactory.createTitledBorder(etched2, "Ablauf und Komments");

        pan2.setLayout(new BorderLayout());
        pan2.setBorder(titled2);
        pan2.add(komments, BorderLayout.CENTER);
        pan2.setBackground(Color.LIGHT_GRAY);
     /* neuKomment.setSize(300,100);
    JScrollPane neuKomm = new JScrollPane(neuKomment, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


     pan3.add(neuKomm, BorderLayout.CENTER);
     neuKomment.setLineWrap(true);
     neuKomment.setWrapStyleWord(true);
     neuKomment.setEditable(true);*/
        editButton.setText("Anfrage ändern");
        editButton.setToolTipText("Taste drucken um die Anfragedaten zu ändern");
        pan3.add(editButton, BorderLayout.WEST);
        pan3.add(saveButton, BorderLayout.EAST);
        //  JLabel picLabel = new JLabel();



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

}
