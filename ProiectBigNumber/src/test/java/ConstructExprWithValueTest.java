import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructExprWithValueTest {

    String expr;
    Map<String,String> keyValExpr;

    @BeforeEach
    void init() {
        expr = "a + b + c";
        keyValExpr = new HashMap<String,String>() {{
            put("a", "5");
            put("b", "9579245329");
            put("c", "23333333423423454");
        }};
    }

    @Test
    public void constructExprWithValueTest() {
        String currentResult = ConstructExprWithValue.constructExprWithValue(expr, keyValExpr);
        String expectedResult = "5 + 9579245329 + 23333333423423454";
        assertEquals(expectedResult, currentResult);
    }
}
