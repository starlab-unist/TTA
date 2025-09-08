function encodeCyclic(s) {
    const groups = s.match(/.{1,3}/g);
    return groups.map(group => group.length === 3 ? group.slice(1) + group[0] : group).join('');
}

function decodeCyclic(s) {
    return encodeCyclic(encodeCyclic(s));
}