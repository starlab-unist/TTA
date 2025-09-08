function encodeCyclic(s) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Split string into groups of length 3.
    let groups = [];
    for (let i = 0; i < s.length; i += 3) {
        groups.push(s.slice(i, Math.min(i + 3, s.length)));
    }
    // Cycle elements in each group unless group has fewer than 3 elements.
    groups = groups.map(group => group.length === 3 ? group.slice(1) + group[0] : group);
    return groups.join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}