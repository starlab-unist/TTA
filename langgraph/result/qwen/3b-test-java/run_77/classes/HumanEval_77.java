import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_77 {

    // Source Code
    static class HumanEval_77_Source {
        public static boolean isCube(int a) {
            a = Math.abs(a);
            int cubeRoot = (int) Math.round(Math.pow(a, 1.0 / 3.0));
            return cubeRoot * cubeRoot * cubeRoot == a;
        }
    }

    // Transformed Code
    static class HumanEval_77_Transformed {
        public static boolean checkPerfectCube(int number) {
            number = Math.abs(number);
            int cubeRoot = (int) Math.round(Math.pow(number, 1.0 / 3.0));
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

    @Test
    public void test_0() {
        assertEquals(HumanEval_77_Source.isCube(testCases[0]), HumanEval_77_Transformed.checkPerfectCube(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_77_Source.isCube(testCases[1]), HumanEval_77_Transformed.checkPerfectCube(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_77_Source.isCube(testCases[2]), HumanEval_77_Transformed.checkPerfectCube(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_77_Source.isCube(testCases[3]), HumanEval_77_Transformed.checkPerfectCube(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_77_Source.isCube(testCases[4]), HumanEval_77_Transformed.checkPerfectCube(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_77_Source.isCube(testCases[5]), HumanEval_77_Transformed.checkPerfectCube(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_77_Source.isCube(testCases[6]), HumanEval_77_Transformed.checkPerfectCube(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_77_Source.isCube(testCases[7]), HumanEval_77_Transformed.checkPerfectCube(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_77_Source.isCube(testCases[8]), HumanEval_77_Transformed.checkPerfectCube(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_77_Source.isCube(testCases[9]), HumanEval_77_Transformed.checkPerfectCube(testCases[9]));
    }
}