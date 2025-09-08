function antiShuffle(s) {
    return s.split(' ').map(word => word.split('').sort().join('')).join(' ');
}