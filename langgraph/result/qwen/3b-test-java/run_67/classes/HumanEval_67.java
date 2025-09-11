import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_67 {

    // Source Code
    public static int fruitDistribution(String s, int n) {
        String[] words = s.split(" ");
        int sum = 0;
        for (String word : words) {
            if (word.matches("\\d+")) {
                sum += Integer.parseInt(word);
            }
        }
        return n - sum;
    }

    // Transformed Code
    public static int calculateRemainingFruits(String fruitString, int totalFruits) {
        List<Integer> numbers = new ArrayList<>();
        String[] items = fruitString.split(" ");
        for (String item : items) {
            if (item.matches("\\d+")) {
                numbers.add(Integer.parseInt(item));
            }
        }
        int remainingFruits = totalFruits - numbers.stream().mapToInt(Integer::intValue).sum();
        return remainingFruits;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {"1 2 3", 10},
        {"5 5 5", 20},
        {"", 10},
        {"10 20 30", 100},
        {"100", 150},
        {"1 2 3 4 5", 20},
        {"7 8 9", 30},
        {"0 0 0", 5},
        {"123", 200},
        {"456 789", 1500}
    };

    @Test
    public void test_0() {
        assertEquals(fruitDistribution((String) testCases[0][0], (int) testCases[0][1]), 
                     calculateRemainingFruits((String) testCases[0][0], (int) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(fruitDistribution((String) testCases[1][0], (int) testCases[1][1]), 
                     calculateRemainingFruits((String) testCases[1][0], (int) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(fruitDistribution((String) testCases[2][0], (int) testCases[2][1]), 
                     calculateRemainingFruits((String) testCases[2][0], (int) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(fruitDistribution((String) testCases[3][0], (int) testCases[3][1]), 
                     calculateRemainingFruits((String) testCases[3][0], (int) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(fruitDistribution((String) testCases[4][0], (int) testCases[4][1]), 
                     calculateRemainingFruits((String) testCases[4][0], (int) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(fruitDistribution((String) testCases[5][0], (int) testCases[5][1]), 
                     calculateRemainingFruits((String) testCases[5][0], (int) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(fruitDistribution((String) testCases[6][0], (int) testCases[6][1]), 
                     calculateRemainingFruits((String) testCases[6][0], (int) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(fruitDistribution((String) testCases[7][0], (int) testCases[7][1]), 
                     calculateRemainingFruits((String) testCases[7][0], (int) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(fruitDistribution((String) testCases[8][0], (int) testCases[8][1]), 
                     calculateRemainingFruits((String) testCases[8][0], (int) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(fruitDistribution((String) testCases[9][0], (int) testCases[9][1]), 
                     calculateRemainingFruits((String) testCases[9][0], (int) testCases[9][1]));
    }
}