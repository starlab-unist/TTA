function rearrangeEvenOdd(numbers) {
    let evenElements = numbers.filter((_, index) => index % 2 === 0);
    let oddElements = numbers.filter((_, index) => index % 2 !== 0);
    evenElements.sort((a, b) => a - b);
    let result = [];

    let index = 0;
    while (index < oddElements.length) {
        result.push(evenElements[index]);
        result.push(oddElements[index]);
        index++;
    }

    if (evenElements.length > oddElements.length) {
        result.push(evenElements[evenElements.length - 1]);
    }

    return result;
}