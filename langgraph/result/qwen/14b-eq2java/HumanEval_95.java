import java.util.Map;

public class HumanEval_95 {
    public static boolean evaluateDictionaryKeysCasing(Map<String, Object> inputDict) {
        if (inputDict.isEmpty()) {
            return false;
        }

        String casingState = null;
        for (String key : inputDict.keySet()) {
            if (key == null || !(key instanceof String)) {
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

        return casingState != null && (casingState.equals("UPPER") || casingState.equals("LOWER"));
    }
}