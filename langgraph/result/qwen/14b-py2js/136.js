function largestSmallestIntegers(lst) {
    const smallest = lst.filter(x => x < 0);
    const largest = lst.filter(x => x > 0);
    return (smallest.length > 0 ? Math.max(...smallest) : null, largest.length > 0 ? Math.min(...largest) : null);
}