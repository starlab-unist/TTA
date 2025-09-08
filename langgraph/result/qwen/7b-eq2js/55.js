function calculateFibonacci(n) {
    if (n === 0) {
        return 0;
    } else if (n === 1) {
        return 1;
    }

    let previous = 0, current = 1, index = 2;
    while (index <= n) {
        [previous, current] = [current, previous + current];
        index++;
    }

    return current;
}