function calculateFibonacci(sequenceIndex) {
    if (sequenceIndex === 0) {
        return 0;
    } else if (sequenceIndex === 1) {
        return 1;
    }

    let previous = 0;
    let current = 1;
    let index = 2;

    while (index <= sequenceIndex) {
        [previous, current] = [current, previous + current];
        index++;
    }

    return current;
}

// method name: fib -> calculateFibonacci
// parameter name: n -> sequenceIndex
// replaced recursion with an iterative approach using a while loop
// introduced variables: previous, current, index to manage the iteration