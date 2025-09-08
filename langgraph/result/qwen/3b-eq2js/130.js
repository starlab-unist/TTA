function generateCustomSequence(length) {
    if (length === 0) {
        return [1];
    }

    let sequence = [1, 3];
    let index = 2;

    while (index <= length) {
        if (index % 2 === 0) {
            sequence.push(index / 2 + 1);
        } else {
            sequence.push(sequence[index - 1] + sequence[index - 2] + (index + 3) / 2);
        }
        index++;
    }

    return sequence;
}