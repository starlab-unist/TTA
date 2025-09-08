function compare(game, guess) {
    return game.map((x, index) => Math.abs(x - guess[index]));
}