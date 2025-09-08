function sortEven(arr) {
    const evens = arr.filter((_, index) => index % 2 === 0);
    const odds = arr.filter((_, index) => index % 2 !== 0);
    evens.sort((a, b) => a - b);
    const ans = [];
    const maxLength = Math.min(evens.length, odds.length);
    for (let i = 0; i < maxLength; i++) {
        ans.push(evens[i], odds[i]);
    }
    if (evens.length > odds.length) {
        ans.push(evens[evens.length - 1]);
    }
    return ans;
}