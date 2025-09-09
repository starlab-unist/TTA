public class HumanEval_95 {

    public static boolean checkDictCase(java.util.Map<String, Object> dict) {
        if (dict.isEmpty()) {
            return false;
        } else {
            String state = "start";
            for (String key : dict.keySet()) {
                if (!(key instanceof String)) {
                    state = "mixed";
                    break;
                }
                if (state.equals("start")) {
                    if (key.equals(key.toUpperCase())) {
                        state = "upper";
                    } else if (key.equals(key.toLowerCase())) {
                        state = "lower";
                    } else {
                        break;
                    }
                } else if ((state.equals("upper") && !key.equals(key.toUpperCase())) || (state.equals("lower") && !key.equals(key.toLowerCase()))) {
                    state = "mixed";
                    break;
                } else {
                    break;
                }
            }
            return state.equals("upper") || state.equals("lower");
        }
    }
}