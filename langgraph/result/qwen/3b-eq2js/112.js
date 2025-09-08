function reverseDelete(inputString, charsToRemove) {
    const filteredString = inputString.split('').filter(character => !charsToRemove.includes(character)).join('');
    const isPalindrome = filteredString === filteredString.split('').reverse().join('');
    return [filteredString, isPalindrome];
}