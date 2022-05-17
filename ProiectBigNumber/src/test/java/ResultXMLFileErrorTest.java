import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import static org.mockito.Mockito.mock;

public class ResultXMLFileErrorTest {

    public String expr;
    public String err;


    @Mock
    private ResultInXMLFile resultXMLFileObj1 = mock(ResultInXMLFile.class);

    @BeforeEach
    void init() {
        expr = "3 + 4";
        err = "the number provided must be positive";

    }

    @Test
    public void createXMLFileWithError() throws ParserConfigurationException, TransformerException {
        resultXMLFileObj1.createXMLFileWithError(expr,err);
        Mockito.verify(resultXMLFileObj1)
                .createXMLFileWithError(expr,err);

    }
}
