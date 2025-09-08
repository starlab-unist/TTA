function isPalindrome(n) {
    return String(n) === String(n).split('').reverse().join('');
}

function evenOddPalindrome(n) {
    let evenPalindromeCount = 0;
    let oddPalindromeCount = 0;

    for (let i = 1; i <= n; i++) {
        if (i % 2 === 1 && isPalindrome(i)) {
            oddPalindromeCount += 1;
        } else if (i % 2 === 0 && isPalindrome(i)) {
            evenPalindromeCount += 1;
        }
    }
    return [evenPalindromeCount, oddPalindromeCount];
}