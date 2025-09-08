function checkDictCase(obj) {
    const keys = Object.keys(obj);
    if (keys.length === 0) {
        return false;
    } else {
        let state = "start";
        for (const key of keys) {
            if (typeof key !== 'string') {
                state = "mixed";
                break;
            }
            if (state === "start") {
                if (key === key.toUpperCase()) {
                    state = "upper";
                } else if (key === key.toLowerCase()) {
                    state = "lower";
                } else {
                    break;
                }
            } else if ((state === "upper" && key !== key.toUpperCase()) || (state === "lower" && key !== key.toLowerCase())) {
                state = "mixed";
                break;
            } else {
                break;
            }
        }
        return state === "upper" || state === "lower";
    }
}