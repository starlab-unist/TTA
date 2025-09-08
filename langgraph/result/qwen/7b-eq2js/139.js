function computeSpecialProduct(n) {
    let currentFactorial = 1;
    let cumulativeProduct = 1;
    let index = 1;

    while (index <= n) {
        currentFactorial *= index;
        cumulativeProduct *= currentFactorial;
        index += 1;
    }

    return cumulativeProduct;
}

// method name: computeSpecialProduct
// parameter name: n (remained the same as it's descriptive)
// variable name: currentFactorial -> currentFactorial, cumulativeProduct -> cumulativeProduct
// changed for loop to while loop
// introduced index variable to replace loop variable i
// incremented index manually within the loop