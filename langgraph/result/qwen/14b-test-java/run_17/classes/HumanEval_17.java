import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
                if (!note.isEmpty()) {
                    result.add(noteMap.getOrDefault(note, 0));
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
                    result.add(noteMapping.getOrDefault(note, 0));
                }
            }

            return result;
        }
    }

    // Test Cases
    private static final String[][] testCases = {
        {"o o| .|"},
        {"o o o"},
        {".| .| .|"},
        {"o| o| o|"},
        {"o o| .| o| .|"},
        {""},
        {"   "},
        {"o o| .| o| .| o o| .|"},
        {"o|"},
        {"o"}
    };

    private static Stream<Arguments> provideTestCases() {
        return Arrays.stream(testCases).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void parseMusic_vs_extractNotes(String inputText) {
        assertEquals(
            SourceCode.parseMusic(inputText),
            TransformedCode.extractNotes(inputText)
        );
    }
}