function checkMonotonicSequence(sequence) {
    const ascending = [...sequence];
    const descending = [...sequence];
    
    ascending.sort((a, b) => a - b);
    descending.sort((a, b) => b - a);
    
    if (arraysEqual(sequence, ascending) || arraysEqual(sequence, descending)) {
        return true;
    }
    return false;
}

function arraysEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) return false;
    for (let i = 0; i < arr1.length; i++) {
        if (arr1[i] !== arr2[i]) return false;
    }
    return true;
}