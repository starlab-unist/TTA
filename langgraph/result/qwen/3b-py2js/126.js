function isSorted(lst) {
    const countDigit = {};
    for (let i of lst) {
        countDigit[i] = (countDigit[i] || 0) + 1;
    }
    if (Object.values(countDigit).some(count => count > 2)) {
        return false;
    }
    for (let i = 1; i < lst.length; i++) {
        if (lst[i - 1] > lst[i]) {
            return false;
        }
    }
    return true;
}