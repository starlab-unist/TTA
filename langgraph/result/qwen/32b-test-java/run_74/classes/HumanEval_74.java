import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_74 {

    // Source Code
    static class SourceCode {
        public static List<String> totalMatch(List<String> lst1, List<String> lst2) {
            int l1 = 0;
            for (String st : lst1) {
                l1 += st.length();
            }

            int l2 = 0;
            for (String st : lst2) {
                l2 += st.length();
            }

            if (l1 <= l2) {
                return lst1;
            } else {
                return lst2;
            }
        }
    }

    // Transformed Code
    static class TransformedCode {
        public List<String> compareStringLists(List<String> listA, List<String> listB) {
            int lengthA = 0;
            for (String string : listA) {
                lengthA += string.length();
            }

            int lengthB = 0;
            int index = 0;
            while (index < listB.size()) {
                lengthB += listB.get(index).length();
                index++;
            }

            return (lengthA <= lengthB) ? listA : listB;
        }
    }

    // Test Cases
    private static final List<String[]> testCases = Arrays.asList(
        new String[]{"hello", "world", "hi", "planet"},
        new String[]{"apple", "banana", "kiwi", "grape", "melon"},
        new String[]{"one", "two", "three"},
        new String[]{"single"},
        new String[]{"same", "length", "even", "longer"},
        new String[]{"a", "b", "c", "d", "e", "f"},
        new String[]{"short", "tiny", "bit"},
        new String[]{"equal", "equal"},
        new String[]{"abc", "defg"},
        new String[]{}
    );

    @Test
    public void test_0() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(0)[0], testCases.get(0)[1]), Arrays.asList(testCases.get(0)[2], testCases.get(0)[3])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(0)[0], testCases.get(0)[1]), Arrays.asList(testCases.get(0)[2], testCases.get(0)[3])));
    }

    @Test
    public void test_1() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(1)[0], testCases.get(1)[1]), Arrays.asList(testCases.get(1)[2], testCases.get(1)[3], testCases.get(1)[4])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(1)[0], testCases.get(1)[1]), Arrays.asList(testCases.get(1)[2], testCases.get(1)[3], testCases.get(1)[4])));
    }

    @Test
    public void test_2() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(2)[0]), Arrays.asList(testCases.get(2)[1], testCases.get(2)[2])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(2)[0]), Arrays.asList(testCases.get(2)[1], testCases.get(2)[2])));
    }

    @Test
    public void test_3() {
        assertEquals(SourceCode.totalMatch(new ArrayList<>(), Arrays.asList(testCases.get(3)[0])),
                     TransformedCode.compareStringLists(new ArrayList<>(), Arrays.asList(testCases.get(3)[0])));
    }

    @Test
    public void test_4() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(4)[0], testCases.get(4)[1]), Arrays.asList(testCases.get(4)[2], testCases.get(4)[3])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(4)[0], testCases.get(4)[1]), Arrays.asList(testCases.get(4)[2], testCases.get(4)[3])));
    }

    @Test
    public void test_5() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(5)[0], testCases.get(5)[1], testCases.get(5)[2]), Arrays.asList(testCases.get(5)[3], testCases.get(5)[4], testCases.get(5)[5])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(5)[0], testCases.get(5)[1], testCases.get(5)[2]), Arrays.asList(testCases.get(5)[3], testCases.get(5)[4], testCases.get(5)[5])));
    }

    @Test
    public void test_6() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(6)[0]), Arrays.asList(testCases.get(6)[1], testCases.get(6)[2])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(6)[0]), Arrays.asList(testCases.get(6)[1], testCases.get(6)[2])));
    }

    @Test
    public void test_7() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(7)[0]), Arrays.asList(testCases.get(7)[1])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(7)[0]), Arrays.asList(testCases.get(7)[1])));
    }

    @Test
    public void test_8() {
        assertEquals(SourceCode.totalMatch(Arrays.asList(testCases.get(8)[0]), Arrays.asList(testCases.get(8)[1])),
                     TransformedCode.compareStringLists(Arrays.asList(testCases.get(8)[0]), Arrays.asList(testCases.get(8)[1])));
    }

    @Test
    public void test_9() {
        assertEquals(SourceCode.totalMatch(new ArrayList<>(), new ArrayList<>()),
                     TransformedCode.compareStringLists(new ArrayList<>(), new ArrayList<>()));
    }
}