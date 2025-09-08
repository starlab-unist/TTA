function solve(N) {
    return (N.toString().split('').reduce((sum, digit) => sum + parseInt(digit, 10), 0)).toString(2);
}