import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HumanEval_145 {

    // Source Code
    static class HumanEval_145_Source {
        public static int[] orderByPoints(int[] nums) {
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return digitsSum(a) - digitsSum(b);
                }
            });
            return nums;
        }

        private static int digitsSum(int n) {
            int neg = 1;
            if (n < 0) {
                n = -1 * n;
                neg = -1;
            }
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum * neg;
        }
    }

    // Transformed Code
    static class HumanEval_145_Transformed {
        public static int[] orderByPoints(int[] nums) {
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer n1, Integer n2) {
                    int sign1 = n1 < 0 ? -1 : 1;
                    int sign2 = n2 < 0 ? -1 : 1;
                    int absValue1 = Math.abs(n1);
                    int absValue2 = Math.abs(n2);
                    int[] digits1 = String.valueOf(absValue1).chars().map(Character::getNumericValue).toArray();
                    int[] digits2 = String.valueOf(absValue2).chars().map(Character::getNumericValue).toArray();
                    digits1[0] *= sign1;
                    digits2[0] *= sign2;
                    return Arrays.stream(digits1).sum() - Arrays.stream(digits2).sum();
                }
            });
            return nums;
        }
    }

    // Test Cases
    private static final int[][][] testCases = {
        { {123, 321, 213}, {123, 213, 321} },
        { {-12, -21, 12, 21}, {-12, 12, -21, 21} },
        { {0, 5, 10, 15}, {0, 5, 10, 15} },
        { {987, 879, 798}, {798, 879, 987} },
        { {-1234, -4321, 1234, 4321}, {-1234, 1234, -4321, 4321} },
        { {555, 666, 777}, {555, 666, 777} },
        { {-9, -8, -7, -6}, {-6, -7, -8, -9} },
        { {100, 200, 300}, {100, 200, 300} },
        { {5, -5, 10, -10}, {5, -5, 10, -10} },
        { {111, -111, 222, -222}, {111, -111, 222, -222} }
    };

    @Test
    public void test_0() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[0][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[0][0].clone()));
    }

    @Test
    public void test_1() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[1][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[1][0].clone()));
    }

    @Test
    public void test_2() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[2][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[2][0].clone()));
    }

    @Test
    public void test_3() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[3][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[3][0].clone()));
    }

    @Test
    public void test_4() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[4][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[4][0].clone()));
    }

    @Test
    public void test_5() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[5][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[5][0].clone()));
    }

    @Test
    public void test_6() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[6][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[6][0].clone()));
    }

    @Test
    public void test_7() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[7][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[7][0].clone()));
    }

    @Test
    public void test_8() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[8][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[8][0].clone()));
    }

    @Test
    public void test_9() {
        assertArrayEquals(HumanEval_145_Source.orderByPoints(testCases[9][0].clone()), 
                          HumanEval_145_Transformed.orderByPoints(testCases[9][0].clone()));
    }
}