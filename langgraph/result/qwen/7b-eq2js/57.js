function checkMonotonicSequence(sequence) {
    let ascending = [...sequence];
    let descending = [...sequence];
    
    ascending.sort((a, b) => a - b);
    descending.sort((a, b) => b - a);
    
    if (JSON.stringify(sequence) === JSON.stringify(ascending) || JSON.stringify(sequence) === JSON.stringify(descending)) {
        return true;
    }
    return false;
}