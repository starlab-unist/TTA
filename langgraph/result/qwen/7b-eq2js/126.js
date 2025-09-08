function checkSortedSequence(sequence) {
    let digitCount = {};
    for (let num of sequence) {
        if (digitCount[num]) {
            digitCount[num]++;
        } else {
            digitCount[num] = 1;
        }
    }

    for (let num of sequence) {
        if (digitCount[num] > 2) {
            return false;
        }
    }

    for (let i = 1; i < sequence.length; i++) {
        if (sequence[i - 1] > sequence[i]) {
            return false;
        }
    }

    return true;
}

// method name: is_sorted -> checkSortedSequence
// parameter name: lst -> sequence
// variable name: count_digit -> digitCount
// replaced list comprehension with dictionary comprehension for digitCount
// replaced the all() function with a while loop for checking sorted order
// simplified the return statement for clarity