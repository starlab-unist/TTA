// Source Code
function fileNameCheck(fileName) {
    const suf = ['txt', 'exe', 'dll'];
    const [name, extension] = fileName.split('.');
    if (extension.length !== 2) return 'No';
    if (!suf.includes(extension)) return 'No';
    if (name.length === 0) return 'No';
    if (!name[0].match(/[a-zA-Z]/)) return 'No';
    const digitCount = [...name].filter(char => /\d/.test(char)).length;
    if (digitCount > 3) return 'No';
    return 'Yes';
}

// Transformed Code (Semantically Equivalent)
function validateFileIdentifier(filename) {
    const validExtensions = ['txt', 'exe', 'dll'];
    const [name, extension] = filename.split('.', 1);

    if (!extension || !name) {
        return 'No';
    }

    if (!validExtensions.includes(extension)) {
        return 'No';
    }

    if (!name[0].match(/[a-zA-Z]/)) {
        return 'No';
    }

    const digitCount = [...name].reduce((count, char) => count + (char.match(/\d/) ? 1 : 0), 0);
    if (digitCount > 3) {
        return 'No';
    }

    return 'Yes';
}

// Test Cases
describe('fileNameCheck vs validateFileIdentifier equivalence tests', () => {
    const testCases = [
        "example.txt",
        "test.exe",
        "data.dll",
        "file..txt",
        ".hiddenfile.txt",
        "1234name.txt",
        "validName123.exe",
        "anotherValid.dll",
        "tooManyDigits1234.txt",
        "noextension",
        "wrongextension.doc"
    ];

    test.each(testCases)('Input: "%s"', (inputText) => {
        expect(fileNameCheck(inputText)).toBe(validateFileIdentifier(inputText));
    });
});