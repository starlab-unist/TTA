import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanEval_17 {

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