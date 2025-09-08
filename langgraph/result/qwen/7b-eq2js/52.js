function allElementsUnderLimit(elements, threshold) {
    let index = 0;
    while (index < elements.length) {
        if (elements[index] >= threshold) {
            return false;
        }
        index += 1;
    }
    return true;
}

// method name: belowThreshold -> allElementsUnderLimit
// parameter name: l -> elements, t -> threshold
// replaced for loop with while loop
// used index to iterate through the list
// kept the return values the same