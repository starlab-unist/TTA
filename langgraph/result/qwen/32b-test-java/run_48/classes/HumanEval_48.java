import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_48 {

    // Source Code
    private static final HumanEval_48 sourceCode = new HumanEval_48();

    // Transformed Code
    private static final HumanEval_48_Transformed transformedCode = new HumanEval_48_Transformed();

    // Test Cases
    private static final String[] testCases = {
        "racecar",
        "level",
        "hello",
        "world",
        "",
        "a",
        "abba",
        "abcba",
        "noon",
        "python"
    };

    @Test
    public void test_0() {
        assertEquals(sourceCode.isPalindrome(testCases[0]), transformedCode.checkPalindrome(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(sourceCode.isPalindrome(testCases[1]), transformedCode.checkPalindrome(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(sourceCode.isPalindrome(testCases[2]), transformedCode.checkPalindrome(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(sourceCode.isPalindrome(testCases[3]), transformedCode.checkPalindrome(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(sourceCode.isPalindrome(testCases[4]), transformedCode.checkPalindrome(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(sourceCode.isPalindrome(testCases[5]), transformedCode.checkPalindrome(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(sourceCode.isPalindrome(testCases[6]), transformedCode.checkPalindrome(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(sourceCode.isPalindrome(testCases[7]), transformedCode.checkPalindrome(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(sourceCode.isPalindrome(testCases[8]), transformedCode.checkPalindrome(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(sourceCode.isPalindrome(testCases[9]), transformedCode.checkPalindrome(testCases[9]));
    }
}