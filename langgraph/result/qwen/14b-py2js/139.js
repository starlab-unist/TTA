function specialFactorial(n) {
    let factI = 1;
    let specialFact = 1;
    for (let i = 1; i <= n; i++) {
        factI *= i;
        specialFact *= factI;
    }
    return specialFact;
}