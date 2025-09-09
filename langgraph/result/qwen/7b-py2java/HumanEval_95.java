import java.util.Map;

public class HumanEval_95 {
    public static boolean checkDictCase(Map<Object, Object> dict) {
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
                    if (((String) key).toUpperCase().equals(key.toString())) {
                        state = "upper";
                    } else if (((String) key).toLowerCase().equals(key.toString())) {
                        state = "lower";
                    } else {
                        break;
                    }
                } else if ((state.equals("upper") && !((String) key).toUpperCase().equals(key.toString())) || 
                          (state.equals("lower") && !((String) key).toLowerCase().equals(key.toString()))) {
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