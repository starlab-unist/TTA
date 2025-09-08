function filterAndCheckPalindrome(inputString, charsToRemove) {
    const filteredString = [...inputString].filter(character => !charsToRemove.includes(character)).join('');
    const isPalindrome = filteredString === filteredString.split('').reverse().join('');
    return [filteredString, isPalindrome];
}