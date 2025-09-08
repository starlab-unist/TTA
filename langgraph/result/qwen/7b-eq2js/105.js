function arrangeByNumberName(arr) {
    const numberNames = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine"
    };
    const descendingNumbers = arr.sort((a, b) => b - a);
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

// method name: by_length -> arrangeByNumberName
// parameter name: arr -> numbers
// variable name: dic -> numberNames, sorted_arr -> descendingNumbers, new_arr -> namedNumbers
// replaced for loop with while loop
// used sort function with comparator for sorting in reverse order
// added explicit check for num in numberNames object using hasOwnProperty method