// Source Code
function parseMusic(musicString) {
    const noteMap = { 'o': 4, 'o|': 2, '.|': 1 };
    return musicString.split(' ').filter(x => x).map(x => noteMap[x]);
}

// Transformed Code (Semantically Equivalent)
function extractNotes(musicalNotation) {
    const noteMapping = { 'o': 4, 'o|': 2, '.|': 1 };
    const notes = musicalNotation.split(' ');
    const result = [];

    for (let i = 0; i < notes.length; i++) {
        const note = notes[i];
        if (note) {
            result.push(noteMapping[note]);
        }
    }

    return result;
}

// Test Cases
describe('parseMusic vs extractNotes equivalence tests', () => {
    const testCases = [
        "o o| .|",
        "o o o",
        ".| .| .|",
        "o| o| o|",
        "o o| .| o| .|",
        "",
        "   ",
        "o o| .| o| .| o o| .|",
        "o|",
        "o"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(parseMusic(inputText)).toEqual(extractNotes(inputText))
    });
});