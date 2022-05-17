import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ParseXMLDocumentTest {
    public String exprExpected;
    public Map<String,String> keyValueExpExpected = new HashMap<String,String>();
    public String fileNameValid;
    public String fileExtensionInvalid;
    public String fileDoesntExist;

    @BeforeEach
    void init() {
        fileNameValid = "input.xml";
        fileExtensionInvalid = "output.csv";
        fileDoesntExist = "output.xml";
        exprExpected = "a ^ b / ( b + c ) + d * e";
        keyValueExpExpected  = new HashMap<String,String>() {{
            put("a", "9");
            put("b", "2");
            put("c", "7");
            put("d", "5");
            put("e", "4");
        }};
    }

    @Test
    public void parseFileXMLValidFileTest() throws ParserConfigurationException, IOException, SAXException {
        ParseXMLDocument.parseFileXML(fileNameValid);
        assertEquals(exprExpected, ParseXMLDocument.expr);
        assertEquals(keyValueExpExpected, ParseXMLDocument.keyValueExp);
    }

    @Test
    public void parseFileXMLInvalidExtensionFileTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParseXMLDocument.parseFileXML(fileExtensionInvalid);
        });
        Assertions.assertEquals("You must give an xml file as a parameter", exception.getMessage());
    }
    @Test
    public void parseFileXMLFileDoesntExist() {
        Exception exception = assertThrows(java.io.FileNotFoundException.class, () -> {
            ParseXMLDocument.parseFileXML(fileDoesntExist);
        });

//        File fileObject = new File(fileDoesntExist);
//        DocumentBuilder dBuilder  = mock(DocumentBuilder.class);
//        Mockito.when(dBuilder.parse(fileObject)).thenThrow(FileNotFoundException.class);

    }

}
