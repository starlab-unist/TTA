import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_77 {

    // Source Code
    static class SourceCode {
        public static boolean iscube(int a) {
            a = Math.abs(a);
            int cubeRoot = (int) Math.round(Math.cbrt(a));
            return cubeRoot * cubeRoot * cubeRoot == a;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public boolean checkPerfectCube(int number) {
            number = Math.abs(number);
            int cubeRoot = Math.round(Math.cbrt(number));
            return cubeRoot * cubeRoot * cubeRoot == number;
        }
    }

    // Test Cases
    private static final int[] testCases = {
        27,     // 3^3
        -27,    // -3^3 but abs is used so it should be treated as 3^3
        64,     // 4^3
        -64,    // -4^3 but abs is used so it should be treated as 4^3
        0,      // 0^3
        1,      // 1^3
        2,      // Not a perfect cube
        -8,     // -2^3 but abs is used so it should be treated as 2^3
        15,     // Not a perfect cube
        125     // 5^3
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Check if both iscube and checkPerfectCube produce the same output for given inputs.")
    void testIscubeVsCheckPerfectCube(int testCase) {
        assertEquals(
            SourceCode.iscube(testCase),
            new TransformedCode().checkPerfectCube(testCase)
        );
    }
}