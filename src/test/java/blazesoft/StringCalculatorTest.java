package blazesoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldReturn0OnEmptyString() {
        String input = "";
        int output = stringCalculator.add(input);

        assertEquals(0, output);
    }

    @Test
    public void shouldReturnSumOfOneNumber() {
        String input = "3";
        int output = stringCalculator.add(input);

        assertEquals(3, output);
    }

    @Test
    public void shouldReturnSumOfTwoCommaSeparatedNumbers() {
        String input = "3,5";
        int output = stringCalculator.add(input);

        assertEquals(8, output);
    }

    @Test
    @Disabled
    public void shouldNotSupportMoreThanTwoNumbers() {
        String input = "1,3,5";
        assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add(input));

    }

    @Test
    public void shouldSupportMoreThanTwoNumbers() {
        String input = "1,3,5";
        int output = stringCalculator.add(input);

        assertEquals(9, output);
    }

    @Test
    public void shouldSupportNewLinesBetweenNumbers() {
        String input = "1\n2,3";
        int output = stringCalculator.add(input);

        assertEquals(6, output);
    }

    @Test
    public void shouldSupportCustomDelimiterBetweenNumbers() {
        String input = "//;\n1;2;3";
        int output = stringCalculator.add(input);

        assertEquals(6, output);
    }

    @Test
    public void shouldNotAllowNegativeNumbers() {
        String input = "-1,3,-5";
        NegativesNotAllowedException thrown = assertThrows(NegativesNotAllowedException.class,
                () -> stringCalculator.add(input));

        assertEquals("-1,-5", thrown.getMessage());
    }

    @Test
    public void shouldIgnoreValuesGreaterThan1000() {
        String input = "2,1001";
        int output = stringCalculator.add(input);

        assertEquals(2, output);
    }

    @Test
    public void shouldSupportMulticharDelimiters() {
        String input = "//[***]\n1***2***3";
        int output = stringCalculator.add(input);

        assertEquals(6, output);
    }

    @Test
    public void shouldSupportMultipleDelimiters() {
        String input = "//[*][%]\n1*2%3";
        int output = stringCalculator.add(input);

        assertEquals(6, output);
    }

    @Test
    public void shouldSupportMultipleMulticharDelimiters() {
        String input = "//[*&][%#]\n1*&2%#3";
        int output = stringCalculator.add(input);

        assertEquals(6, output);
    }

}
