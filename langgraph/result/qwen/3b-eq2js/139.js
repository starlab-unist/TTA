function computeSpecialProduct(n) {
    let currentFactorial = 1;
    let cumulativeProduct = 1;
    let index = 1;

    while (index <= n) {
        currentFactorial *= index;
        cumulativeProduct *= currentFactorial;
        index++;
    }

    return cumulativeProduct;
}