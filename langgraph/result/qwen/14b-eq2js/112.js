function filterAndCheckPalindrome(inputString, charsToRemove) {
    const filteredString = Array.from(inputString).filter(char => !charsToRemove.includes(char)).join('');
    const isPalindrome = filteredString === filteredString.split('').reverse().join('');
    return [filteredString, isPalindrome];
}

// method name: reverseDelete -> filterAndCheckPalindrome
// parameter name: s -> inputString, c -> charsToRemove
// variable name: s -> filteredString