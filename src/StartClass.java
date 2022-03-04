import javax.swing.*;
import java.awt.*;

public class StartClass {


    public  static void main( String args[]){
        System.out.println("Hallo Du!");

        XmlReader reader = new XmlReader();
        reader.readFromFile("src/xmlFile.xml");
// здесь у нас создается новый список из заявок, прочитанных из файла
AnalyseFrame af = new AnalyseFrame();
        af.setVisible(true);








        XmlWriter writer = new XmlWriter();
        writer.writeXML();
    }
}
