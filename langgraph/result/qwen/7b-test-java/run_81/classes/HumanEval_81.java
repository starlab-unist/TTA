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
    public static List<String> convertGpasToLetters(List<Double> grades) {
        List<double[]> gradeMapping = new ArrayList<>();
        gradeMapping.add(new double[]{4.0, 'A'});
        gradeMapping.add(new double[]{3.7, 'A'});
        gradeMapping.add(new double[]{3.3, 'A'});
        gradeMapping.add(new double[]{3.0, 'B'});
        gradeMapping.add(new double[]{2.7, 'B'});
        gradeMapping.add(new double[]{2.3, 'B'});
        gradeMapping.add(new double[]{2.0, 'C'});
        gradeMapping.add(new double[]{1.7, 'C'});
        gradeMapping.add(new double[]{1.3, 'C'});
        gradeMapping.add(new double[]{1.0, 'D'});
        gradeMapping.add(new double[]{0.7, 'D'});
        gradeMapping.add(new double[]{0.0, 'D'});
        gradeMapping.add(new double[]{-1.0, 'E'});

        List<String> letterGrades = new ArrayList<>();
        int index = 0;
        for (Double gpa : grades) {
            while (gpa <= gradeMapping.get(index)[0]) {
                index++;
            }
            letterGrades.add(String.valueOf((char) gradeMapping.get(index - 1)[1]));
            index = 0;
        }

        return letterGrades;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of(4.0), List.of("A+")},
        {List.of(3.8), List.of("A")},
        {List.of(3.5), List.of("A-")},
        {List.of(3.2), List.of("B+")},
        {List.of(2.9), List.of("B")},
        {List.of(2.5), List.of("B-")},
        {List.of(2.1), List.of("C+")},
        {List.of(1.8), List.of("C")},
        {List.of(1.4), List.of("C-")},
        {List.of(1.1), List.of("D+")},
        {List.of(0.8), List.of("D")},
        {List.of(0.3), List.of("D-")},
        {List.of(0.0), List.of("D-")},
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[0][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[1][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[2][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[3][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[4][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[5][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[6][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[7][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[8][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[9][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[9][0]));
    }

    @Test
    public void test_10() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[10][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[10][0]));
    }

    @Test
    public void test_11() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[11][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[11][0]));
    }

    @Test
    public void test_12() {
        assertEquals(new HumanEval_81().numericalLetterGrade((List<Double>) testCases[12][0]), 
                     HumanEval_81.convertGpasToLetters((List<Double>) testCases[12][0]));
    }
}