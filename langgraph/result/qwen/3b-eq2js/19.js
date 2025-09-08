function arrangeNumerals(numberString) {
    const numeralToDigit = {
        'zero': 0,
        'one': 1,
        'two': 2,
        'three': 3,
        'four': 4,
        'five': 5,
        'six': 6,
        'seven': 7,
        'eight': 8,
        'nine': 9
    };

    // Split the input string and filter out any empty strings
    const numeralList = numberString.split(' ').filter(n => n);

    // Sort the list based on the mapped digit values
    numeralList.sort((a, b) => numeralToDigit[a] - numeralToDigit[b]);

    // Join the sorted numerals back into a single string
    return numeralList.join(' ');
}

// method name: sortNumbers -> arrangeNumerals
// parameter name: numbers -> numberString
// variable name: valueMap -> numeralToDigit, words -> numeralList
// used array methods for filtering and sorting
// joined the sorted list directly in the return statement