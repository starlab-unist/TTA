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

public class HumanEval_130 {

    // Source Code
    public static List<Double> tri(int n) {
        if (n == 0) {
            List<Double> result = new ArrayList<>();
            result.add(1.0);
            return result;
        }
        
        List<Double> myTri = new ArrayList<>();
        myTri.add(1.0);
        myTri.add(3.0);
        
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                myTri.add((double) i / 2 + 1);
            } else {
                myTri.add(myTri.get(i - 1) + myTri.get(i - 2) + (double) (i + 3) / 2);
            }
        }
        
        return myTri;
    }

    // Transformed Code
    public static List<Double> generate_custom_sequence(int length) {
        if (length == 0) {
            List<Double> sequence = new ArrayList<>();
            sequence.add(1.0);
            return sequence;
        }
        
        List<Double> sequence = new ArrayList<>();
        sequence.add(1.0);
        sequence.add(3.0);
        int index = 2;
        
        while (index <= length) {
            if (index % 2 == 0) {
                sequence.add(index / 2.0 + 1.0);
            } else {
                sequence.add(sequence.get(index - 1) + sequence.get(index - 2) + (index + 3) / 2.0);
            }
            index++;
        }
        
        return sequence;
    }

    // Test Cases
    private static final int[] testCases = {
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9
    };

    @Test
    public void test_0() {
        assertEquals(tri(testCases[0]), generate_custom_sequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(tri(testCases[1]), generate_custom_sequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(tri(testCases[2]), generate_custom_sequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(tri(testCases[3]), generate_custom_sequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(tri(testCases[4]), generate_custom_sequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(tri(testCases[5]), generate_custom_sequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(tri(testCases[6]), generate_custom_sequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(tri(testCases[7]), generate_custom_sequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(tri(testCases[8]), generate_custom_sequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(tri(testCases[9]), generate_custom_sequence(testCases[9]));
    }
}