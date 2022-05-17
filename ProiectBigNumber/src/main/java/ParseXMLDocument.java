import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ParseXMLDocument {
    public static String expr;
    public static Map<String,String> keyValueExp = new HashMap<String,String>();


    public static void parseFileXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        int lastIndexOf = fileName.lastIndexOf(".");
        String currentExtension = fileName.substring(lastIndexOf);
        String expectedExtension = ".xml";
        System.out.println(fileName.substring(lastIndexOf));
        if (!(currentExtension.equals(expectedExtension))) {
            throw new IllegalArgumentException("You must give an xml file as a parameter");
        } else {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            expr = doc.getDocumentElement().getAttribute("value");
            for (int i = 0; i <= 25; i++) {
                char valExp = (char) ('a' + i);
                NodeList nList = doc.getElementsByTagName(String.valueOf(valExp));
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        keyValueExp.put(nNode.getNodeName(), eElement.getElementsByTagName("value").item(0).getTextContent());
                    }
                }
            }


        }
    }
  
}