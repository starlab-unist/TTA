import java.util.ArrayList;
import java.util.List;

public class HumanEval_17 {
    public static List<Integer> parseMusic(String musicString) {
        String[] notes = musicString.split(" ");
        List<Integer> result = new ArrayList<>();
        for (String note : notes) {
            if (!note.isEmpty()) {
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
        }
        return result;
    }
}