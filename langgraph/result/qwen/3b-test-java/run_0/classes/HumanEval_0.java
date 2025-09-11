import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_0 {

    // Source Code
    public static boolean hasCloseElements(List<Float> numbers, float threshold) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {
                    float distance = Math.abs(numbers.get(i) - numbers.get(j));
                    if (distance < threshold) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Transformed Code
    public static boolean containsNearbyElements(List<Double> values, double limit) {
        int index = 0;
        while (index < values.size()) {
            int innerIndex = 0;
            while (innerIndex < values.size()) {
                if (index != innerIndex) {
                    double gap = Math.abs(values.get(index) - values.get(innerIndex));
                    if (gap < limit) {
                        return true;
                    }
                }
                innerIndex++;
            }
            index++;
        }

        return false;
    }

    // Test Cases
    static class OriginalImpl {
        public static boolean hasCloseElements(List<Float> numbers, float threshold) {
            return HumanEval_0.hasCloseElements(numbers, threshold);
        }
    }

    static class TransformedImpl {
        public static boolean containsNearbyElements(List<Double> values, double limit) {
            return HumanEval_0.containsNearbyElements(values, limit);
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(List.of(1.0f, 2.0f, 3.0f), 0.5f, false),
            Arguments.of(List.of(1.0f, 2.0f, 3.0f), 1.5f, true),
            Arguments.of(List.of(1.1f, 2.2f, 3.3f), 0.1f, false),
            Arguments.of(List.of(1.1f, 2.2f, 3.3f), 1.2f, true),
            Arguments.of(List.of(0.0f, 0.0f, 0.0f), 0.0f, true),
            Arguments.of(List.of(0.0f, 0.1f, 0.2f), 0.05f, false),
            Arguments.of(List.of(5.0f, 4.9f, 4.8f), 0.2f, true),
            Arguments.of(List.of(10.0f, 20.0f, 30.0f), 5.0f, false),
            Arguments.of(List.of(1.0f, 1.0f, 1.0f, 1.0f), 0.1f, true),
            Arguments.of(List.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), 1.1f, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testHasCloseElements(List<Float> numbers, float threshold, boolean expected) {
        List<Double> doubleValues = numbers.stream().map(Float::doubleValue).toList();
        assertEquals(
            OriginalImpl.hasCloseElements(numbers, threshold), 
            TransformedImpl.containsNearbyElements(doubleValues, (double) threshold)
        );
    }
}