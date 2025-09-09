import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_81 {

    // Source Code
    public List<String> numericalLetterGrade(List<Double> grades) {
        List<String> letterGrade = new ArrayList<>();
        for (double gpa : grades) {
            if (gpa == 4.0) {
                letterGrade.add("A+");
            } else if (gpa > 3.7) {
                letterGrade.add("A");
            } else if (gpa > 3.3) {
                letterGrade.add("A-");
            } else if (gpa > 3.0) {
                letterGrade.add("B+");
            } else if (gpa > 2.7) {
                letterGrade.add("B");
            } else if (gpa > 2.3) {
                letterGrade.add("B-");
            } else if (gpa > 2.0) {
                letterGrade.add("C+");
            } else if (gpa > 1.7) {
                letterGrade.add("C");
            } else if (gpa > 1.3) {
                letterGrade.add("C-");
            } else if (gpa > 1.0) {
                letterGrade.add("D+");
            } else if (gpa > 0.7) {
                letterGrade.add("D");
            } else if (gpa > 0.0) {
                letterGrade.add("D-");
            } else {
                letterGrade.add("E");
            }
        }
        return letterGrade;
    }

    // Transformed Code
    public List<String> convertGpasToLetters(List<Double> gpas) {
        double[][] gradeMapping = {
            {4.0, "A+"},
            {3.7, "A"},
            {3.3, "A-"},
            {3.0, "B+"},
            {2.7, "B"},
            {2.3, "B-"},
            {2.0, "C+"},
            {1.7, "C"},
            {1.3, "C-"},
            {1.0, "D+"},
            {0.7, "D"},
            {0.0, "D-"},
            {-1.0, "E"}  // Added -1.0 to handle the else case
        };

        List<String> letterGrades = new ArrayList<>();
        int index = 0;
        while (index < gpas.size()) {
            double gpa = gpas.get(index);
            while (gpa <= gradeMapping[index][0]) {
                index++;
            }
            letterGrades.add(gradeMapping[index - 1][1]);
            index++;
        }

        return letterGrades;
    }

    // Test Cases
    private static final Arguments[] testCases = {
        Arguments.of(List.of(4.0), List.of("A+")),
        Arguments.of(List.of(3.8), List.of("A")),
        Arguments.of(List.of(3.5), List.of("A-")),
        Arguments.of(List.of(3.2), List.of("B+")),
        Arguments.of(List.of(2.9), List.of("B")),
        Arguments.of(List.of(2.5), List.of("B-")),
        Arguments.of(List.of(2.1), List.of("C+")),
        Arguments.of(List.of(1.8), List.of("C")),
        Arguments.of(List.of(1.4), List.of("C-")),
        Arguments.of(List.of(1.1), List.of("D+")),
        Arguments.of(List.of(0.8), List.of("D")),
        Arguments.of(List.of(0.3), List.of("D-")),
        Arguments.of(List.of(0.0), List.of("E"))
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases);
    }

    @DisplayName("Test numericalLetterGrade vs convertGpasToLetters")
    @ParameterizedTest(name = "{index} => input={0}, expected={1}")
    @MethodSource("provideTestCases")
    void numericalLetterGrade_vs_convertGpasToLetters(List<Double> input, List<String> expected) {
        assertEquals(
            numericalLetterGrade(input),
            convertGpasToLetters(input)
        );
    }
}