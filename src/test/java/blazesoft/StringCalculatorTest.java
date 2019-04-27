package blazesoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setup() {
        stringCalculator = new StringCalculator();
    }

    /*
    Create a simple String calculator with a method int Add(string numbers)
    The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
    Start with the simplest test case of an empty string and move to 1 and two numbers
    Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
    Remember to refactor after each passing test
     */
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


}
