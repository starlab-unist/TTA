import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_74 {

    // Source Code
    static class HumanEval_74_Source {
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
    static class HumanEval_74_Transformed {
        public static List<String> compareStringLists(List<String> lst1, List<String> lst2) {
            int lengthA = lst1.stream().mapToInt(String::length).sum();
            
            int lengthB = 0;
            int index = 0;
            while (index < lst2.size()) {
                lengthB += lst2.get(index).length();
                index++;
            }
            
            return lengthA <= lengthB ? lst1 : lst2;
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {List.of("hello", "world"), List.of("hi", "planet")},
        {List.of("apple", "banana"), List.of("kiwi", "grape", "melon")},
        {List.of("one"), List.of("two", "three")},
        {List.of(), List.of("single")},
        {List.of("same", "length"), List.of("even", "longer")},
        {List.of("a", "b", "c"), List.of("d", "e", "f")},
        {List.of("short"), List.of("tiny", "bit")},
        {List.of("equal"), List.of("equal")},
        {List.of("abc"), List.of("defg")},
        {List.of(), List.of()}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[0][0], (List<String>) testCases[0][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[0][0], (List<String>) testCases[0][1]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[1][0], (List<String>) testCases[1][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[1][0], (List<String>) testCases[1][1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[2][0], (List<String>) testCases[2][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[2][0], (List<String>) testCases[2][1]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[3][0], (List<String>) testCases[3][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[3][0], (List<String>) testCases[3][1]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[4][0], (List<String>) testCases[4][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[4][0], (List<String>) testCases[4][1]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[5][0], (List<String>) testCases[5][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[5][0], (List<String>) testCases[5][1]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[6][0], (List<String>) testCases[6][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[6][0], (List<String>) testCases[6][1]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[7][0], (List<String>) testCases[7][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[7][0], (List<String>) testCases[7][1]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[8][0], (List<String>) testCases[8][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[8][0], (List<String>) testCases[8][1]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_74_Source.totalMatch((List<String>) testCases[9][0], (List<String>) testCases[9][1]), 
                     HumanEval_74_Transformed.compareStringLists((List<String>) testCases[9][0], (List<String>) testCases[9][1]));
    }
}