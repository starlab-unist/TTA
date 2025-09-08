function removeDuplicates(numbers) {
    const counts = {};
    numbers.forEach(number => {
        counts[number] = (counts[number] || 0) + 1;
    });
    return numbers.filter(number => counts[number] <= 1);
}