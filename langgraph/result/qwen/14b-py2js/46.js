function fib4(n) {
    const results = [0, 0, 2, 0];
    if (n < 4) {
        return results[n];
    }

    for (let i = 4; i <= n; i++) {
        results.push(results[results.length - 1] + results[results.length - 2] + results[results.length - 3] + results[results.length - 4]);
        results.shift();
    }

    return results[results.length - 1];
}