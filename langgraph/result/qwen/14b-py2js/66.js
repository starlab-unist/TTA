function digitSum(s) {
    if (s === "") return 0;
    return Array.from(s).reduce((sum, char) => {
        return sum + (char >= 'A' && char <= 'Z' ? char.charCodeAt(0) : 0);
    }, 0);
}