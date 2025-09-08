function rearrangeEvenOdd(numbers) {
    const evenElements = numbers.filter((_, index) => index % 2 === 0);
    const oddElements = numbers.filter((_, index) => index % 2 !== 0);
    evenElements.sort((a, b) => a - b);
    const result = [];

    let index = 0;
    while (index < oddElements.length) {
        result.push(evenElements[index]);
        result.push(oddElements[index]);
        index += 1;
    }

    if (evenElements.length > oddElements.length) {
        result.push(evenElements[evenElements.length - 1]);
    }

    return result;
}