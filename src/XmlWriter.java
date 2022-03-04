import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Date;

public class XmlWriter {




    public  void  writeXML(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElementNS(null, "Anfragen");
            doc.appendChild(rootElement);
            rootElement.appendChild(getAnfrage(doc));// делаем новый элемент




        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
private static   Node getAnfrage(Document doc ){
    ArrayList<Anfrage> anfList = XmlReader.anfrageList;
        Element anfrage = doc.createElement("Anfrage");
for (Anfrage anf: anfList){
    anf.setId(Integer.parseInt("2")); // здесь мы будем сохранять новые значения параметров запроса после редактирования
anf.setDatumS(new Date().toString() + "actuelles Datum ");
// формируем заявку для записи в файл
    anfrage.setAttribute("id", String.valueOf(anf.id));
    anfrage.setAttribute("datimS", anf.datumS);
    anfrage.setAttribute("a", anf.bezeichnung );
    anfrage.setAttribute("b", anf.gewerk );
    anfrage.setAttribute("c", anf.anfragendeFa);
    anfrage.setAttribute("d", anf.land );
    anfrage.setAttribute("e", anf.deadline);
    anfrage.setAttribute("f", String.valueOf(anf.getSumme()));
    anfrage.setAttribute("ort", String.valueOf(anf.getKennZahl()));
    anfrage.setAttribute("teil", anf.angebotsNummer);
    anfrage.setAttribute("beschreibung", anf.beschreibung);
    anfrage.setAttribute("arbeitszeit", anf.arbeitsZeit);
    anfrage.setAttribute("komments", anf.komments);

    System.out.println("данные, записываемые в файл " + anf.toString());
}




        return anfrage;
}


    private static Node getAnfrageElements(Document doc, Element element, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }



}
