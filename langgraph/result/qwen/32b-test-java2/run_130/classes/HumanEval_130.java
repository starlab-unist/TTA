import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList; // Added import for ArrayList
import java.util.List;

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
    @ParameterizedTest(name = "Input: {arguments}")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void tri_vs_generateCustomSequence(int input) {
        SourceCode sourceCodeInstance = new SourceCode(); // Create an instance of SourceCode
        TransformedCode transformedCodeInstance = new TransformedCode(); // Create an instance of TransformedCode
        
        assertEquals(
            sourceCodeInstance.tri(input), // Use the instance method on the created object
            transformedCodeInstance.generateCustomSequence(input) // Use the instance method on the created object
        );
    }
}