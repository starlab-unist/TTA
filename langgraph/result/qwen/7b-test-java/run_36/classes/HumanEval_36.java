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

public class HumanEval_36 {

    // Source Code
    static class HumanEval_36_Source {
        public static int fizzBuzz(int n) {
            List<Integer> ns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i % 11 == 0 || i % 13 == 0) {
                    ns.add(i);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Integer num : ns) {
                sb.append(num.toString());
            }
            String s = sb.toString();
            int ans = 0;
            for (char c : s.toCharArray()) {
                if (c == '7') {
                    ans++;
                }
            }
            return ans;
        }
    }

    // Transformed Code
    static class HumanEval_36_Transformed {
        public static int countSevensInSpecialNumbers(int limit) {
            List<Integer> specialNumbers = new ArrayList<>();
            int index = 0;
            while (index < limit) {
                if (index % 11 == 0 || index % 13 == 0) {
                    specialNumbers.add(index);
                }
                index++;
            }

            StringBuilder concatenatedString = new StringBuilder();
            for (int number : specialNumbers) {
                concatenatedString.append(number);
            }

            int sevenCount = 0;
            int position = 0;
            while (position < concatenatedString.length()) {
                if (concatenatedString.charAt(position) == '7') {
                    sevenCount++;
                }
                position++;
            }

            return sevenCount;
        }
    }

    // Test Cases
    private static final Object[] testCases = {
        0,
        1,
        25,
        50,
        75,
        100,
        125,
        150,
        200,
        300
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[0]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[1]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[2]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[3]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[4]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[5]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[6]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[7]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[8]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_36_Source.fizzBuzz((int) testCases[9]), 
                     HumanEval_36_Transformed.countSevensInSpecialNumbers((int) testCases[9]));
    }
}