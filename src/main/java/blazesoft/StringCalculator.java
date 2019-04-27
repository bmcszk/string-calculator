package blazesoft;

import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        String[] numberArray = numbers.split(",|\n");

        return Stream.of(numberArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
