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

public class HumanEval_106 {

    // Source Code
    public List<Integer> f(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                int x = 1;
                for (int j = 1; j <= i; j++) x *= j;
                ret.add(x);
            } else {
                int x = 0;
                for (int j = 1; j <= i; j++) x += j;
                ret.add(x);
            }
        }
        return ret;
    }

    // Transformed Code
    public static List<Integer> generateAlternatingSequence(int limit) {
        List<Integer> result = new ArrayList<>();
        int index = 1;
        while (index <= limit) {
            if (index % 2 == 0) {
                int factorial = 1;
                int innerIndex = 1;
                while (innerIndex <= index) {
                    factorial *= innerIndex;
                    innerIndex++;
                }
                result.add(factorial);
            } else {
                int summation = 0;
                int innerIndex = 1;
                while (innerIndex <= index) {
                    summation += innerIndex;
                    innerIndex++;
                }
                result.add(summation);
            }
            index++;
        }
        return result;
    }

    // Test Cases
    private static final Object[] testCases = {
        0,  // Edge case: no elements
        1,  // Only one element, odd
        2,  // Two elements, odd then even
        3,  // Three elements, odd, even, odd
        4,  // Four elements, odd, even, odd, even
        5,  // Five elements, odd, even, odd, even, odd
        10, // Ten elements
        20, // Twenty elements
        30, // Thirty elements
        50  // Fifty elements
    };

    @Test
    public void test_0() {
        assertEquals(new HumanEval_106().f((int) testCases[0]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_106().f((int) testCases[1]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_106().f((int) testCases[2]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_106().f((int) testCases[3]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_106().f((int) testCases[4]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_106().f((int) testCases[5]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_106().f((int) testCases[6]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_106().f((int) testCases[7]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_106().f((int) testCases[8]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_106().f((int) testCases[9]), 
                     HumanEval_106.generateAlternatingSequence((int) testCases[9]));
    }
}