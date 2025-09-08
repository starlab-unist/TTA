function computeDerivative(xs) {
    let result = [];
    let index = 1;
    while (index < xs.length) {
        result.push(index * xs[index]);
        index += 1;
    }
    return result;
}
// method name: derivative -> computeDerivative
// parameter name: xs -> coefficients
// replaced list comprehension with while loop
// used an explicit index variable to iterate through the array
// started the loop from index 1 to skip the first element