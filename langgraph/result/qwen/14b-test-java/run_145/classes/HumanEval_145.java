import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_145 {

    // Source Code
    public static int[] orderByPoints(int[] nums) {
        Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsObj, Comparator.comparingInt(HumanEval_145::digitsSum));
        return Arrays.stream(numsObj).mapToInt(Integer::intValue).toArray();
    }

    private static int digitsSum(int n) {
        int neg = 1;
        if (n < 0) {
            n = -1 * n;
            neg = -1;
        }
        String numStr = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            if (i == 0) {
                digit *= neg;
            }
            sum += digit;
        }
        return sum;
    }

    // Transformed Code
    public static List<Integer> sortNumbersByDigitSum(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.comparingInt(HumanEval_145::calculateWeight))
                .collect(Collectors.toList());
    }

    private static int calculateWeight(int number) {
        int sign = Integer.signum(number);
        int absoluteValue = Math.abs(number);
        List<Integer> digits = new ArrayList<>();
        
        while (absoluteValue > 0) {
            digits.add(absoluteValue % 10);
            absoluteValue /= 10;
        }
        
        if (!digits.isEmpty()) {
            digits.set(0, digits.get(0) * sign);
        }
        
        return digits.stream().mapToInt(Integer::intValue).sum();
    }

    // Nested classes for wrapping implementations
    public static class OriginalImpl {
        public static int[] orderByPoints(int[] nums) {
            Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            Arrays.sort(numsObj, Comparator.comparingInt(OriginalImpl::digitsSum));
            return Arrays.stream(numsObj).mapToInt(Integer::intValue).toArray();
        }

        private static int digitsSum(int n) {
            int neg = 1;
            if (n < 0) {
                n = -1 * n;
                neg = -1;
            }
            String numStr = Integer.toString(n);
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                int digit = Character.getNumericValue(numStr.charAt(i));
                if (i == 0) {
                    digit *= neg;
                }
                sum += digit;
            }
            return sum;
        }
    }

    public static class TransformedImpl {
        public static List<Integer> sortNumbersByDigitSum(List<Integer> numbers) {
            return numbers.stream()
                    .sorted(Comparator.comparingInt(TransformedImpl::calculateWeight))
                    .collect(Collectors.toList());
        }

        private static int calculateWeight(int number) {
            int sign = Integer.signum(number);
            int absoluteValue = Math.abs(number);
            List<Integer> digits = new ArrayList<>();
            
            while (absoluteValue > 0) {
                digits.add(absoluteValue % 10);
                absoluteValue /= 10;
            }
            
            if (!digits.isEmpty()) {
                digits.set(0, digits.get(0) * sign);
            }
            
            return digits.stream().mapToInt(Integer::intValue).sum();
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{123, 321, 213}, new int[]{123, 213, 321}),
            Arguments.of(new int[]{-12, -21, 12, 21}, new int[]{-12, 12, -21, 21}),
            Arguments.of(new int[]{0, 5, 10, 15}, new int[]{0, 5, 10, 15}),
            Arguments.of(new int[]{987, 879, 798}, new int[]{798, 879, 987}),
            Arguments.of(new int[]{-1234, -4321, 1234, 4321}, new int[]{-1234, 1234, -4321, 4321}),
            Arguments.of(new int[]{555, 666, 777}, new int[]{555, 666, 777}),
            Arguments.of(new int[]{-9, -8, -7, -6}, new int[]{-6, -7, -8, -9}),
            Arguments.of(new int[]{100, 200, 300}, new int[]{100, 200, 300}),
            Arguments.of(new int[]{5, -5, 10, -10}, new int[]{5, -5, 10, -10}),
            Arguments.of(new int[]{111, -111, 222, -222}, new int[]{111, -111, 222, -222})
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void test(int[] input, int[] expected) {
        List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
        List<Integer> expectedList = Arrays.stream(expected).boxed().collect(Collectors.toList());

        int[] originalResult = OriginalImpl.orderByPoints(input);
        List<Integer> transformedResult = TransformedImpl.sortNumbersByDigitSum(inputList);

        assertEquals(Arrays.toString(originalResult), 
                     transformedResult.stream().mapToInt(i -> i).toArray());
    }
}