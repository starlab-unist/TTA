public boolean evaluateDictionaryKeysCasing(java.util.Map<String, ?> dict) {
    if (dict.isEmpty()) {
        return false;
    }

    String state = null;
    for (String key : dict.keySet()) {
        if (!key.matches("[a-zA-Z]+")) {
            return false;
        }

        if (state == null) {
            if (key.equals(key.toUpperCase())) {
                state = "UPPER";
            } else if (key.equals(key.toLowerCase())) {
                state = "LOWER";
            } else {
                return false;
            }
        } else {
            if ((state.equals("UPPER") && !key.equals(key.toUpperCase())) || 
                (state.equals("LOWER") && !key.equals(key.toLowerCase()))) {
                return false;
            }
        }
    }

    return state != null && (state.equals("UPPER") || state.equals("LOWER"));
}