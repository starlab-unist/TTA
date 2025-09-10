import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SourceCode {
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
}

class TransformedCode {
    public List<String> convertGpasToLetters(List<Double> gpas) {
        Object[][] gradeMapping = {
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
            while ((Double) gradeMapping[index][0] <= gpa) {
                index++;
            }
            letterGrades.add((String) gradeMapping[index - 1][1]);
            index++;
        }

        return letterGrades;
    }
}

public class HumanEval_81 {

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of(Arrays.asList(4.0), Arrays.asList("A+"))},
        {Arguments.of(Arrays.asList(3.8), Arrays.asList("A"))},
        {Arguments.of(Arrays.asList(3.5), Arrays.asList("A-"))},
        {Arguments.of(Arrays.asList(3.2), Arrays.asList("B+"))},
        {Arguments.of(Arrays.asList(2.9), Arrays.asList("B"))},
        {Arguments.of(Arrays.asList(2.5), Arrays.asList("B-"))},
        {Arguments.of(Arrays.asList(2.1), Arrays.asList("C+"))},
        {Arguments.of(Arrays.asList(1.8), Arrays.asList("C"))},
        {Arguments.of(Arrays.asList(1.4), Arrays.asList("C-"))},
        {Arguments.of(Arrays.asList(1.1), Arrays.asList("D+"))}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void numericalLetterGrade_vs_convertGpasToLetters(List<Double> inputGrades, List<String> expectedOutput) {
        SourceCode source = new SourceCode();
        TransformedCode transformed = new TransformedCode();
        assertEquals(
            source.numericalLetterGrade(inputGrades),
            transformed.convertGpasToLetters(inputGrades)
        );
    }
}