function anti_shuffle(s) {
    return s.split(' ').map(i => [...i].sort().join('')).join(' ');
}