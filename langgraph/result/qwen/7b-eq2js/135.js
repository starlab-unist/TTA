// Function to find the first index where a decrease occurs in the sequence
function findFirstDecreaseIndex(arr) {
    let ind = -1; // Initialize index of the first decrease to -1
    let i = 1; // Start checking from the second element
    while (i < arr.length) {
        if (arr[i] < arr[i - 1]) {
            ind = i; // Update index to the current position
        }
        i++; // Move to the next element
    }
    return ind; // Return the index or -1 if no decrease is found
}