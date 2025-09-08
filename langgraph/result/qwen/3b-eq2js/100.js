function constructStack(size) {
    let pile = [];
    let index = 0;
    while (index < size) {
        pile.push(size + 2 * index);
        index += 1;
    }
    return pile;
}