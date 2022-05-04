import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigNumberTest {

    BigNumber number1;
    BigNumber number2;
    BigNumber number3;
    BigNumber number4;

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

}
