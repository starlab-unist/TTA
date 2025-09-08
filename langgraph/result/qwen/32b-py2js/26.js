function removeDuplicates(numbers) {
    const countMap = new Map();
    
    // Count occurrences of each number
    numbers.forEach(number => {
        countMap.set(number, (countMap.get(number) || 0) + 1);
    });

    // Filter numbers that appear only once
    return numbers.filter(number => countMap.get(number) <= 1);
}