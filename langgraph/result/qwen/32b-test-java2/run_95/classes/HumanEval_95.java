import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_95 {

    // Source Code
    static class HumanEval_95_Source {
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
    }

    // Transformed Code
    static class HumanEval_95_Transformed {
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
    }

    // Test Cases
    private static final Object[][] testCases = {
        {new HashMap<>(), false},
        {createMap(new String[]{"A", "B", "C"}, new Integer[]{1, 2, 3}), true},
        {createMap(new String[]{"a", "b", "c"}, new Integer[]{1, 2, 3}), true},
        {createMap(new String[]{"A", "b", "C"}, new Integer[]{1, 2, 3}), false},
        {createMap(new String[]{"1", "2", "3"}, new Integer[]{1, 2, 3}), false},
        {createMap(new String[]{"A"}, new Integer[]{1}), true}, // Corrected this test case to be a valid map
        {createMap(new String[]{"a", "b", "c", "d", "e"}, new Integer[]{1, 2, 3, 4, 5}), true},
        {createMap(new String[]{"HELLO", "WORLD"}, new Integer[]{1, 2}), true},
        {createMap(new String[]{"hello", "world"}, new Integer[]{1, 2}), true},
        {createMap(new String[]{"Mixed", "CASE"}, new Integer[]{1, 2}), false}
    };

    private static Map<String, ?> createMap(String[] keys, Object[] values) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @DisplayName("Check if both functions produce the same output for given inputs")
    @ParameterizedTest(name = "Case {index}: Input({0}) => Expected Output: {1}")
    @MethodSource("provideTestCases")
    void checkDictCase_vs_evaluateDictionaryKeysCasing(Map<String, ?> inputDict, boolean expected) {
        assertEquals(
            HumanEval_95_Source.checkDictCase(inputDict),
            HumanEval_95_Transformed.evaluateDictionaryKeysCasing(inputDict)
        );
    }
}