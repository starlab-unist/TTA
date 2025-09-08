function fib4(n) {
    let results = [0, 0, 2, 0];
    if (n < 4) {
        return results[n];
    }

    for (let i = 4; i <= n; i++) {
        results.push(results[i - 1] + results[i - 2] + results[i - 3] + results[i - 4]);
        results.shift();
    }

    return results[results.length - 1];
}