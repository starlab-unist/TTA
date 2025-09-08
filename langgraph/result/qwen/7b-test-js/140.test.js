// Source Code
function fixSpaces(text) {
    let newText = "";
    let i = 0;
    let start = 0, end = 0;
    while (i < text.length) {
        if (text[i] === " ") {
            end++;
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
        i++;
    }
    if (end - start > 2) {
        newText += "-";
    } else if (end - start > 0) {
        newText += "_".repeat(end - start);
    }
    return newText;
}

// Transformed Code (Semantically Equivalent)
function adjustWhitespace(text) {
    let result = "";
    let index = 0;
    let start = 0, end = 0;
    while (index < text.length) {
        if (text[index] === " ") {
            end += 1;
        } else {
            const spaceCount = end - start;
            if (spaceCount > 2) {
                result += "-" + text[index];
            } else if (spaceCount > 0) {
                result += "_".repeat(spaceCount) + text[index];
            } else {
                result += text[index];
            }
            start = index + 1;
            end = index + 1;
        }
        index += 1;
    }
    const finalSpaceCount = end - start;
    if (finalSpaceCount > 2) {
        result += "-";
    } else if (finalSpaceCount > 0) {
        result += "_".repeat(finalSpaceCount);
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