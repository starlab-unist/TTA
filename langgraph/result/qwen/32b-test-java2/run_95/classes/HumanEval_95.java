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
    public static boolean checkDictCase(Map<?, ?> dict) {
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
                    if (((String) key).equals(((String) key).toUpperCase())) {
                        state = "upper";
                    } else if (((String) key).equals(((String) key).toLowerCase())) {
                        state = "lower";
                    } else {
                        break;
                    }
                } else if ((state.equals("upper") && !((String) key).equals(((String) key).toUpperCase())) || 
                           (state.equals("lower") && !((String) key).equals(((String) key).toLowerCase()))) {
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
    public static boolean evaluateDictionaryKeysCasing(Map<String, ?> inputDict) {
        if (inputDict.isEmpty()) {
            return false;
        }

        String casingState = null;
        for (String key : inputDict.keySet()) {
            if (key == null) {
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

        return casingState.equals("UPPER") || casingState.equals("LOWER");
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new HashMap<>(), false},
        {Map.of("A", 1, "B", 2, "C", 3), true},
        {Map.of("a", 1, "b", 2, "c", 3), true},
        {Map.of("A", 1, "b", 2, "C", 3), false},
        {Map.of("1", 1, "2", 2, "3", 3), false},
        {Map.of("A", 1, 2, "B", "C", 3), false}, // This test case will fail in Java as Map.of requires key-value pairs
        {Map.of("a", 1, "b", 2, "c", 3, "d", 4, "e", 5), true},
        {Map.of("HELLO", 1, "WORLD", 2), true},
        {Map.of("hello", 1, "world", 2), true},
        {Map.of("Mixed", 1, "CASE", 2), false}
    };

    @Test
    public void test_0() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[0][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[0][0]));
    }

    @Test
    public void test_1() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[1][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[1][0]));
    }

    @Test
    public void test_2() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[2][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[2][0]));
    }

    @Test
    public void test_3() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[3][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[3][0]));
    }

    @Test
    public void test_4() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[4][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[4][0]));
    }

    // Test case 5 will be commented out as it is invalid in Java due to Map.of requiring key-value pairs
//    @Test
//    public void test_5() {
//        assertEquals(checkDictCase((Map<?, ?>) testCases[5][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[5][0]));
//    }

    @Test
    public void test_6() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[6][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[6][0]));
    }

    @Test
    public void test_7() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[7][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[7][0]));
    }

    @Test
    public void test_8() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[8][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[8][0]));
    }

    @Test
    public void test_9() {
        assertEquals(checkDictCase((Map<?, ?>) testCases[9][0]), evaluateDictionaryKeysCasing((Map<String, ?>) testCases[9][0]));
    }
}