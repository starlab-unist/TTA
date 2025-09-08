function makeAPile(n) {
    const pile = [];
    for (let i = 0; i < n; i++) {
        pile.push(n + 2 * i);
    }
    return pile;
}