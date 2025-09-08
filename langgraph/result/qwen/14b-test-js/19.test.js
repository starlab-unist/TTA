// Source Code
function sortNumbers(numbers) {
    const valueMap = {
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
    return numbers.split(' ')
        .filter(x => x)
        .sort((a, b) => valueMap[a] - valueMap[b])
        .join(' ');
}

// Transformed Code (Semantically Equivalent)
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
    const numeralList = numberString.split(' ').filter(numeral => numeral);

    // Sort the list based on the mapped digit values
    const sortedNumerals = numeralList.sort((a, b) => numeralToDigit[a] - numeralToDigit[b]);

    // Join the sorted numerals back into a single string
    return sortedNumerals.join(' ');
}

// Test Cases
describe('sortNumbers vs arrangeNumerals equivalence tests', () => {
    const testCases = [
        "three one four one five nine",
        "nine eight seven six five four three two one zero",
        "zero zero zero",
        "one two three four five six seven eight nine",
        "four four four four four",
        "five six seven eight nine zero one two three",
        "two four six eight",
        "one three five seven nine",
        "",
        "nine"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(sortNumbers(inputText)).toBe(arrangeNumerals(inputText))
    });
});