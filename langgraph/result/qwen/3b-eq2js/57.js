function checkMonotonicSequence(sequence) {
    let ascending = [...sequence];
    let descending = [...sequence];

    ascending.sort((a, b) => a - b);
    descending.sort((a, b) => b - a);

    if (sequence.every((value, index) => value === ascending[index])) {
        return true;
    }
    if (sequence.every((value, index) => value === descending[index])) {
        return true;
    }
    return false;
}

console.log(checkMonotonicSequence([1, 2, 2, 3])); // true
console.log(checkMonotonicSequence([3, 2, 2, 1])); // true
console.log(checkMonotonicSequence([1, 3, 2]));   // false