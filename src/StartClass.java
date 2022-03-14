import javax.swing.*;
import java.awt.*;

public class StartClass {


    public  static void main(String[] args){
        System.out.println("Hallo Du!");

        XmlReader reader = new XmlReader();
       // reader.readFromFile("Z:\\Lepeschko\\anfragenstorage\\storage1\\xmlFile11.xml");
        reader.readFromFile("src\\xmlFile11.xml");
// здесь у нас создается новый список из заявок, прочитанных из файла
        // neu Komment
AnalyseFrame af = new AnalyseFrame();
        af.setVisible(true);








      //  XmlWriter writer = new XmlWriter();
        XmlWriter.writeXML();
    }
}
