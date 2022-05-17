import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InfixToPostFixTest {

    @Test
    public void shouldSucceedOnValidExpression() {
        // Given
        final String expectedExpression = "5 5 6 * + 2 + 7 - 2 / 2 ^ ";

        // When
        String actualExpression = InfixToPostFix.infixToPostFix("( ( 5 + 5 * 6 + 2 - 7 ) / 2 ) ^ 2");

        // Then
        assertEquals(expectedExpression, actualExpression);
    }

    @Test
    public void shouldThrowEmptyStackExceptionWhenNotEnoughOperators() {
        // Given
        EmptyStackException emptyStackException = new EmptyStackException();

        // When
        EmptyStackException exception = assertThrows(EmptyStackException.class, () ->
                InfixToPostFix.infixToPostFix("1 2 3"));

        // Then
        assertEquals(emptyStackException.getMessage(), exception.getMessage());
    }
}
