import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class ResultXMLFileTest {
    String expr;
    String steps;
    BigNumber result = new BigNumber();
    String err;
    @BeforeEach
    void init() {
        expr = "5 + 4 + 3";
        steps = "5 + 4 \n 9 + 3";
        result.setValue(12);
        err = "the number provided must be positive";

    }
    @Test
    public void createXMLFileWithSteps() throws ParserConfigurationException, TransformerException {
        ResultInXMLFile resultXMLFileobj = Mockito.mock(ResultInXMLFile.class);
        Mockito.verify(resultXMLFileobj, times(2))
                .createXMLFileWithSteps(expr,steps,result);

    }
    @Test
    public void createXMLFileWithError() throws ParserConfigurationException, TransformerException {
        ResultInXMLFile resultXMLFileObj = Mockito.mock(ResultInXMLFile.class);
        Mockito.verify(resultXMLFileObj, times(1))
                .createXMLFileWithError(expr,err);
    }

}
