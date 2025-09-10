import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_67 {

    @DisplayName("Testing equivalence of fruitDistribution and calculateRemainingFruits")
    @ParameterizedTest(name = "Input: {0}, {1}")
    @CsvSource({
        "1 2 3, 10",
        "5 5 5, 20",
        "", "10",
        "10 20 30, 100",
        "100, 150",
        "1 2 3 4 5, 20",
        "7 8 9, 30",
        "0 0 0, 5",
        "123, 200",
        "456 789, 1500"
    })
    void testEquivalence(String inputString, int totalFruits) {
        assertEquals(
            HumanEval_67_Source.fruitDistribution(inputString, totalFruits),
            HumanEval_67_Transformed.calculateRemainingFruits(inputString, totalFruits)
        );
    }
}