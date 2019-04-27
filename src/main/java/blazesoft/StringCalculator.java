package blazesoft;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    public int add(String numbers) {
        if ("".equals(numbers)) {
            return 0;
        }

        List<Integer> numberList = Stream.of(splitNumbers(numbers))
                .map(Integer::parseInt)
                .filter(n -> n <= 1000)
                .collect(Collectors.toList());

        validateNumbers(numberList);

        return numberList
                .stream()
                .mapToInt(x -> x)
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

    private void validateNumbers(List<Integer> numberList) {
        List<Integer> negatives = numberList.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (negatives.size() > 0) {
            String exceptionMessage = negatives.stream()
                    .map(n -> n.toString())
                    .collect(Collectors.joining(","));

            throw new NegativesNotAllowedException(exceptionMessage);
        }

    }

}
