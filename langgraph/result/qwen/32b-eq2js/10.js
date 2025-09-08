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