function weaveNumbers(sequence, separator) {
    if (sequence.length === 0) {
        return [];
    }

    const interleaved = [];
    let index = 0;

    while (index < sequence.length - 1) {
        interleaved.push(sequence[index], separator);
        index += 1;
    }

    interleaved.push(sequence[sequence.length - 1]);

    return interleaved;
}