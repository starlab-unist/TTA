function encodeCyclic(s) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Split string into groups. Each of length 3.
    const groups = [];
    for (let i = 0; i < Math.ceil(s.length / 3); i++) {
        groups.push(s.substring(i * 3, Math.min((i * 3 + 3), s.length)));
    }
    // Cycle elements in each group. Unless group has fewer elements than 3.
    for (let i = 0; i < groups.length; i++) {
        if (groups[i].length === 3) {
            groups[i] = groups[i].substring(1) + groups[i][0];
        }
    }
    return groups.join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}