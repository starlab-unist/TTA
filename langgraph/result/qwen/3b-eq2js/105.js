function arrangeByNumberName(numbers) {
    const numberNames = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    };
    const descendingNumbers = numbers.sort((a, b) => b - a);
    const namedNumbers = [];
    let index = 0;
    while (index < descendingNumbers.length) {
        const num = descendingNumbers[index];
        if (numberNames.hasOwnProperty(num)) {
            namedNumbers.push(numberNames[num]);
        }
        index++;
    }
    return namedNumbers;
}