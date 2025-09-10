public class HumanEval_95 {

    public static boolean evaluateDictionaryKeysCasing(java.util.Map<String, Object> inputDict) {
        if (inputDict == null || inputDict.isEmpty()) {
            return false;
        }

        String casingState = null;
        for (String key : inputDict.keySet()) {
            if (!key instanceof String) {
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

        return Arrays.asList("UPPER", "LOWER").contains(casingState);
    }
}