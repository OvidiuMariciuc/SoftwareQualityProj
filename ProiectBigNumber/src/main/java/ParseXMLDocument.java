import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseXMLDocument {
    public static String expr;
    public static Map<String,String> keyValueExp = new HashMap<>();


    public static void parseFileXML(String fileName) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            expr = doc.getDocumentElement().getAttribute("value");
            for(int i= 0; i<=25; i++) {
                char valExp = (char) ('a' + i);
                NodeList nList = doc.getElementsByTagName(String.valueOf(valExp));
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        keyValueExp.put(nNode.getNodeName(),eElement.getElementsByTagName("value").item(0).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
  
}