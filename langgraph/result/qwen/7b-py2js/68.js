function pluck(arr) {
    if (arr.length === 0) return [];
    const evens = arr.filter(x => x % 2 === 0);
    if (evens.length === 0) return [];
    const minEven = Math.min(...evens);
    const index = arr.indexOf(minEven);
    return [minEven, index];
}