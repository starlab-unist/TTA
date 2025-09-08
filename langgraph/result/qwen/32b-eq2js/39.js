function findNthPrimeFibonacci(index) {
    function checkPrime(number) {
        if (number < 2) {
            return false;
        }
        const limit = Math.min(Math.floor(Math.sqrt(number)) + 1, number - 1);
        let divisor = 2;
        while (divisor < limit) {
            if (number % divisor === 0) {
                return false;
            }
            divisor += 1;
        }
        return true;
    }

    const fibonacciSequence = [0, 1];
    while (true) {
        const nextFib = fibonacciSequence[fibonacciSequence.length - 1] + fibonacciSequence[fibonacciSequence.length - 2];
        fibonacciSequence.push(nextFib);
        if (checkPrime(nextFib)) {
            index -= 1;
        }
        if (index === 0) {
            return nextFib;
        }
    }
}