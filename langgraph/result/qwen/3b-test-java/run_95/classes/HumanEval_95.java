import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_95 {

    // Original Implementation
    public static class OriginalImpl {
        public static boolean checkDictCase(java.util.Map<String, Object> dict) {
            if (dict.isEmpty()) {
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
                    } else if ((state.equals("upper") && !key.equals(key.toUpperCase())) || (state.equals("lower") && !key.equals(key.toLowerCase()))) {
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

    // Transformed Implementation
    public static class TransformedImpl {
        public static boolean evaluateDictionaryKeysCasing(java.util.Map<String, Object> inputDict) {
            if (inputDict == null || inputDict.isEmpty()) {
                return false;
            }

            String casingState = null;
            for (String key : inputDict.keySet()) {
                if (!(key instanceof String)) {
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
                    if ((casingState.equals("UPPER") && !key.equals(key.toUpperCase())) || (casingState.equals("LOWER") && !key.equals(key.toLowerCase()))) {
                        return false;
                    }
                }
            }

            return List.of("UPPER", "LOWER").contains(casingState);
        }
    }

    // Provide test cases
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(Map.of(), false),
            Arguments.of(Map.of("A", 1, "B", 2, "C", 3), true),
            Arguments.of(Map.of("a", 1, "b", 2, "c", 3), true),
            Arguments.of(Map.of("A", 1, "b", 2, "C", 3), false),
            Arguments.of(Map.of("1", 1, "2", 2, "3", 3), false),
            Arguments.of(Map.of("a", 1, "b", 2, "c", 3, "d", 4, "e", 5), true),
            Arguments.of(Map.of("HELLO", 1, "WORLD", 2), true),
            Arguments.of(Map.of("hello", 1, "world", 2), true),
            Arguments.of(Map.of("Mixed", 1, "CASE", 2), false),
            Arguments.of(Map.of("SINGLE", 42), true)
        );
    }

    // Parameterized Test
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testBothImplementations(Map<String, Object> input, boolean expected) {
        assertEquals(OriginalImpl.checkDictCase(input), TransformedImpl.evaluateDictionaryKeysCasing(input));
    }
}