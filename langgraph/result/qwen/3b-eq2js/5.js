function weaveNumbers(sequence, separator) {
    if (!sequence.length) {
        return [];
    }

    let interleaved = [];
    let index = 0;

    while (index < sequence.length - 1) {
        interleaved.push(sequence[index], separator);
        index++;
    }

    interleaved.push(sequence[sequence.length - 1]);

    return interleaved;
}