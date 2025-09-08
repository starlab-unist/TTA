function filterAndCheckPalindrome(inputString, charsToRemove) {
    let filteredString = '';
    for (let character of inputString) {
        if (!charsToRemove.includes(character)) {
            filteredString += character;
        }
    }
    let isPalindrome = filteredString === filteredString.split('').reverse().join('');
    return [filteredString, isPalindrome];
}

// method name: reverseDelete -> filterAndCheckPalindrome
// parameter name: s -> inputString, c -> charsToRemove
// variable name: s -> filteredString
// replaced list comprehension with a generator expression for clarity
// separated palindrome check into a separate variable for readability