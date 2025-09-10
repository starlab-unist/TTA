import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream; // Added import statement

public class HumanEval_81 {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void numericalLetterGrade_vs_convertGpasToLetters(List<Double> inputGrades, List<String> expectedOutput) {
        assertEquals(
            SourceCode.numericalLetterGrade(inputGrades),
            TransformedCode.convertGpasToLetters(inputGrades)
        );
    }

    private static Stream<Arguments> provideTestCases() {
        return Arrays.asList(
            Arguments.of(Arrays.asList(4.0), Arrays.asList("A+")),
            Arguments.of(Arrays.asList(3.8), Arrays.asList("A")),
            Arguments.of(Arrays.asList(3.5), Arrays.asList("A-")),
            Arguments.of(Arrays.asList(3.2), Arrays.asList("B+")),
            Arguments.of(Arrays.asList(2.9), Arrays.asList("B")),
            Arguments.of(Arrays.asList(2.5), Arrays.asList("B-")),
            Arguments.of(Arrays.asList(2.1), Arrays.asList("C+")),
            Arguments.of(Arrays.asList(1.8), Arrays.asList("C")),
            Arguments.of(Arrays.asList(1.4), Arrays.asList("C-")),
            Arguments.of(Arrays.asList(0.5), Arrays.asList("D-")),
            Arguments.of(Arrays.asList(0.0), Arrays.asList("E")),
            Arguments.of(Arrays.asList(-0.5), Arrays.asList("E")), // Test for negative GPA
            Arguments.of(Arrays.asList(3.7, 2.9, 1.4), Arrays.asList("A", "B", "C-")), // Multiple GPAs
            Arguments.of(Arrays.asList(4.0, 0.0, 1.8, 2.5), Arrays.asList("A+", "E", "C", "B-")) // Mixed GPAs
        ).stream();
    }
}