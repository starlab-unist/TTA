function calculateModifiedFibonacci(index) {
    if (index === 0 || index === 1) {
        return 0;
    } else if (index === 2) {
        return 1;
    } else {
        return calculateModifiedFibonacci(index - 1) + 
               calculateModifiedFibonacci(index - 2) + 
               calculateModifiedFibonacci(index - 3);
    }
}