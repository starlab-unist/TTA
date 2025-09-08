function sortEven(l) {
    const evens = l.filter((_, i) => i % 2 === 0);
    const odds = l.filter((_, i) => i % 2 !== 0);
    evens.sort();
    let ans = [];
    for (let i = 0; i < Math.min(evens.length, odds.length); i++) {
        ans.push(evens[i], odds[i]);
    }
    if (evens.length > odds.length) {
        ans.push(evens[evens.length - 1]);
    }
    return ans;
}