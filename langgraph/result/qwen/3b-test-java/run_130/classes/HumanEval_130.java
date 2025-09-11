import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
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
    public static List<Double> generateCustomSequence(int length) {
        if (length == 0) {
            return Arrays.asList(1.0);
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
    private static final int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void test_0() {
        assertArrayEquals(tri(testCases[0]), generateCustomSequence(testCases[0]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_1() {
        assertArrayEquals(tri(testCases[1]), generateCustomSequence(testCases[1]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_2() {
        assertArrayEquals(tri(testCases[2]), generateCustomSequence(testCases[2]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_3() {
        assertArrayEquals(tri(testCases[3]), generateCustomSequence(testCases[3]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_4() {
        assertArrayEquals(tri(testCases[4]), generateCustomSequence(testCases[4]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_5() {
        assertArrayEquals(tri(testCases[5]), generateCustomSequence(testCases[5]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_6() {
        assertArrayEquals(tri(testCases[6]), generateCustomSequence(testCases[6]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_7() {
        assertArrayEquals(tri(testCases[7]), generateCustomSequence(testCases[7]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_8() {
        assertArrayEquals(tri(testCases[8]), generateCustomSequence(testCases[8]).stream().mapToDouble(Double::doubleValue).toArray());
    }

    @Test
    public void test_9() {
        assertArrayEquals(tri(testCases[9]), generateCustomSequence(testCases[9]).stream().mapToDouble(Double::doubleValue).toArray());
    }
}