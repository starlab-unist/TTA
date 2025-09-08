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
        suffixStartIndex += 1;
    }

    return inputStr + inputStr.substring(0, suffixStartIndex).split('').reverse().join('');
}
// method name: is_palindrome -> checkPalindrome
// method name: make_palindrome -> constructPalindrome
// parameter name: string -> sequence, string -> inputStr
// variable name: beginning_of_suffix -> suffixStartIndex
// kept the logic and structure similar but renamed variables and methods for clarity