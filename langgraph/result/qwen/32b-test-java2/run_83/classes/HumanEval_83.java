// equiv_test_0.java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays; // Added import for Arrays
import java.util.stream.Stream; // Added import for Stream

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_83 {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Compare startsOneEnds and calculateSpecialNumber with various inputs")
    void startsOneEnds_vs_calculateSpecialNumber(int input) {
        HumanEval_83_Source sourceInstance = new HumanEval_83_Source(); // Create instance of source class
        HumanEval_83_Transformed transformedInstance = new HumanEval_83_Transformed(); // Create instance of transformed class

        assertEquals(
            sourceInstance.startsOneEnds(input), // Call method through instance
            transformedInstance.calculateSpecialNumber(input) // Call method through instance
        );
    }

    private static final Integer[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }
}