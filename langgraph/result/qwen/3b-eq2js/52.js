function allElementsUnderLimit(elements, threshold) {
    let index = 0;
    while (index < elements.length) {
        if (elements[index] >= threshold) {
            return false;
        }
        index++;
    }
    return true;
}