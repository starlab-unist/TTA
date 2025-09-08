function belowThreshold(arr, threshold) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] >= threshold) {
            return false;
        }
    }
    return true;
}