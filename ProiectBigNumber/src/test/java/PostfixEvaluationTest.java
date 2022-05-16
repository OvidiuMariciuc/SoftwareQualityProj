import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostfixEvaluationTest {
    @Test
    public void isOperatorTest() {
        assertEquals(true, PostfixEvaluation.isOperator("+"));
    }

    @Test
    public void isNotOperatorTest() {
        assertEquals(false, PostfixEvaluation.isOperator("&"));
    }

    @Test
    public void evaluatePostFixTest() {
        assertEquals("24", PostfixEvaluation.evaluatePostfix("9 2 ^ 2 7 + / 5 3 * + ").toString());
    }

    @Test
    public void evaluatePostFixWithErrorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PostfixEvaluation.evaluatePostfix("92^27+/53*+");
        });
    }

    @Test
    public void evaluatePostFixWithWrongExpressionTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PostfixEvaluation.evaluatePostfix("34-");
        });
    }

    @Test
    public void evaluatePostFixExpressionEqualsNegativeTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PostfixEvaluation.evaluatePostfix(" 100 200 + 150 200 + - ");
        });
    }

    @Test
    public void buildExpressionTest() {
        assertEquals("9 + 10 = 19\n", PostfixEvaluation.buildExpression("+", "9", "10", "19"));
    }
}
