function removeDuplicates(numbers) {
    const count = {};
    numbers.forEach(num => {
        count[num] = (count[num] || 0) + 1;
    });
    return numbers.filter(num => count[num] <= 1);
}