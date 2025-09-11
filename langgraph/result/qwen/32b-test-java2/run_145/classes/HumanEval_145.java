import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Original implementation nested class
class OriginalImpl {
    public static List<Integer> orderByPoints(List<Integer> nums) {
        return nums.stream()
                   .sorted(Comparator.comparingInt(OriginalImpl::digitsSum))
                   .collect(Collectors.toList());
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        String[] digits = String.valueOf(n).split("");
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Integer.parseInt(digits[i]);
        }
        sum *= neg;
        return sum;
    }
}

// Transformed implementation nested class
class TransformedImpl {
    public static List<Integer> sortNumbersByDigitSum(List<Integer> numbers) {
        Comparator<Integer> byDigitSum = new Comparator<Integer>() {
            @Override
            public int compare(Integer number1, Integer number2) {
                return Integer.compare(calculateWeight(number1), calculateWeight(number2));
            }
        };

        Collections.sort(numbers, byDigitSum);
        return numbers;
    }

    private static int calculateWeight(int number) {
        int sign = number < 0 ? -1 : 1;
        int absoluteValue = Math.abs(number);
        String numberStr = Integer.toString(absoluteValue);
        int[] digits = new int[numberStr.length()];
        
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        
        digits[0] *= sign;
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        
        return sum;
    }
}

// Test class
public class HumanEval_145 {

    // Provide test cases method
    public static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(123, 321, 213), List.of(123, 213, 321)),
            Arguments.of(List.of(-12, -21, 12, 21), List.of(-12, 12, -21, 21)),
            Arguments.of(List.of(0, 5, 10, 15), List.of(0, 5, 10, 15)),
            Arguments.of(List.of(987, 879, 798), List.of(798, 879, 987)),
            Arguments.of(List.of(-1234, -4321, 1234, 4321), List.of(-1234, 1234, -4321, 4321)),
            Arguments.of(List.of(555, 666, 777), List.of(555, 666, 777)),
            Arguments.of(List.of(-9, -8, -7, -6), List.of(-6, -7, -8, -9)),
            Arguments.of(List.of(100, 200, 300), List.of(100, 200, 300)),
            Arguments.of(List.of(5, -5, 10, -10), List.of(5, -5, 10, -10)),
            Arguments.of(List.of(111, -111, 222, -222), List.of(111, -111, 222, -222))
        );
    }

    // Parameterized test method
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testOrdering(List<Integer> input, List<Integer> expected) {
        assertEquals(OriginalImpl.orderByPoints(new ArrayList<>(input)), TransformedImpl.sortNumbersByDigitSum(new ArrayList<>(input)));
    }
}