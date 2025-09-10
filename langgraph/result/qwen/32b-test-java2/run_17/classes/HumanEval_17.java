import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_17 {

    // Source Code
    static class SourceCode {
        public static List<Integer> parseMusic(String musicString) {
            Map<String, Integer> noteMap = new HashMap<>();
            noteMap.put("o", 4);
            noteMap.put("o|", 2);
            noteMap.put(".|", 1);

            List<Integer> result = new ArrayList<>();
            String[] notes = musicString.split(" ");
            for (String note : notes) {
                if (!note.isEmpty() && noteMap.containsKey(note)) {
                    result.add(noteMap.get(note));
                }
            }
            return result;
        }
    }

    // Transformed Code
    static class TransformedCode {
        public static List<Integer> extractNotes(String musicalNotation) {
            Map<String, Integer> noteMapping = new HashMap<>();
            noteMapping.put("o", 4);
            noteMapping.put("o|", 2);
            noteMapping.put(".|", 1);

            String[] notes = musicalNotation.split(" ");
            List<Integer> result = new ArrayList<>();

            for (String note : notes) {
                if (!note.isEmpty()) {
                    result.add(noteMapping.get(note));
                }
            }

            return result;
        }
    }

    // Test Cases
    private static final Arguments[][] testCases = {
        {Arguments.of("o o| .|")},
        {Arguments.of("o o o")},
        {Arguments.of(".| .| .|")},
        {Arguments.of("o| o| o|")},
        {Arguments.of("o o| .| o| .|")},
        {Arguments.of("")},
        {Arguments.of("   ")},
        {Arguments.of("o o| .| o| .| o o| .|")},
        {Arguments.of("o|")},
        {Arguments.of("o")}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).flatMap(Arrays::stream);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test parseMusic vs extractNotes equivalence")
    void test_parseMusic_vs_extractNotes(String inputText) {
        assertEquals(
            SourceCode.parseMusic(inputText),
            TransformedCode.extractNotes(inputText)
        );
    }
}