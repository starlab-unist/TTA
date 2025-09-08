function isPalindrome(string) {
    return string === string.split('').reverse().join('');
}

function makePalindrome(string) {
    if (!string) {
        return '';
    }

    let beginningOfSuffix = 0;

    while (!isPalindrome(string.substring(beginningOfSuffix))) {
        beginningOfSuffix++;
    }

    return string + string.substring(0, beginningOfSuffix).split('').reverse().join('');
}