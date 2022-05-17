import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import static org.mockito.Mockito.mock;

public class ResultXMLFileTest {
    public String expr;
    public String expr1;
    public String steps;
    public BigNumber result = new BigNumber();
    public String err;

    @Mock
    private ResultInXMLFile resultXMLFileObj = mock(ResultInXMLFile.class);
    @Mock
    private ResultInXMLFile resultXMLFileObj1 = mock(ResultInXMLFile.class);

    @BeforeEach
    void init() {
        expr = "5 + 4 + 3";
        expr1 = "3 + 4";
        steps = "5 + 4 \n 9 + 3";
        result.setValue(12);
        err = "the number provided must be positive";

    }
    @Test
    public void createXMLFileWithSteps() throws ParserConfigurationException, TransformerException {
        resultXMLFileObj.createXMLFileWithSteps(expr,steps,result);
        Mockito.verify(resultXMLFileObj)
                .createXMLFileWithSteps(expr,steps,result);

    }
//    @Test
//    public void createXMLFileWithError() throws ParserConfigurationException, TransformerException {
//        resultXMLFileObj1.createXMLFileWithError(expr1,err);
//        Mockito.verify(resultXMLFileObj1)
//                .createXMLFileWithError(expr1,err);
//
//    }

}
