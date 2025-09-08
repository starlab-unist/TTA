function digitSum(s) {
    if (s === "") return 0;
    return Array.from(s).reduce((acc, char) => acc + (char === char.toUpperCase() ? char.charCodeAt(0) : 0), 0);
}