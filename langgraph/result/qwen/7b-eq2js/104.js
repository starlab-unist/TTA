function filterOddDigitNumbers(x) {
    let odd_digit_elements = [];
    let iterator = x[Symbol.iterator]();
    
    while (true) {
        try {
            let number = iterator.next().value;
            if (number !== undefined && Array.from(String(number), Number).every(digit => digit % 2 !== 0)) {
                odd_digit_elements.push(number);
            }
        } catch (e) {
            break;
        }
    }
    
    return odd_digit_elements.sort((a, b) => a - b);
}