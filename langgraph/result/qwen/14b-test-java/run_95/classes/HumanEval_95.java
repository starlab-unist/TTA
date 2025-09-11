import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_95 {

    // Source Code
    public static class HumanEval_95_Source {
        public static boolean checkDictCase(java.util.Map<String, Object> dict) {
            if (dict.size() == 0) {
                return false;
            } else {
                String state = "start";
                for (String key : dict.keySet()) {

                    if (!(key instanceof String)) {
                        state = "mixed";
                        break;
                    }
                    if (state.equals("start")) {
                        if (key.equals(key.toUpperCase())) {
                            state = "upper";
                        } else if (key.equals(key.toLowerCase())) {
                            state = "lower";
                        } else {
                            break;
                        }
                    } else if ((state.equals("upper") && !key.equals(key.toUpperCase())) || 
                               (state.equals("lower") && !key.equals(key.toLowerCase()))) {
                        state = "mixed";
                        break;
                    } else {
                        break;
                    }
                }
                return state.equals("upper") || state.equals("lower");
            }
        }
    }

    // Transformed Code
    public static class HumanEval_95_Transformed {
        public static boolean evaluateDictionaryKeysCasing(Map<String, Object> inputDict) {
            if (inputDict.isEmpty()) {
                return false;
            }

            String casingState = null;
            for (String key : inputDict.keySet()) {
                if (key == null || !(key instanceof String)) {
                    return false;
                }

                if (casingState == null) {
                    if (key.equals(key.toUpperCase())) {
                        casingState = "UPPER";
                    } else if (key.equals(key.toLowerCase())) {
                        casingState = "LOWER";
                    } else {
                        return false;
                    }
                } else {
                    if ((casingState.equals("UPPER") && !key.equals(key.toUpperCase())) ||
                        (casingState.equals("LOWER") && !key.equals(key.toLowerCase()))) {
                        return false;
                    }
                }
            }

            return casingState != null && (casingState.equals("UPPER") || casingState.equals("LOWER"));
        }
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new HashMap<String, Object>(), false},
        {Map.of("A", 1, "B", 2, "C", 3), true},
        {Map.of("a", 1, "b", 2, "c", 3), true},
        {Map.of("A", 1, "b", 2, "C", 3), false},
        {Map.of("1", 1, "2", 2, "3", 3), false},
        {Map.of("A", 1, 2, "B", "C", 3), false}, // This test case will not work in Java as Map.of() does not allow non-String keys
        {Map.of("a", 1, "b", 2, "c", 3, "d", 4, "e", 5), true},
        {Map.of("HELLO", 1, "WORLD", 2), true},
        {Map.of("hello", 1, "world", 2), true},
        {Map.of("Mixed", 1, "CASE", 2), false}
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[0][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[1][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[2][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[3][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[4][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[4][0]));
    }

    @Test
    public void test_6() { // Skipping test case 5 as it contains non-String keys which is not valid in Java Map.of()
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[6][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[7][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[8][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_95_Source.checkDictCase((Map<String, Object>) testCases[9][0]), 
                     HumanEval_95_Transformed.evaluateDictionaryKeysCasing((Map<String, Object>) testCases[9][0]));
    }
}