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
    public static double[] tri(int n) {
        if (n == 0) {
            return new double[]{1};
        }
        double[] myTri = new double[n + 1];
        myTri[0] = 1;
        myTri[1] = 3;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                myTri[i] = i / 2.0 + 1;
            } else {
                myTri[i] = myTri[i - 1] + myTri[i - 2] + (i + 3) / 2.0;
            }
        }
        return myTri;
    }

    // Transformed Code
    public static List<Double> generateCustomSequence(int n) {
        if (n == 0) {
            List<Double> result = new ArrayList<>();
            result.add(1.0);
            return result;
        }
        
        List<Double> myTri = new ArrayList<>();
        myTri.add(1.0);
        myTri.add(3.0);
        int i = 2;
        
        while (i <= n) {
            if (i % 2 == 0) {
                myTri.add(i / 2.0 + 1);
            } else {
                myTri.add(myTri.get(i - 1) + myTri.get(i - 2) + (i + 3) / 2.0);
            }
            i++;
        }
        
        return myTri;
    }

    // Test Cases
    private static final int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void test_0() {
        assertEquals(java.util.Arrays.toString(tri(testCases[0])), generateCustomSequence(testCases[0]).toString());
    }

    @Test
    public void test_1() {
        assertEquals(java.util.Arrays.toString(tri(testCases[1])), generateCustomSequence(testCases[1]).toString());
    }

    @Test
    public void test_2() {
        assertEquals(java.util.Arrays.toString(tri(testCases[2])), generateCustomSequence(testCases[2]).toString());
    }

    @Test
    public void test_3() {
        assertEquals(java.util.Arrays.toString(tri(testCases[3])), generateCustomSequence(testCases[3]).toString());
    }

    @Test
    public void test_4() {
        assertEquals(java.util.Arrays.toString(tri(testCases[4])), generateCustomSequence(testCases[4]).toString());
    }

    @Test
    public void test_5() {
        assertEquals(java.util.Arrays.toString(tri(testCases[5])), generateCustomSequence(testCases[5]).toString());
    }

    @Test
    public void test_6() {
        assertEquals(java.util.Arrays.toString(tri(testCases[6])), generateCustomSequence(testCases[6]).toString());
    }

    @Test
    public void test_7() {
        assertEquals(java.util.Arrays.toString(tri(testCases[7])), generateCustomSequence(testCases[7]).toString());
    }

    @Test
    public void test_8() {
        assertEquals(java.util.Arrays.toString(tri(testCases[8])), generateCustomSequence(testCases[8]).toString());
    }

    @Test
    public void test_9() {
        assertEquals(java.util.Arrays.toString(tri(testCases[9])), generateCustomSequence(testCases[9]).toString());
    }
}