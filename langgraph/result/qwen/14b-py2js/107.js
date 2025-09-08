function evenOddPalindrome(n) {
    function isPalindrome(num) {
        return num.toString() === num.toString().split('').reverse().join('');
    }

    let evenPalindromeCount = 0;
    let oddPalindromeCount = 0;

    for (let i = 1; i <= n; i++) {
        if (i % 2 === 1 && isPalindrome(i)) {
            oddPalindromeCount++;
        } else if (i % 2 === 0 && isPalindrome(i)) {
            evenPalindromeCount++;
        }
    }
    return [evenPalindromeCount, oddPalindromeCount];
}