function isPalindrome(string) {
    /** Test if given string is a palindrome */
    return string === string.split('').reverse().join('');
}

function makePalindrome(string) {
    if (!string) {
        return '';
    }

    let beginningOfSuffix = 0;

    while (!isPalindrome(string.substring(beginningOfSuffix))) {
        beginningOfSuffix += 1;
    }

    return string + string.substring(0, beginningOfSuffix).split('').reverse().join('');
}