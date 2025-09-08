function constructStack(n) {
    let pile = [];
    let index = 0;
    while (index < n) {
        pile.push(n + 2 * index);
        index++;
    }
    return pile;
}