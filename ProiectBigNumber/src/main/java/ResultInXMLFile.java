import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class ResultInXMLFile {

    public static void createXMLFileWithSteps(String expr, String stepsResult, BigNumber resultExpr ) throws ParserConfigurationException, TransformerException {
            assert expr != null :"expression should be different from null";
            assert stepsResult != null  :"number of steps should be different from null";
            assert resultExpr != null : "the result should be different from null";

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("expr");
            Attr attr = doc.createAttribute("value");
            attr.setValue(expr);
            rootElement.setAttributeNode(attr);
            doc.appendChild(rootElement);
            Element steps = doc.createElement("steps");
            rootElement.appendChild(steps);
            String[] stepsSplit = stepsResult.split("\n");

            for (int i = 0; i < stepsSplit.length; i++) {
                Element carname = doc.createElement("step" + String.valueOf(i));
                carname.appendChild(doc.createTextNode(stepsSplit[i]));
                steps.appendChild(carname);
            }
            Element resultElement = doc.createElement("result");
            resultElement.appendChild(doc.createTextNode(resultExpr.toString()));
            rootElement.appendChild(resultElement);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("result.xml"));
            transformer.transform(source, result);
    }

    public static void createXMLFileWithError(String expr, String errorMsg) throws ParserConfigurationException, TransformerException {

            assert expr != null :"expression should be different from null";
            assert errorMsg != null  :"error message should be different from null";

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("expr");
            Attr attr = doc.createAttribute("value");
            attr.setValue(expr);
            rootElement.setAttributeNode(attr);
            doc.appendChild(rootElement);

            Element errElement = doc.createElement("error");
            errElement.appendChild(doc.createTextNode(errorMsg));

            rootElement.appendChild(errElement);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("result.xml"));
            transformer.transform(source, result);

    }

}
