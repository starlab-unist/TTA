// Source Code
function fixSpaces(text) {
    let newText = "";
    let i = 0;
    let start = 0, end = 0;
    while (i < text.length) {
        if (text[i] === " ") {
            end += 1;
        } else {
            if (end - start > 2) {
                newText += "-" + text[i];
            } else if (end - start > 0) {
                newText += "_".repeat(end - start) + text[i];
            } else {
                newText += text[i];
            }
            start = end = i + 1;
        }
        i += 1;
    }
    if (end - start > 2) {
        newText += "-";
    } else if (end - start > 0) {
        newText += "_";
    }
    return newText;
}

// Transformed Code (Semantically Equivalent)
function adjustWhitespace(inputString) {
    let result = "";
    let index = 0;
    let begin = 0, finish = 0;
    while (index < inputString.length) {
        if (inputString[index] === " ") {
            finish += 1;
        } else {
            const spaceCount = finish - begin;
            if (spaceCount > 2) {
                result += "-" + inputString[index];
            } else if (spaceCount > 0) {
                result += "_".repeat(spaceCount) + inputString[index];
            } else {
                result += inputString[index];
            }
            begin = index + 1;
            finish = index + 1;
        }
        index += 1;
    }
    const finalSpaceCount = finish - begin;
    if (finalSpaceCount > 2) {
        result += "-";
    } else if (finalSpaceCount > 0) {
        result += "_";
    }
    return result;
}

// Test Cases
describe('fixSpaces vs adjustWhitespace equivalence tests', () => {
    const testCases = [
        "Hello   world",
        "This is  a test",
        "Multiple     spaces",
        "NoSpacesHere",
        " ",
        "  ",
        "   ",
        "    ",
        "a b c d e f g h i j",
        "OpenAI     Inc"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(fixSpaces(inputText)).toBe(adjustWhitespace(inputText));
    });
});