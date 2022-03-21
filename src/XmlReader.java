import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class XmlReader {

    String name = "xmlFile11";
    String textErgebnis = "";
   static ArrayList<Anfrage> anfrageList =  new ArrayList<>();

    public  void readFromFile(String fileName){// метод для чтения из файла
       File xmlFile = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try{
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: "+ document.getDocumentElement().getNodeName());
            // выводим имя корневого элемента для тестирования
            NodeList nodeList = document.getElementsByTagName("Anfrage");

            for(int i = 0; i < nodeList.getLength(); i ++){
                anfrageList.add( getAnfrage(nodeList.item(i)));

            }
            for (Anfrage anf: anfrageList){
                textErgebnis = new StringBuilder().append(textErgebnis).append(anf.toString()).toString();
                System.out.println(" данные из файла  " + textErgebnis); // вывод данных из файла
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static Anfrage getAnfrage(Node node){
        Anfrage anfrage = new Anfrage();
        if(node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            anfrage.setId(Integer.parseInt(getTagValue("id", element)));
            anfrage.setDatumS(getTagValue("datumS", element));
            anfrage.setBezeichnung(getTagValue("bezeichnung", element));
            anfrage.setGewerk(getTagValue("gewerk", element));
            anfrage.setAnfragendeFa(getTagValue("firma", element));
            anfrage.setLand(getTagValue("land", element));
            anfrage.setDeadline(getTagValue("deadline", element));
            anfrage.setSumme(getTagValue("summe", element));
            anfrage.setKennZahl(Integer.parseInt(getTagValue("kennzahl", element)));
            anfrage.setAngebotsNummer(getTagValue("angebotsnummer", element));
            anfrage.setBeschreibung(getTagValue("beschreibung", element));
        anfrage.setArbeitsZeit(getTagValue("arbeitszeit", element));
        anfrage.setKomments(getTagValue("komments", element));
        }
        return anfrage;

    }
    private static String getTagValue(String tag, Element element){
        NodeList nodelist = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node =  nodelist.item(0);
        return node.getNodeValue() ;
    }






}
