function largestSmallestIntegers(lst) {
    const smallest = lst.filter(x => x < 0);
    const largest = lst.filter(x => x > 0);
    return [smallest.length ? Math.max(...smallest) : null, largest.length ? Math.min(...largest) : null];
}