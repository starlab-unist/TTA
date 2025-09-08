function calculateFibonacci(sequenceIndex) {
    if (sequenceIndex === 0) {
        return 0;
    } else if (sequenceIndex === 1) {
        return 1;
    }

    let previous = 0, current = 1;
    let index = 2;
    while (index <= sequenceIndex) {
        [previous, current] = [current, previous + current];
        index += 1;
    }

    return current;
}