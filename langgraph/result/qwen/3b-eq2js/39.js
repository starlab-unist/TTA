function findNthPrimeFibonacci(index) {
    function checkPrime(number) {
        if (number < 2) {
            return false;
        }
        let limit = Math.min(Math.sqrt(number) + 1, number - 1);
        let divisor = 2;
        while (divisor < limit) {
            if (number % divisor === 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }

    let fibonacciSequence = [0, 1];
    while (true) {
        let nextFib = fibonacciSequence[fibonacciSequence.length - 1] + fibonacciSequence[fibonacciSequence.length - 2];
        fibonacciSequence.push(nextFib);
        if (checkPrime(nextFib)) {
            index--;
        }
        if (index === 0) {
            return nextFib;
        }
    }
}