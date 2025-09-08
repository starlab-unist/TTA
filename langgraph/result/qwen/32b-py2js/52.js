function belowThreshold(arr, threshold) {
    for (let e of arr) {
        if (e >= threshold) {
            return false;
        }
    }
    return true;
}