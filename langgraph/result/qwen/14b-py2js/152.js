function compare(game, guess) {
    return game.map((x, i) => Math.abs(x - guess[i]));
}