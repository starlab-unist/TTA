function alternateSortSequence(sequence) {
    const result = [];
    let toggle = true;
    while (sequence.length > 0) {
        const selectedValue = toggle ? Math.min(...sequence) : Math.max(...sequence);
        result.push(selectedValue);
        sequence.splice(sequence.indexOf(selectedValue), 1);
        toggle = !toggle;
    }
    return result;
}