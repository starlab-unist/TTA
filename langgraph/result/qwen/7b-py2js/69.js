function search(arr) {
    let maxVal = Math.max(...arr);
    let freq = new Array(maxVal + 1).fill(0);

    for (let i of arr) {
        freq[i]++;
    }

    let ans = -1;
    for (let i = 1; i < freq.length; i++) {
        if (freq[i] >= i) {
            ans = i;
        }
    }

    return ans;
}