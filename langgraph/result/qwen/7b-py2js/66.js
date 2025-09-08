function digitSum(s) {
    if (s === "") return 0;
    return [...s].reduce((sum, char) => {
        if (char >= 'A' && char <= 'Z') {
            return sum + char.charCodeAt(0);
        }
        return sum;
    }, 0);
}