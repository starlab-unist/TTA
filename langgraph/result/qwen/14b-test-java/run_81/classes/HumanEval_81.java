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
    public static List<String> numericalLetterGrade(List<Double> grades) {
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
    public static List<String> convertGpasToLetters(List<Double> gpas) {
        List<double[]> gradeMapping = new ArrayList<>();
        gradeMapping.add(new double[]{4.0, 0});
        gradeMapping.add(new double[]{3.7, 1});
        gradeMapping.add(new double[]{3.3, 2});
        gradeMapping.add(new double[]{3.0, 3});
        gradeMapping.add(new double[]{2.7, 4});
        gradeMapping.add(new double[]{2.3, 5});
        gradeMapping.add(new double[]{2.0, 6});
        gradeMapping.add(new double[]{1.7, 7});
        gradeMapping.add(new double[]{1.3, 8});
        gradeMapping.add(new double[]{1.0, 9});
        gradeMapping.add(new double[]{0.7, 10});
        gradeMapping.add(new double[]{0.0, 11});
        gradeMapping.add(new double[]{-1.0, 12}); // Added -1.0 to handle the else case

        String[] letterGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"};
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < gpas.size()) {
            double gpa = gpas.get(index);
            while (gpa <= gradeMapping.get(index)[0]) {
                index++;
            }
            result.add(letterGrades[(int) gradeMapping.get(index - 1)[1]]);
            index++;
        }

        return result;
    }

    // Test Cases
    @Test
    public void test_0() {
        assertEquals(numericalLetterGrade(List.of(4.0)), convertGpasToLetters(List.of(4.0)));
    }

    @Test
    public void test_1() {
        assertEquals(numericalLetterGrade(List.of(3.8)), convertGpasToLetters(List.of(3.8)));
    }

    @Test
    public void test_2() {
        assertEquals(numericalLetterGrade(List.of(3.5)), convertGpasToLetters(List.of(3.5)));
    }

    @Test
    public void test_3() {
        assertEquals(numericalLetterGrade(List.of(3.2)), convertGpasToLetters(List.of(3.2)));
    }

    @Test
    public void test_4() {
        assertEquals(numericalLetterGrade(List.of(2.9)), convertGpasToLetters(List.of(2.9)));
    }

    @Test
    public void test_5() {
        assertEquals(numericalLetterGrade(List.of(2.5)), convertGpasToLetters(List.of(2.5)));
    }

    @Test
    public void test_6() {
        assertEquals(numericalLetterGrade(List.of(2.1)), convertGpasToLetters(List.of(2.1)));
    }

    @Test
    public void test_7() {
        assertEquals(numericalLetterGrade(List.of(1.8)), convertGpasToLetters(List.of(1.8)));
    }

    @Test
    public void test_8() {
        assertEquals(numericalLetterGrade(List.of(1.4)), convertGpasToLetters(List.of(1.4)));
    }

    @Test
    public void test_9() {
        assertEquals(numericalLetterGrade(List.of(1.1)), convertGpasToLetters(List.of(1.1)));
    }

    @Test
    public void test_10() {
        assertEquals(numericalLetterGrade(List.of(0.8)), convertGpasToLetters(List.of(0.8)));
    }

    @Test
    public void test_11() {
        assertEquals(numericalLetterGrade(List.of(0.3)), convertGpasToLetters(List.of(0.3)));
    }

    @Test
    public void test_12() {
        assertEquals(numericalLetterGrade(List.of(0.0)), convertGpasToLetters(List.of(0.0)));
    }
}