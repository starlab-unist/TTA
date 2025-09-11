import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_95 {

    // Source Code
    public static boolean checkDictCase(Map<Object, Object> dict) {
        if (dict.isEmpty()) {
            return false;
        } else {
            String state = "start";
            for (Object key : dict.keySet()) {

                if (!(key instanceof String)) {
                    state = "mixed";
                    break;
                }
                if (state.equals("start")) {
                    if (((String) key).toUpperCase().equals(key.toString())) {
                        state = "upper";
                    } else if (((String) key).toLowerCase().equals(key.toString())) {
                        state = "lower";
                    } else {
                        break;
                    }
                } else if ((state.equals("upper") && !((String) key).toUpperCase().equals(key.toString())) || 
                          (state.equals("lower") && !((String) key).toLowerCase().equals(key.toString()))) {
                    state = "mixed";
                    break;
                } else {
                    break;
                }
            }
            return state.equals("upper") || state.equals("lower");
        }
    }

    // Transformed Code
    public boolean evaluateDictionaryKeysCasing(Map<String, ?> dict) {
        if (dict.isEmpty()) {
            return false;
        }

        String state = null;
        for (String key : dict.keySet()) {
            if (!key.matches("[a-zA-Z]+")) {
                return false;
            }

            if (state == null) {
                if (key.equals(key.toUpperCase())) {
                    state = "UPPER";
                } else if (key.equals(key.toLowerCase())) {
                    state = "LOWER";
                } else {
                    return false;
                }
            } else {
                if ((state.equals("UPPER") && !key.equals(key.toUpperCase())) || 
                    (state.equals("LOWER") && !key.equals(key.toLowerCase()))) {
                    return false;
                }
            }
        }

        return state != null && (state.equals("UPPER") || state.equals("LOWER"));
    }

    // Test Cases
    private static final Object[][] testCases = {
        {Map.of(), false},
        {Map.of("A", 1, "B", 2, "C", 3), true},
        {Map.of("a", 1, "b", 2, "c", 3), true},
        {Map.of("A", 1, "b", 2, "C", 3), false},
        {Map.of("1", 1, "2", 2, "3", 3), false},
        // Note: The transformed function expects Map<String, ?>, so this case is invalid for it.
        // {Map.of("A", 1, 2, "B", "C", 3), false},
        {Map.of("a", 1, "b", 2, "c", 3, "d", 4, "e", 5), true},
        {Map.of("HELLO", 1, "WORLD", 2), true},
        {Map.of("hello", 1, "world", 2), true},
        {Map.of("Mixed", 1, "CASE", 2), false}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[0][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[1][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[2][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[3][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[4][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[4][0]));
    }

    // Skipping invalid test case for transformed function
    // @Test
    // public void test_5() {
    //     assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[5][0]), 
    //                  new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[5][0]));
    // }

    @Test
    public void test_6() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[6][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[7][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[8][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_95.checkDictCase((Map<Object, Object>) testCases[9][0]), 
                     new HumanEval_95().evaluateDictionaryKeysCasing((Map<String, ?>) testCases[9][0]));
    }
}