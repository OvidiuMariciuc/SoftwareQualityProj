import java.io.*;

public class BigNumber implements Comparable<BigNumber> {

    private String value;

    public BigNumber() {
        value = "0";
    }

    public BigNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                throw new IllegalArgumentException("the number provided contains illegal characters");
            }
        }
        if (value.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public BigNumber(int value) {
        if (value < 0)
            throw new IllegalArgumentException("the number provided must be positive");
        this.value = Integer.toString(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = Integer.toString(value);
    }

    public int length() {
        return value.length();
    }

    public char[] chars() {
        return this.value.toCharArray();
    }

    //x1.compareTo(x2)
    @Override
    public int compareTo(BigNumber number) {

        assert number != null : "checking if the 2nd number we are trying to compare is not null (x2)";
        assert this.value != null : "checking if the 1st number we are trying to compare is not null (x1)";
        if (this.length() > number.length())
            return 1;
        if (this.length() < number.length())
            return -1;

        char[] valueChars = this.chars();
        char[] numberChars = number.chars();

        for (int i = 0; i < this.length(); i++) {

            int valueDigit = Character.getNumericValue(valueChars[i]);
            int numberDigit = Character.getNumericValue(numberChars[i]);
            assert valueDigit >= 0 && valueDigit <=9:"checking if it is a valid digit";
            assert numberDigit >= 0 && numberDigit <=9:"checking if it is a valid digit";

            if (valueDigit > numberDigit)
                return 1;
            if (valueDigit < numberDigit)
                return -1;
        }

        return 0;
    }

    //retuning two BigNumbers as Strings with the same length
    //by adding zeroes to front if one is shorter than the other
    // equalLengths(9998, 68) -> String[] = {9998, 0068}
    public static String[] equalLengths(BigNumber x, BigNumber y) {

        assert x != null : "checking if x is not null";
        assert y != null : "checking if y is not null";
        String xVal;
        String yVal;

        if (x.length() == y.length()) {
            xVal = x.getValue();
            yVal = y.getValue();
        } else if (x.length() > y.length()) {
            xVal = x.getValue();
            yVal = "0".repeat(x.length() - y.length()) + y.getValue();
        } else {
            yVal = y.getValue();
            xVal = "0".repeat(y.length() - x.length()) + x.getValue();
        }

        assert xVal.length() == yVal.length() : "checking if the numbers have the same length";
        return new String[]{xVal, yVal};
    }

    //x1.add(x2) => x1 = x1 + x2;
    public void add(BigNumber number) {

        assert number != null : "checking if the number we are trying to add is not null (x2)";
        assert this.value != null : "checking if the number to which we add the other number is not null (x1)";
        String[] numbers = equalLengths(number, this);
        char[] valueChars = numbers[0].toCharArray();
        char[] numberChars = numbers[1].toCharArray();

        int overflow = 0;

        StringBuilder result = new StringBuilder();
        for (int i = valueChars.length - 1; i >= 0; i--) {

            int valueDigit = Character.getNumericValue(valueChars[i]);
            int numberDigit = Character.getNumericValue(numberChars[i]);
            assert valueDigit >= 0 && valueDigit <=9:"checking if it is a valid digit";
            assert numberDigit >= 0 && numberDigit <=9:"checking if it is a valid digit";

            int digitSum = valueDigit + numberDigit + overflow;
            assert digitSum == valueDigit + numberDigit + overflow:"";

            result.append(digitSum % 10);
            assert result.length() == valueChars.length - i:"checking the length of the resulted number at step i";
            overflow = digitSum / 10;
        }

        this.value = (overflow == 0 ? "" : "1") + result.reverse().toString();
    }

    public void sub(BigNumber number) {
        assert number != null : "checking if the number we are trying to add is not null (x2)";
        assert this.value != null : "checking if the number to which we add the other number is not null (x1)";

        int compare = this.compareTo(number);
        if (compare == 0) {
            this.setValue(0);
        } else if (compare < 0) {
            throw new IllegalArgumentException("the difference must be positive");
        } else {

            String[] numbers = equalLengths(number, this);
            char[] valueChars = numbers[1].toCharArray();
            char[] numberChars = numbers[0].toCharArray();

            int overflow = 0;
            StringBuilder result = new StringBuilder();
            for (int i = valueChars.length - 1; i >= 0; i--) {

                int valueDigit = Character.getNumericValue(valueChars[i]) + overflow;
                int numberDigit = Character.getNumericValue(numberChars[i]);
                assert valueDigit >= 0 && valueDigit <= 9: "checking if it is a valid digit";
                assert numberDigit >= 0 && numberDigit <= 9: "checking if it is a valid digit";

                overflow = 0;

                if (valueDigit < numberDigit) {
                    overflow = -1;
                    valueDigit += 10;
                }

                result.append(valueDigit - numberDigit);
            }

            while (result.charAt(result.length() - 1) == '0') {
                result.deleteCharAt(result.length() - 1);
            }

            this.setValue(result.reverse().toString());

        }
    }

    public void mult(BigNumber y) {
        char[] yChars = y.chars();
        String num = this.getValue();
        this.setValue(0);

        for (int i = 0; i < y.length(); i++) {
            int digit = Character.getNumericValue(yChars[yChars.length - 1 - i]);
            this.add(new BigNumber(multByInt(digit, num, i, 0, new StringBuilder())));
        }
    }

    private static String multByInt(int x, String num, int powerOf10, int overflow, StringBuilder sb) {
        if (num.length() == 0) {

            return (overflow == 0 ? "" : Integer.toString(overflow))
                    + sb.reverse().toString()
                    + "0".repeat(powerOf10);
        }

        final char digit = num.toCharArray()[num.length() - 1];
        final int product = Character.getNumericValue(digit) * x + overflow;
        sb.append(product % 10);

        return multByInt(x, num.substring(0, num.length() - 1), powerOf10, product / 10, sb);
    }

    public void div(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("the divisor must be different from 0");
        } else {
            StringBuilder quotient = new StringBuilder();
            char[] dividend = this.chars();
            int overflow = 0;

            for (int i = 0; i < dividend.length; i++) {
                int digit = overflow * 10 + Character.getNumericValue(dividend[i]);
                quotient.append(digit / divisor);
                overflow = digit % divisor;
            }

            while (quotient.charAt(0) == '0')
                quotient.deleteCharAt(0);

            this.setValue(quotient.toString());
        }
    }

    public void pow(long n) {
        if (n == 0) {
            this.setValue(1);
        } else {
            BigNumber initial = new BigNumber(this.value);
            for (int i = 1; i < n; i++) {
                this.mult(initial);
            }
        }
    }

    public static String add(String x, String y) {
        BigNumber result = new BigNumber(x);
        result.add(new BigNumber(y));
        return result.getValue();
    }

    public static String substract(String x, String y) {
        BigNumber result = new BigNumber(x);
        result.sub(new BigNumber(y));
        return result.getValue();
    }

    public static String multiply(String x, String y) {
        BigNumber result = new BigNumber(x);
        result.mult(new BigNumber(y));
        return result.getValue();
    }

    public static String divide(String x, int y) {
        BigNumber result = new BigNumber(x);
        result.div(y);
        return result.getValue();
    }

    public static String power(String x, long y) {
        BigNumber result = new BigNumber(x);
        System.out.println(x);
        System.out.println(y);
        result.pow(y);
        return result.getValue();
    }

    @Override
    public String toString() {
        return value;
    }
}
