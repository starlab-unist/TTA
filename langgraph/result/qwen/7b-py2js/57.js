function monotonic(arr) {
    if (arr.join('') === arr.slice().sort((a, b) => a - b).join('') || arr.join('') === arr.slice().sort((a, b) => b - a).join('')) {
        return true;
    }
    return false;
}