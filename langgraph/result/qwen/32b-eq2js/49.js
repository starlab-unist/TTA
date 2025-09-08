function calculateModularExponentiation(baseCount, modulus) {
    let result = 1;
    let index = 0;
    while (index < baseCount) {
        result = (2 * result) % modulus;
        index += 1;
    }
    return result;
}