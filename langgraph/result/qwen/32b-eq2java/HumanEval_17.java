import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanEval_17 {

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