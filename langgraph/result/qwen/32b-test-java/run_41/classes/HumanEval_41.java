import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_41 {

    // Source Code
    static class SourceCode {
        public int carRaceCollision(int n) {
            return n * n;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateImpactForce(int vehicleCount) {
            int impact = vehicleCount * vehicleCount;
            return impact;
        }
    }

    // Test Cases
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 10, 15, 20, 25})
    public void carRaceCollision_vs_calculateImpactForce(int input) {
        assertEquals(
            SourceCode.carRaceCollision(input),
            TransformedCode.calculateImpactForce(input)
        );
    }
}