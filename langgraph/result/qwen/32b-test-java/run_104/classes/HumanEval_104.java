import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class HumanEval_104 {

    // Source Code
    private static List<Integer> uniqueDigits(List<Integer> x) {
        List<Integer> oddDigitElements = new ArrayList<>();
        for (Integer i : x) {
            boolean allOdd = true;
            for (char c : i.toString().toCharArray()) {
                if ((c - '0') % 2 == 0) {
                    allOdd = false;
                    break;
                }
            }
            if (allOdd) {
                oddDigitElements.add(i);
            }
        }
        Collections.sort(oddDigitElements);
        return oddDigitElements;
    }

    // Transformed Code
    private static List<Integer> filterOddDigitNumbers(List<Integer> numbers) {
        List<Integer> oddDigitNumbers = new ArrayList<>();
        Iterator<Integer> iterator = numbers.iterator();
        
        while (iterator.hasNext()) {
            int number = iterator.next();
            String numberStr = Integer.toString(number);
            boolean allOddDigits = true;
            
            for (char digit : numberStr.toCharArray()) {
                if ((digit - '0') % 2 == 0) {
                    allOddDigits = false;
                    break;
                }
            }
            
            if (allOddDigits) {
                oddDigitNumbers.add(number);
            }
        }
        
        Collections.sort(oddDigitNumbers);
        return oddDigitNumbers;
    }

    // Test Cases
    private static final List<Integer>[][] testCases = {
        {Arrays.asList(135, 246, 357, 579)},
        {Arrays.asList(111, 333, 555, 777, 999)},
        {Arrays.asList(222, 444, 666, 888)},
        {Arrays.asList(13579, 2468, 12345)},
        {Arrays.asList(1, 3, 5, 7, 9)},
        {Arrays.asList(0, 2, 4, 6, 8)},
        {Arrays.asList(135, 579, 791, 913)},
        {Arrays.asList()},
        {Arrays.asList(113, 135, 357, 579)},
        {Arrays.asList(123, 321, 213, 456)}
    };

    private static java.util.stream.Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void uniqueDigits_vs_filterOddDigitNumbers(List<Integer> input) {
        assertEquals(uniqueDigits(input), filterOddDigitNumbers(input));
    }
}