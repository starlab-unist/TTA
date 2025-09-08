function calculateCustomFibonacci(n) {
    let sequence = [0, 0, 2, 0];
    if (n < 4) {
        return sequence[n];
    }

    let currentIndex = 4;
    while (currentIndex <= n) {
        let nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
        sequence.shift();
        sequence.push(nextValue);
        currentIndex += 1;
    }

    return sequence[3];
}