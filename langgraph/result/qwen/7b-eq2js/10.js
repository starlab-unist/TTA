function checkPalindrome(sequence) {
    /** Determine if the provided sequence is a palindrome */
    return sequence === sequence.split('').reverse().join('');
}

function constructPalindrome(inputStr) {
    if (!inputStr) {
        return '';
    }

    let suffixStartIndex = 0;

    while (!checkPalindrome(inputStr.substring(suffixStartIndex))) {
        suffixStartIndex++;
    }

    return inputStr + inputStr.substring(0, suffixStartIndex).split('').reverse().join('');
}
// method name: checkPalindrome -> checkPalindrome
// method name: constructPalindrome -> constructPalindrome
// parameter name: inputStr -> inputStr
// variable name: suffixStartIndex -> suffixStartIndex
// kept the logic and structure similar but renamed variables and methods for clarity