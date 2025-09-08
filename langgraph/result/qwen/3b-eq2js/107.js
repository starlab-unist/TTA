function countEvenOddPalindromes(limit) {
    function checkPalindrome(number) {
        return number.toString() === number.toString().split('').reverse().join('');
    }

    let evenCount = 0;
    let oddCount = 0;

    let currentNumber = 1;
    while (currentNumber <= limit) {
        if (currentNumber % 2 !== 0 && checkPalindrome(currentNumber)) {
            oddCount++;
        } else if (currentNumber % 2 === 0 && checkPalindrome(currentNumber)) {
            evenCount++;
        }
        currentNumber++;
    }

    return [evenCount, oddCount];
}