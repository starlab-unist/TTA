function calculateModularExponentiation(n, p) {
    let ret = 1;
    let i = 0;
    while (i < n) {
        ret = (2 * ret) % p;
        i += 1;
    }
    return ret;
}

// function name: calculateModularExponentiation
// parameter names: n (base_count), p (modulus)
// variable names: ret (result), i (index)
// changed for loop to while loop