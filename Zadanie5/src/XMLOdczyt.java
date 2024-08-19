import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLOdczyt {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File("dane.xml");
        Document doc = builder.parse(f);
        
        Element root = doc.getDocumentElement();
        
        System.out.println(root.getNodeName());
        System.out.println(root.getNodeValue());
        
        Node pierwszeDzieckoRoota = root.getFirstChild();
        
        System.out.println(pierwszeDzieckoRoota.getNodeName());
        System.out.println(pierwszeDzieckoRoota.getNodeValue());
        
        Node drugieDzieckoRoota = pierwszeDzieckoRoota.getNextSibling();
        
        System.out.println(drugieDzieckoRoota.getNodeName());
        System.out.println(drugieDzieckoRoota.getNodeValue());
        
        Node drugiWnukRoota = drugieDzieckoRoota.getFirstChild();
        
        System.out.println(drugiWnukRoota.getNodeName());
        System.out.println(drugiWnukRoota.getNodeValue());
        
        System.out.println("Dzieci Roota: ");
        
        NodeList dzieciRoota = root.getChildNodes();
        
        for (int i = 0; i < dzieciRoota.getLength(); i++) {
            Node dzieckoRoota = dzieciRoota.item(i);
            System.out.println(dzieckoRoota.getNodeName());
            System.out.println(dzieckoRoota.getNodeValue());
        }

    }

}
