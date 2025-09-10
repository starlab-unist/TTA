// Import statements for Stream and Arrays
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_41 {

    // Source Code
    static class SourceCode {
        public static int carRaceCollision(int n) {
            return n * n;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static int calculateImpactForce(int vehicleCount) {
            int impact = vehicleCount * vehicleCount;
            return impact;
        }
    }

    // Test Cases
    private static final Integer[] testCases = {
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest(name = "Test case {index}: n={0}")
    @MethodSource("provideTestCases")
    public void carRaceCollision_vs_calculateImpactForce(int input) {
        assertEquals(
            SourceCode.carRaceCollision(input),
            TransformedCode.calculateImpactForce(input)
        );
    }
}