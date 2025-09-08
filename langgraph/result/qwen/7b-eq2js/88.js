function arrangeSequence(array) {
    if (!array.length) {
        return [];
    }
    
    let reverseOrder = (array[0] + array[array.length - 1]) % 2 === 0;
    return array.sort((a, b) => reverseOrder ? b - a : a - b);
}