import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanEval_17 {

    // Source Code
    static class HumanEval_17_Source {
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
    static class HumanEval_17_Transformed {
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
    private static final String[] testCases = {
        "o o| .|",
        "o o o",
        ".| .| .|",
        "o| o| o|",
        "o o| .| o| .|",
        "",
        "   ",
        "o o| .| o| .| o o| .|",
        "o|",
        "o"
    };

    @Test
    public void test_0() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[0]), HumanEval_17_Transformed.extractNotes(testCases[0]));
    }

    @Test
    public void test_1() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[1]), HumanEval_17_Transformed.extractNotes(testCases[1]));
    }

    @Test
    public void test_2() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[2]), HumanEval_17_Transformed.extractNotes(testCases[2]));
    }

    @Test
    public void test_3() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[3]), HumanEval_17_Transformed.extractNotes(testCases[3]));
    }

    @Test
    public void test_4() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[4]), HumanEval_17_Transformed.extractNotes(testCases[4]));
    }

    @Test
    public void test_5() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[5]), HumanEval_17_Transformed.extractNotes(testCases[5]));
    }

    @Test
    public void test_6() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[6]), HumanEval_17_Transformed.extractNotes(testCases[6]));
    }

    @Test
    public void test_7() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[7]), HumanEval_17_Transformed.extractNotes(testCases[7]));
    }

    @Test
    public void test_8() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[8]), HumanEval_17_Transformed.extractNotes(testCases[8]));
    }

    @Test
    public void test_9() {
        assertEquals(HumanEval_17_Source.parseMusic(testCases[9]), HumanEval_17_Transformed.extractNotes(testCases[9]));
    }
}