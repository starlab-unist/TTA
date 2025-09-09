import java.util.Map;

class HumanEval_95 {
    public static boolean checkDictCase(Map<?, ?> dict) {
        if (dict.isEmpty()) {
            return false;
        } else {
            String state = "start";
            for (Object key : dict.keySet()) {

                if (!(key instanceof String)) {
                    state = "mixed";
                    break;
                }
                if (state.equals("start")) {
                    if (((String) key).equals(((String) key).toUpperCase())) {
                        state = "upper";
                    } else if (((String) key).equals(((String) key).toLowerCase())) {
                        state = "lower";
                    } else {
                        break;
                    }
                } else if ((state.equals("upper") && !((String) key).equals(((String) key).toUpperCase())) || 
                           (state.equals("lower") && !((String) key).equals(((String) key).toLowerCase()))) {
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