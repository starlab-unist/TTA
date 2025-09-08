function checkPalindrome(sequence) {
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