import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_81 {

    // Source Code
    static class HumanEval_81_Source {
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

    // Transformed Code
    static class HumanEval_81_Transformed {
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
    }

    // Test Cases
    private static final Double[][] testCases = {
        {4.0},
        {3.8},
        {3.5},
        {3.2},
        {2.9},
        {2.5},
        {2.1},
        {1.8},
        {1.4},
        {1.1},
        {0.8},
        {0.3},
        {0.0}
    };

    private static final String[][] expectedResults = {
        {"A+"},
        {"A"},
        {"A-"},
        {"B+"},
        {"B"},
        {"B-"},
        {"C+"},
        {"C"},
        {"C-"},
        {"D+"},
        {"D"},
        {"D-"},
        {"D-"}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[0])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[0])));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[1])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[1])));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[2])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[2])));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[3])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[3])));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[4])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[4])));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[5])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[5])));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[6])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[6])));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[7])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[7])));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[8])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[8])));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[9])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[9])));
    }

    @Test
    public void test_10() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[10])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[10])));
    }

    @Test
    public void test_11() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[11])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[11])));
    }

    @Test
    public void test_12() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade(List.of(testCases[12])), 
                     new HumanEval_81_Transformed().convertGpasToLetters(List.of(testCases[12])));
    }
}