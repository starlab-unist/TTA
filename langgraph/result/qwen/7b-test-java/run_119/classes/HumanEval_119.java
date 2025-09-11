import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_119 {

    // Source Code
    public static String matchParens(String[] lst) {
        String S1 = lst[0] + lst[1];
        String S2 = lst[1] + lst[0];
        return check(S1) || check(S2) ? "Yes" : "No";
    }

    private static boolean check(String s) {
        int val = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                val++;
            } else {
                val--;
            }
            if (val < 0) {
                return false;
            }
        }
        return val == 0;
    }

    // Transformed Code
    public static String validateParenthesesCombinations(String[] strings) {
        boolean isBalancedFirstSecond = isBalanced(strings[0] + strings[1]);
        boolean isBalancedSecondFirst = isBalanced(strings[1] + strings[0]);

        return isBalancedFirstSecond || isBalancedSecondFirst ? "Yes" : "No";
    }

    private static boolean isBalanced(String expression) {
        int balance = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new String[]{"()", "()"}, "Yes"},
        {new String[]{"(", ")"}, "Yes"},
        {new String[]{"(()", "())"}, "Yes"},
        {new String[]{"(", "("}, "No"},
        {new String[]{"))", "(("}, "No"},
        {new String[]{"(())", "()"}, "Yes"},
        {new String[]{"((()))", ""}, "Yes"},
        {new String[]{"", ""}, "Yes"},
        {new String[]{"()(", ")"}, "Yes"},
        {new String[]{"(()", "()())"}, "Yes"}
    };

    @Test
    public void test_0() {
        assertEquals(matchParens((String[]) testCases[0][0]), 
                     validateParenthesesCombinations((String[]) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(matchParens((String[]) testCases[1][0]), 
                     validateParenthesesCombinations((String[]) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(matchParens((String[]) testCases[2][0]), 
                     validateParenthesesCombinations((String[]) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(matchParens((String[]) testCases[3][0]), 
                     validateParenthesesCombinations((String[]) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(matchParens((String[]) testCases[4][0]), 
                     validateParenthesesCombinations((String[]) testCases[4][0]));
    }

    @Test
    public void test_5() {
        assertEquals(matchParens((String[]) testCases[5][0]), 
                     validateParenthesesCombinations((String[]) testCases[5][0]));
    }

    @Test
    public void test_6() {
        assertEquals(matchParens((String[]) testCases[6][0]), 
                     validateParenthesesCombinations((String[]) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(matchParens((String[]) testCases[7][0]), 
                     validateParenthesesCombinations((String[]) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(matchParens((String[]) testCases[8][0]), 
                     validateParenthesesCombinations((String[]) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(matchParens((String[]) testCases[9][0]), 
                     validateParenthesesCombinations((String[]) testCases[9][0]));
    }
}