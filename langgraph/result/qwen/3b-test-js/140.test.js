// Source Code
function fixSpaces(text) {
    let new_text = "";
    let i = 0;
    let start = 0;
    let end = 0;

    while (i < text.length) {
        if (text[i] === " ") {
            end++;
        } else {
            if (end - start > 2) {
                new_text += "-" + text[i];
            } else if (end - start > 0) {
                new_text += "_" + Array(end - start).fill("_").join("") + text[i];
            } else {
                new_text += text[i];
            }
            start = end;
            end = i + 1;
        }
        i++;
    }

    if (end - start > 2) {
        new_text += "-";
    } else if (end - start > 0) {
        new_text += "_";
    }

    return new_text;
}

// Transformed Code (Semantically Equivalent)
function adjustWhitespace(inputString) {
    let result = "";
    let index = 0;
    let begin = 0;
    let finish = 0;
    while (index < inputString.length) {
        if (inputString[index] === " ") {
            finish++;
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
        index++;
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
        expect(fixSpaces(inputText)).toBe(adjustWhitespace(inputText))
    });
});