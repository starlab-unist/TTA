function stringSequence(n) {
    return Array.from({ length: n + 1 }, (_, i) => i.toString()).join(' ');
}