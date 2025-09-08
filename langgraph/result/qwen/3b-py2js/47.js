function median(l) {
    l.sort((a, b) => a - b);
    const mid = Math.floor(l.length / 2);
    if (l.length % 2 === 1) {
        return l[mid];
    } else {
        return (l[mid - 1] + l[mid]) / 2;
    }
}