function reverseDelete(s, c) {
    s = s.split('').filter(char => !c.includes(char)).join('');
    return [s, s === s.split('').reverse().join('')];
}