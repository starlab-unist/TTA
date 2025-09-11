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
    public static boolean iscube(int a) {
        a = Math.abs(a);
        int cubeRoot = Math.round(Math.cbrt(a));
        return cubeRoot * cubeRoot * cubeRoot == a;
    }

    // Transformed Code
    public static boolean checkPerfectCube(int number) {
        number = Math.abs(number);
        int cubeRoot = (int) Math.round(Math.cbrt(number));
        return cubeRoot * cubeRoot * cubeRoot == number;
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
        assertEquals(iscube(testCases[0]), checkPerfectCube(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(iscube(testCases[1]), checkPerfectCube(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(iscube(testCases[2]), checkPerfectCube(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(iscube(testCases[3]), checkPerfectCube(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(iscube(testCases[4]), checkPerfectCube(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(iscube(testCases[5]), checkPerfectCube(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(iscube(testCases[6]), checkPerfectCube(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(iscube(testCases[7]), checkPerfectCube(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(iscube(testCases[8]), checkPerfectCube(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(iscube(testCases[9]), checkPerfectCube(testCases[9]));
    }
}