package blazesoft;

import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        String[] numberArray = numbers.split(",");
        if (numberArray.length > 2) {
            throw new IllegalArgumentException("More than 2 numbers are not supported");
        }

        return Stream.of(numberArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
