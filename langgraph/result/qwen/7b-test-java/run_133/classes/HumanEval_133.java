import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

public class HumanEval_133 {

    // Source Code
    static class OriginalImpl {
        public static int sumSquares(List<Double> lst) {
            int squared = 0;
            for (Double i : lst) {
                BigDecimal ceilValue = new BigDecimal(Math.ceil(i)).setScale(0, BigDecimal.ROUND_HALF_UP);
                squared += ceilValue.intValue() * ceilValue.intValue();
            }
            return squared;
        }
    }

    // Transformed Code
    static class TransformedImpl {
        public static int sumSquares(Iterator<Double> lst) {
            int squared = 0;
            while (lst.hasNext()) {
                double number = lst.next();
                squared += Math.ceil(number) * Math.ceil(number);
            }
            return squared;
        }
    }

    // Test Cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(1.0, 2.0, 3.0)),
            Arguments.of(Arrays.asList(-1.5, 2.3, -3.7)),
            Arguments.of(Arrays.asList(0.0, 0.0, 0.0)),
            Arguments.of(Arrays.asList(4.9, 5.1, 6.5)),
            Arguments.of(Arrays.asList(10.0, -10.0, 20.0)),
            Arguments.of(Arrays.asList(1.1, 1.9, 2.5)),
            Arguments.of(Arrays.asList(-1.0, -2.0, -3.0)),
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(0.99, 1.01, 2.99)),
            Arguments.of(Arrays.asList(5.0))
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testSumSquares(List<Double> testCase) {
        assertEquals(OriginalImpl.sumSquares(testCase), 
                     TransformedImpl.sumSquares(testCase.iterator()));
    }
}