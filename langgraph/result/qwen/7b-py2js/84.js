function solve(N) {
    return (N.toString().split('').reduce((acc, digit) => acc + parseInt(digit), 0)).toString(2);
}