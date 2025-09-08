function alternateSortSequence(sequence) {
    let result = [];
    let toggle = true;
    while (sequence.length > 0) {
        let selectedValue = toggle ? Math.min(...sequence) : Math.max(...sequence);
        result.push(selectedValue);
        sequence = sequence.filter(value => value !== selectedValue);
        toggle = !toggle;
    }
    return result;
}