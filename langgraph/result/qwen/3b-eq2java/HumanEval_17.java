import java.util.ArrayList;
import java.util.List;

public class HumanEval_17 {

    public static List<Integer> extractNotes(String musicalNotation) {
        java.util.HashMap<Character, Integer> noteMapping = new java.util.HashMap<>();
        noteMapping.put('o', 4);
        noteMapping.put('o|', 2);
        noteMapping.put('.|', 1);

        String[] notes = musicalNotation.split(" ");
        List<Integer> result = new ArrayList<>();

        for (String note : notes) {
            if (!note.isEmpty()) {
                result.add(noteMapping.get(note.charAt(0)));
            }
        }

        return result;
    }
}