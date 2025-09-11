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
    static class HumanEval_130_Source {
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
    static class HumanEval_130_Transformed {
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
        assertEquals(new HumanEval_130_Source().tri(testCases[0]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(new HumanEval_130_Source().tri(testCases[1]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(new HumanEval_130_Source().tri(testCases[2]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(new HumanEval_130_Source().tri(testCases[3]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(new HumanEval_130_Source().tri(testCases[4]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(new HumanEval_130_Source().tri(testCases[5]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(new HumanEval_130_Source().tri(testCases[6]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(new HumanEval_130_Source().tri(testCases[7]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(new HumanEval_130_Source().tri(testCases[8]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(new HumanEval_130_Source().tri(testCases[9]), 
                     new HumanEval_130_Transformed().generateCustomSequence(testCases[9]));
    }
}