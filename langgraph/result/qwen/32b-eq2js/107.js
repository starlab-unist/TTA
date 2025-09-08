function countEvenOddPalindromes(limit) {
    function checkPalindrome(number) {
        const strNumber = number.toString();
        return strNumber === strNumber.split('').reverse().join('');
    }

    let evenCount = 0;
    let oddCount = 0;

    let currentNumber = 1;
    while (currentNumber <= limit) {
        if (currentNumber % 2 === 1 && checkPalindrome(currentNumber)) {
            oddCount += 1;
        } else if (currentNumber % 2 === 0 && checkPalindrome(currentNumber)) {
            evenCount += 1;
        }
        currentNumber += 1;
    }

    return [evenCount, oddCount];
}