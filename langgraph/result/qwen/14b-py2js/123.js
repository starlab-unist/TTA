function getOddCollatz(n) {
    let oddCollatz;
    if (n % 2 === 0) {
        oddCollatz = [];
    } else {
        oddCollatz = [n];
    }
    while (n > 1) {
        if (n % 2 === 0) {
            n = n / 2;
        } else {
            n = n * 3 + 1;
        }
        
        if (n % 2 === 1) {
            oddCollatz.push(parseInt(n));
        }
    }
    return oddCollatz.sort((a, b) => a - b);
}