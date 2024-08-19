package javaapplication6;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class JavaApplication6 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, IOException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File("dl.xml");
        Document doc = builder.parse(f);

        Element root = doc.getDocumentElement();

        System.out.println("Root element: " + root.getNodeName());

        int[] tablica = new int[49];

        NodeList dzieciRoota = root.getChildNodes();
        for (int i = 0; i < dzieciRoota.getLength(); i++) {
            Node dzieckoRoota = dzieciRoota.item(i);
            if (dzieckoRoota.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("Element: " + dzieckoRoota.getNodeName());
                if (dzieckoRoota.hasChildNodes()) {
                    NodeList wnukiRoota = dzieckoRoota.getChildNodes();
                    for (int j = 0; j < wnukiRoota.getLength(); j++) {
                        Node wnukRoota = wnukiRoota.item(j);
                        if (wnukRoota.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("  Element: " + wnukRoota.getNodeName());
                            if(wnukRoota.getNodeName().equals("numer")) {
                                String textContent = wnukRoota.getTextContent().trim();
                                try {
                                    int number = Integer.parseInt(textContent);
                                    if (number >= 1 && number <= 49) {
                                        tablica[number - 1] += 1;
                                    }
                                } catch (NumberFormatException e) {
                                }
                            }
                        } else if (wnukRoota.getNodeType() == Node.TEXT_NODE) {
                            String textContent = wnukRoota.getTextContent().trim();
                            if (!textContent.isEmpty()) {
                                System.out.println("  Text: " + textContent);
                            }
                        }
                    }
                }
            } else if (dzieckoRoota.getNodeType() == Node.TEXT_NODE) {
                String textContent = dzieckoRoota.getTextContent().trim();
                if (!textContent.isEmpty()) {
                    System.out.println("Text: " + textContent);
                }
            }
        }

        System.out.println("Zawartość tablicy:");
        for (int i = 0; i < tablica.length; i++) {
            System.out.println((i + 1) + ": " + tablica[i]);
        }
        int max=tablica[0];
        int min=tablica[0];
        for (int i = 0; i < tablica.length; i++) {
            if(tablica[i]>max)
            {
                max=tablica[i];
            }
            if(tablica[i]<min)
            {
                min=tablica[i];
            }
        }
        System.out.println("max: "+ ": " + max);
        System.out.println("min: "+ ": " + min);
    }
}