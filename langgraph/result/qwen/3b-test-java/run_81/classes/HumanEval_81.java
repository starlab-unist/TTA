import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class HumanEval_81 {

    // Source Code
    static class HumanEval_81_Source {
        public static List<String> numericalLetterGrade(List<Double> grades) {
            List<String> letterGrade = new ArrayList<>();
            for (Double gpa : grades) {
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
        public static String[] convertGpasToLetters(double[] gpas) {
            String[] gradeMapping = {
                "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"
            };

            String[] letterGrades = new String[gpas.length];
            int index = 0;

            while (index < gpas.length) {
                double gpa = gpas[index];
                int i = 0;
                while (i < gradeMapping.length - 1 && gpa > getThreshold(i)) {
                    i++;
                }
                letterGrades[index] = gradeMapping[i];
                index++;
            }

            return letterGrades;
        }

        private static double getThreshold(int index) {
            switch (index) {
                case 0: return 3.7;
                case 1: return 3.3;
                case 2: return 3.0;
                case 3: return 2.7;
                case 4: return 2.3;
                case 5: return 2.0;
                case 6: return 1.7;
                case 7: return 1.3;
                case 8: return 1.0;
                case 9: return 0.7;
                case 10: return 0.0;
                default: return -1.0; // This should never be reached
            }
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(4.0), new String[]{"A+"}},
        {List.of(3.8), new String[]{"A"}},
        {List.of(3.5), new String[]{"A-"}},
        {List.of(3.2), new String[]{"B+"}},
        {List.of(2.9), new String[]{"B"}},
        {List.of(2.5), new String[]{"B-"}},
        {List.of(2.1), new String[]{"C+"}},
        {List.of(1.8), new String[]{"C"}},
        {List.of(1.4), new String[]{"C-"}},
        {List.of(1.1), new String[]{"D+"}},
        {List.of(0.8), new String[]{"D"}},
        {List.of(0.3), new String[]{"D-"}},
        {List.of(0.0), new String[]{"E"}}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[0][0]), 
                     List.of(((String[]) testCases[0][1])));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[1][0]), 
                     List.of(((String[]) testCases[1][1])));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[2][0]), 
                     List.of(((String[]) testCases[2][1])));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[3][0]), 
                     List.of(((String[]) testCases[3][1])));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[4][0]), 
                     List.of(((String[]) testCases[4][1])));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[5][0]), 
                     List.of(((String[]) testCases[5][1])));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[6][0]), 
                     List.of(((String[]) testCases[6][1])));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[7][0]), 
                     List.of(((String[]) testCases[7][1])));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[8][0]), 
                     List.of(((String[]) testCases[8][1])));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[9][0]), 
                     List.of(((String[]) testCases[9][1])));
    }

    @Test
    public void test_10() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[10][0]), 
                     List.of(((String[]) testCases[10][1])));
    }

    @Test
    public void test_11() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[11][0]), 
                     List.of(((String[]) testCases[11][1])));
    }

    @Test
    public void test_12() {
        assertEquals(HumanEval_81_Source.numericalLetterGrade((List<Double>) testCases[12][0]), 
                     List.of(((String[]) testCases[12][1])));
    }
}