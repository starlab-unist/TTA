import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_130 {

    // Source Code
    static class SourceCode {
        public List<Double> tri(int n) {
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
    }

    // Transformed Code
    static class TransformedCode {
        public List<Double> generateCustomSequence(int length) {
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
                    sequence.add((double) index / 2 + 1);
                } else {
                    sequence.add(sequence.get(index - 1) + sequence.get(index - 2) + (index + 3) / 2.0);
                }
                index++;
            }
            
            return sequence;
        }
    }

    // Test Cases
    private static final int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void test_0() {
        assertEquals(SourceCode.tri(testCases[0]), TransformedCode.generateCustomSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.tri(testCases[1]), TransformedCode.generateCustomSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.tri(testCases[2]), TransformedCode.generateCustomSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.tri(testCases[3]), TransformedCode.generateCustomSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.tri(testCases[4]), TransformedCode.generateCustomSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.tri(testCases[5]), TransformedCode.generateCustomSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.tri(testCases[6]), TransformedCode.generateCustomSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.tri(testCases[7]), TransformedCode.generateCustomSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.tri(testCases[8]), TransformedCode.generateCustomSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.tri(testCases[9]), TransformedCode.generateCustomSequence(testCases[9]));
    }
}