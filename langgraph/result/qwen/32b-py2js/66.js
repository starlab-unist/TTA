function digitSum(s) {
    if (s === "") return 0;
    return [...s].reduce((sum, char) => char >= 'A' && char <= 'Z' ? sum + char.charCodeAt(0) : sum, 0);
}