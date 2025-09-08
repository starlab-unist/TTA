function isPalindrome(str) {
    return str === str.split('').reverse().join('');
}

function makePalindrome(str) {
    if (!str) {
        return '';
    }

    let beginningOfSuffix = 0;

    while (!isPalindrome(str.substring(beginningOfSuffix))) {
        beginningOfSuffix++;
    }

    return str + str.substring(0, beginningOfSuffix).split('').reverse().join('');
}