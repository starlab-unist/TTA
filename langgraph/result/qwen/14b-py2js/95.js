function checkDictCase(dict) {
    if (Object.keys(dict).length === 0) {
        return false;
    } else {
        let state = "start";
        for (let key of Object.keys(dict)) {
            if (typeof key !== "string") {
                state = "mixed";
                break;
            }
            if (state === "start") {
                if (key.toUpperCase() === key) {
                    state = "upper";
                } else if (key.toLowerCase() === key) {
                    state = "lower";
                } else {
                    break;
                }
            } else if ((state === "upper" && key.toUpperCase() !== key) || (state === "lower" && key.toLowerCase() !== key)) {
                state = "mixed";
                break;
            } else {
                break;
            }
        }
        return state === "upper" || state === "lower";
    }
}