import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_49 {

    // Source Code
    static class SourceCode {
        public static int modp(int n, int p) {
            int ret = 1;
            for (int i = 0; i < n; i++) {
                ret = (2 * ret) % p;
            }
            return ret;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public int calculateModularExponentiation(int baseCount, int modulus) {
            int result = 1;
            int index = 0;
            while (index < baseCount) {
                result = (2 * result) % modulus;
                index += 1;
            }
            return result;
        }
    }

    // Test Cases
    private static final int[][] testCases = {
        {0, 5},       // n=0, p=5
        {1, 3},       // n=1, p=3
        {2, 7},       // n=2, p=7
        {3, 4},       // n=3, p=4
        {5, 10},      // n=5, p=10
        {10, 13},     // n=10, p=13
        {20, 17},     // n=20, p=17
        {31, 31},     // n=31, p=31
        {50, 61},     // n=50, p=61
        {100, 97}     // n=100, p=97
    };

    @Test
    public void test_0() {
        assertEquals(SourceCode.modp(testCases[0][0], testCases[0][1]), new TransformedCode().calculateModularExponentiation(testCases[0][0], testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.modp(testCases[1][0], testCases[1][1]), new TransformedCode().calculateModularExponentiation(testCases[1][0], testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.modp(testCases[2][0], testCases[2][1]), new TransformedCode().calculateModularExponentiation(testCases[2][0], testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.modp(testCases[3][0], testCases[3][1]), new TransformedCode().calculateModularExponentiation(testCases[3][0], testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.modp(testCases[4][0], testCases[4][1]), new TransformedCode().calculateModularExponentiation(testCases[4][0], testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.modp(testCases[5][0], testCases[5][1]), new TransformedCode().calculateModularExponentiation(testCases[5][0], testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.modp(testCases[6][0], testCases[6][1]), new TransformedCode().calculateModularExponentiation(testCases[6][0], testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.modp(testCases[7][0], testCases[7][1]), new TransformedCode().calculateModularExponentiation(testCases[7][0], testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.modp(testCases[8][0], testCases[8][1]), new TransformedCode().calculateModularExponentiation(testCases[8][0], testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.modp(testCases[9][0], testCases[9][1]), new TransformedCode().calculateModularExponentiation(testCases[9][0], testCases[9][1]));
    }
}