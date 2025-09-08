function calculateCustomFibonacci(index) {
    let sequence = [0, 0, 2, 0];
    if (index < 4) {
        return sequence[index];
    }

    let currentIndex = 4;
    while (currentIndex <= index) {
        let nextValue = sequence[3] + sequence[2] + sequence[1] + sequence[0];
        sequence.push(nextValue);
        sequence.shift();
        currentIndex += 1;
    }

    return sequence[3];
}