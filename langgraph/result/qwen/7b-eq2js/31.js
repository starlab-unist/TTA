function checkPrime(n) {
    if (n < 2) {
        return false;
    }
    let divisor = 2;
    while (divisor < n - 1) {
        if (n % divisor === 0) {
            return false;
        }
        divisor += 1;
    }
    return true;
}

// method name: checkPrime
// parameter name: n
// replaced for loop with while loop
// introduced a new variable 'divisor' to iterate through potential divisors