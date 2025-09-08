function hexKey(num) {
    const primes = new Set(['2', '3', '5', '7', 'B', 'D']);
    let total = 0;
    for (let i = 0; i < num.length; i++) {
        if (primes.has(num[i])) {
            total += 1;
        }
    }
    return total;
}