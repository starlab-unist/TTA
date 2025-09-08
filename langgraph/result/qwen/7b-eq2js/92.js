function checkSumOfTwoEqualsThird(x, y, z) {
    if (typeof x === 'number' && typeof y === 'number' && typeof z === 'number') {
        if ((x + y === z) || (x + z === y) || (y + z === x)) {
            return true;
        }
        return false;
    }
    return false;
}

// method name: anyInt -> checkSumOfTwoEqualsThird
// parameter names: x -> a, y -> b, z -> c
// replaced individual typeof checks with a single condition
// maintained the same logic and output structure