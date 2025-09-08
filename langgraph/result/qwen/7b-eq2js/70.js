function alternateSortSequence(sequence) {
    let result = [];
    let toggle = true;
    while (sequence.length > 0) {
        let selectedValue = toggle ? Math.min(...sequence) : Math.max(...sequence);
        result.push(selectedValue);
        sequence.splice(sequence.indexOf(selectedValue), 1);
        toggle = !toggle;
    }
    return result;
}

// method name: strange_sort_list -> alternateSortSequence
// parameter name: lst -> sequence
// variable name: res -> result, switch -> toggle
// replaced inline conditional with a separate line for clarity
// kept the core logic of alternating between min and max