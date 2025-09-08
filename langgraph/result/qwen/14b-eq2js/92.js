function checkSumOfTwoEqualsThird(a, b, c) {
    if ([a, b, c].every(Number.isInteger)) {
        if (a + b === c || a + c === b || b + c === a) {
            return true;
        }
        return false;
    }
    return false;
}

// method name: any_int -> checkSumOfTwoEqualsThird
// parameter names: x -> a, y -> b, z -> c
// replaced individual typeof checks with Array.prototype.every() and Number.isInteger
// maintained the same logic and output structure