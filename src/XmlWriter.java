import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class XmlWriter {




    public static   void  writeXML(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element rootElement = doc.createElementNS(null, "Anfragen");
            doc.appendChild(rootElement);
                    for (Anfrage af: XmlReader.anfrageList){
                rootElement.appendChild(getAnfrage(doc, af));
            }


           // делаем новый элемент
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);

           // StreamResult file = new StreamResult(new File("src/xmlFile11.xml"));
            StreamResult file = new StreamResult((new File("Z:\\Lepeschko\\anfragenstorage\\storage1\\xmlFile11.xml")));
transformer.transform(source,file);
            System.out.println("закончили запись в файл ");


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
private static   Node getAnfrage(Document doc, Anfrage anf ){
  //  ArrayList<Anfrage> anfList = XmlReader.anfrageList;
        Element anfrageEl = doc.createElement("Anfrage");
Element idElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "id", String.valueOf(anf.getId())));

    Element datumSElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "datumS", anf.getDatumS()));

    Element bezeichnungElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "bezeichnung", String.valueOf(anf.getBezeichnung())));

    Element gewerkElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "gewerk", String.valueOf(anf.getGewerk())));

    Element firmaElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "firma", String.valueOf(anf.getAnfragendeFa())));

    Element landElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "land", String.valueOf(anf.getLand())));

    Element deadLineElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "deadline", String.valueOf(anf.getDeadline())));

    Element summeElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "summe", String.valueOf(anf.getSumme())));

    Element kennzahlElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "kennzahl", String.valueOf(anf.getKennZahl())));

    Element angebNrElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "angebotsnummer", String.valueOf(anf.getAngebotsNummer())));

    Element beschreibElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "beschreibung", String.valueOf(anf.getBeschreibung())));

    Element arbZeitElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "arbeitszeit", String.valueOf(anf.getArbeitsZeit())));

    Element kommentsElement = (Element) anfrageEl.appendChild(getAnfrageElements(doc, anfrageEl, "komments", String.valueOf(anf.getKomments())));



  //  System.out.println("данные, записываемые в файл " + anf.toString());





        return anfrageEl;
}


    private static Node getAnfrageElements(Document doc, Element element, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }



}
