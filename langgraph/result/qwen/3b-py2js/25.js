function factorize(n) {
    const fact = [];
    let i = 2;
    while (i <= Math.sqrt(n) + 1) {
        if (n % i === 0) {
            fact.push(i);
            n /= i;
        } else {
            i++;
        }
    }

    if (n > 1) {
        fact.push(n);
    }
    return fact;
}