function calculateSignedSum(numbers) {
    if (!numbers.length) {
        return null;
    }

    const negativeCount = numbers.filter(num => num < 0).length;
    const containsZero = numbers.includes(0);

    let sign = 0;
    if (containsZero) {
        sign = 0;
    } else {
        sign = Math.pow(-1, negativeCount);
    }

    const totalSum = numbers.reduce((acc, num) => acc + Math.abs(num), 0);

    return sign * totalSum;
}