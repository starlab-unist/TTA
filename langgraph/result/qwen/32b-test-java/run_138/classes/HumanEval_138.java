import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_138 {

    // Source Code Class
    static class SourceCode {
        public boolean isEqualToSumEven(int n) {
            return n % 2 == 0 && n >= 8;
        }
    }

    // Transformed Code Class
    static class TransformedCode {
        public boolean checkEvenAndMinimumEight(int number) {
            return number % 2 == 0 && number >= 8;
        }
    }

    @Test
    public void test_0() {
        assertEquals(new SourceCode().isEqualToSumEven(4), new TransformedCode().checkEvenAndMinimumEight(4));
    }

    @Test
    public void test_1() {
        assertEquals(new SourceCode().isEqualToSumEven(6), new TransformedCode().checkEvenAndMinimumEight(6));
    }

    @Test
    public void test_2() {
        assertEquals(new SourceCode().isEqualToSumEven(8), new TransformedCode().checkEvenAndMinimumEight(8));
    }

    @Test
    public void test_3() {
        assertEquals(new SourceCode().isEqualToSumEven(10), new TransformedCode().checkEvenAndMinimumEight(10));
    }

    @Test
    public void test_4() {
        assertEquals(new SourceCode().isEqualToSumEven(12), new TransformedCode().checkEvenAndMinimumEight(12));
    }

    @Test
    public void test_5() {
        assertEquals(new SourceCode().isEqualToSumEven(7), new TransformedCode().checkEvenAndMinimumEight(7));
    }

    @Test
    public void test_6() {
        assertEquals(new SourceCode().isEqualToSumEven(9), new TransformedCode().checkEvenAndMinimumEight(9));
    }

    @Test
    public void test_7() {
        assertEquals(new SourceCode().isEqualToSumEven(0), new TransformedCode().checkEvenAndMinimumEight(0));
    }

    @Test
    public void test_8() {
        assertEquals(new SourceCode().isEqualToSumEven(-2), new TransformedCode().checkEvenAndMinimumEight(-2));
    }
}