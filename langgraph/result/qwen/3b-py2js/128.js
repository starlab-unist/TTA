function prodSigns(arr) {
    if (!arr.length) return null;
    let prod = 0;
    if (arr.includes(0)) prod = 0;
    else prod = Math.pow(-1, arr.filter(x => x < 0).length);
    return prod * arr.map(Math.abs).reduce((acc, curr) => acc + curr, 0);
}