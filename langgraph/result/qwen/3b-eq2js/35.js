function findMaximumValue(elements) {
    let currentMax = elements[0];
    let index = 1;
    while (index < elements.length) {
        if (elements[index] > currentMax) {
            currentMax = elements[index];
        }
        index++;
    }
    return currentMax;
}