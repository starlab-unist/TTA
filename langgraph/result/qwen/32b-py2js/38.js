function encodeCyclic(s) {
    /**
     * Returns encoded string by cycling groups of three characters.
     */
    // Split string into groups. Each of length 3.
    const groups = [];
    for (let i = 0; i < Math.ceil(s.length / 3); i++) {
        groups.push(s.substring(3 * i, Math.min(3 * i + 3, s.length)));
    }
    // Cycle elements in each group. Unless group has fewer elements than 3.
    const cycledGroups = groups.map(group => 
        group.length === 3 ? group.slice(1) + group[0] : group
    );
    return cycledGroups.join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}