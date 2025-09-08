function calculateUppercaseAsciiSum(s) {
    if (s === "") {
        return 0;
    }
    
    let total = 0;
    for (let i = 0; i < s.length; i++) {
        const character = s[i];
        if (character >= 'A' && character <= 'Z') {
            total += character.charCodeAt(0);
        }
    }
    
    return total;
}