import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigNumberTest {

    BigNumber number1;
    BigNumber number2;
    BigNumber number3;
    BigNumber number4;
    BigNumber number5;
    BigNumber number6;

    @BeforeEach
    void init() {

        number1 = new BigNumber();
        number1.setValue("1338923289");

        number2 = new BigNumber();
        number2.setValue("3338923289");

        number3 = new BigNumber();
        number3.setValue("3338923289");

        number4 = new BigNumber();
        number4.setValue("13389232");

        number5 = new BigNumber();
        number5.setValue("54312343123");

        number6 = new BigNumber();
        number6.setValue("1232133");
    }

    @Test
    public void compareToLowerTest() {

        int comparisonResult = number1.compareTo(number2);
        assertEquals(-1, comparisonResult);

    }

    @Test
    public void compareToGreaterTest() {

        int comparisonResult = number2.compareTo(number1);
        assertEquals(1, comparisonResult);

    }

    @Test
    public void compareToEqualTest() {

        int comparisonResult = number2.compareTo(number3);
        assertEquals(0, comparisonResult);

    }

    @Test
    public void equalsLengthTest() {

        String[] results = BigNumber.equalLengths(number1, number4);
        String[] expectedResults = new String[2];
        expectedResults[0] = "1338923289";
        expectedResults[1] = "0013389232";

        assertArrayEquals(expectedResults, results);

    }
    @Test
    public void constructorWithNegativeNumberTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BigNumber(-55555);
        });

        Assertions.assertEquals("the number provided must be positive", exception.getMessage());
    }
    @Test
    public void addTest() {

        number1.add(number2);
        assertEquals("4677846578", number1.toString());

    }

    @Test
    public void subWithoutErrorTest() {

        number3.sub(number4);
        assertEquals("3325534057", number3.toString());

    }

    @Test
    public void subWithErrorTest() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            number4.sub(number3);
        });

    }
    @Test
    public void subtractionTest() {
        assertEquals("54311110990", BigNumber.substract(number5.toString(), number6.toString()));
    }
    @Test
    public void multiplyTest() {
        assertEquals("66920030269171359", BigNumber.multiply(number5.toString(), number6.toString()));
    }

    @Test
    public void divWithoutErrorTest() {
        assertEquals("10862468624", BigNumber.divide(number5.toString(), 5));
    }

    @Test
    public void divWithErrorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            number5.div(0);
        });

        Assertions.assertEquals("the divisor must be different from 0", exception.getMessage());

    }

    @Test
    public void powerTest() {
        assertEquals("472598889541954688994529153562626065538335685532371843", BigNumber.power(number5.toString(), 5));

    }
    @Test
    public void power0Test() {
        assertEquals("1", BigNumber.power(number5.toString(), 0));

    }


}
