// Source Code
function isBored(S) {
    const sentences = S.split(/(?<=[.?!])\s+/);
    return sentences.reduce((count, sentence) => count + (sentence.startsWith('I ')), 0);
}

// Transformed Code (Semantically Equivalent)
function countPersonalStatements(text) {
    const segments = text.split(/[.?!]\s*/);
    let personalStatementCount = 0;

    for (let segment of segments) {
        if (segment.startsWith('I ')) {
            personalStatementCount++;
        }
    }

    return personalStatementCount;
}

// Test Cases
describe('isBored vs countPersonalStatements equivalence tests', () => {
    const testCases = [
        "I am bored. I think so.",
        "This is a test. I am testing.",
        "Hello world! I am here. Are you there?",
        "No personal statements here.",
        "I I I. I? I!",
        "I am fine. You are fine.",
        "I",
        "",
        "I am alone.I think so.I am sad.",
        "I. I! I?"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(isBored(inputText)).toBe(countPersonalStatements(inputText));
    });
});