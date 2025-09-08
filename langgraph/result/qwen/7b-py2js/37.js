function sortEven(arr) {
    let evens = arr.filter((_, index) => index % 2 === 0).sort((a, b) => a - b);
    let odds = arr.filter((_, index) => index % 2 !== 0);
    let ans = [];
    for (let i = 0; i < Math.min(evens.length, odds.length); i++) {
        ans.push(evens[i], odds[i]);
    }
    if (evens.length > odds.length) {
        ans.push(evens[evens.length - 1]);
    }
    return ans;
}