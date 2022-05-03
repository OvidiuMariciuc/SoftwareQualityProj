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
    private String fileName;
    private String expr;
    private Map<String,String> keyValueExp = new HashMap<>();
    ParseXMLDocument(String fileName) {
        this.fileName = fileName;
    }
    public void parseFileXML() {
        try {
            File inputFile = new File(this.fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            this.expr = doc.getDocumentElement().getAttribute("value");
            for(int i= 0; i<=25; i++) {
                char valExp = (char) ('a' + i);
                NodeList nList = doc.getElementsByTagName(String.valueOf(valExp));
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
//                    System.out.println("\nCurrent Element :" + nNode.getNodeName());

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        this.keyValueExp.put(nNode.getNodeName(),eElement.getElementsByTagName("value").item(0).getTextContent());
//                        System.out.println("value of " + nNode.getNodeName() + " :"
//                                + eElement
//                                .getElementsByTagName("value")
//                                .item(0)
//                                .getTextContent());

                    }
                }
            }
//            System.out.println(this.keyValueExp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public Map<String, String> getKeyValueExp() {
        return keyValueExp;
    }

    public void setKeyValueExp(Map<String, String> keyValueExp) {
        this.keyValueExp = keyValueExp;
    }
}