function findMaximumValue(l) {
    let m = l[0];
    let index = 1;
    while (index < l.length) {
        if (l[index] > m) {
            m = l[index];
        }
        index += 1;
    }
    return m;
}

// method name: maxElement -> findMaximumValue
// parameter name: l -> elements
// variable name: m -> currentMax
// changed for loop to while loop
// introduced index variable to iterate through the list