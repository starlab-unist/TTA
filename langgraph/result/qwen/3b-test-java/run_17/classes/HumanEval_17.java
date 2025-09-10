import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_17 {

    // Source Code
    public static List<Integer> parseMusic(String musicString) {
        String[] notes = musicString.split(" ");
        List<Integer> result = new ArrayList<>();
        
        for (String note : notes) {
            switch (note) {
                case "o":
                    result.add(4);
                    break;
                case "o|":
                    result.add(2);
                    break;
                case ".|":
                    result.add(1);
                    break;
            }
        }
        
        return result;
    }

    // Transformed Code
    public static List<Integer> extractNotes(String musicalNotation) {
        HashMap<String, Integer> noteMapping = new HashMap<>();
        noteMapping.put("o", 4);
        noteMapping.put("o|", 2);
        noteMapping.put(".|", 1);

        String[] notes = musicalNotation.split(" ");
        List<Integer> result = new ArrayList<>();

        for (String note : notes) {
            if (!note.isEmpty() && noteMapping.containsKey(note)) {
                result.add(noteMapping.get(note));
            }
        }

        return result;
    }
}

class HumanEval_17Test {

    // Original implementation wrapper
    static class OriginalImpl {
        public static List<Integer> parseMusic(String musicString) {
            return HumanEval_17.parseMusic(musicString);
        }
    }

    // Transformed implementation wrapper
    static class TransformedImpl {
        public static List<Integer> extractNotes(String musicalNotation) {
            return HumanEval_17.extractNotes(musicalNotation);
        }
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.arguments("o o| .|"),
            Arguments.arguments("o o o"),
            Arguments.arguments(".| .| .|"),
            Arguments.arguments("o| o| o|"),
            Arguments.arguments("o o| .| o| .|"),
            Arguments.arguments(""),
            Arguments.arguments("   "),
            Arguments.arguments("o o| .| o| .| o o| .|"),
            Arguments.arguments("o|"),
            Arguments.arguments("o")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testParsing(String input) {
        assertEquals(OriginalImpl.parseMusic(input), TransformedImpl.extractNotes(input));
    }
}