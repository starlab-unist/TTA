function removeDuplicates(numbers) {
    const c = {};
    numbers.forEach(n => {
        c[n] = (c[n] || 0) + 1;
    });
    return numbers.filter(n => c[n] <= 1);
}