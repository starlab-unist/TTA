function incrementElements(l) {
    let result = [];
    let index = 0;
    while (index < l.length) {
        result.push(l[index] + 1);
        index += 1;
    }
    return result;
}