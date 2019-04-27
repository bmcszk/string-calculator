package blazesoft;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        return Stream.of(splitNumbers(numbers))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String[] splitNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, 3);
            numbers = numbers.split("\n", 2)[1];
            return numbers.split(Pattern.quote(delimiter));
        } else {
            return numbers.split(",|\n");
        }
    }
}
