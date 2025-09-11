import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_36 {

    // Source Code
    public static int fizzBuzz(int n) {
        StringBuilder ns = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 11 == 0 || i % 13 == 0) {
                ns.append(i);
            }
        }
        String s = ns.toString();
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += (c == '7') ? 1 : 0;
        }
        return ans;
    }

    // Transformed Code
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

    // Test Cases
    private static final int[] testCases = {
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
        assertEquals(fizzBuzz(testCases[0]), countSevensInSpecialNumbers(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(fizzBuzz(testCases[1]), countSevensInSpecialNumbers(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(fizzBuzz(testCases[2]), countSevensInSpecialNumbers(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(fizzBuzz(testCases[3]), countSevensInSpecialNumbers(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(fizzBuzz(testCases[4]), countSevensInSpecialNumbers(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(fizzBuzz(testCases[5]), countSevensInSpecialNumbers(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(fizzBuzz(testCases[6]), countSevensInSpecialNumbers(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(fizzBuzz(testCases[7]), countSevensInSpecialNumbers(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(fizzBuzz(testCases[8]), countSevensInSpecialNumbers(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(fizzBuzz(testCases[9]), countSevensInSpecialNumbers(testCases[9]));
    }
}