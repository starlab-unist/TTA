function checkPalindrome(sequence) {
    let index = 0;
    const length = sequence.length;
    
    while (index < length / 2) {
        if (sequence[index] !== sequence[length - index - 1]) {
            return false;
        }
        index += 1;
    }
    return true;
}