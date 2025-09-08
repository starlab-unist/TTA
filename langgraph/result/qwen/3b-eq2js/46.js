function calculateCustomFibonacci(index) {
    let sequence = [0, 0, 2, 0];
    if (index < 4) {
        return sequence[index];
    }

    let currentIndex = 4;
    while (currentIndex <= index) {
        let nextValue = sequence[sequence.length - 1] + sequence[sequence.length - 2] + sequence[sequence.length - 3] + sequence[sequence.length - 4];
        sequence.push(nextValue);
        sequence.shift();
        currentIndex++;
    }

    return sequence[sequence.length - 1];
}