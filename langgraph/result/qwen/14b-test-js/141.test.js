// Source Code
function fileNameCheck(fileName) {
    const suf = ['txt', 'exe', 'dll'];
    const lst = fileName.split('.');
    if (lst.length !== 2) {
        return 'No';
    }
    if (!suf.includes(lst[1])) {
        return 'No';
    }
    if (lst[0].length === 0) {
        return 'No';
    }
    if (!/^[a-zA-Z]/.test(lst[0][0])) {
        return 'No';
    }
    const t = (lst[0].match(/\d/g) || []).length;
    if (t > 3) {
        return 'No';
    }
    return 'Yes';
}

// Transformed Code (Semantically Equivalent)
function validateFileIdentifier(filename) {
    const validExtensions = ['txt', 'exe', 'dll'];
    const parts = filename.split('.').reverse();

    if (parts.length !== 2) {
        return 'No';
    }

    const [extension, name] = parts.reverse();
    if (!validExtensions.includes(extension)) {
        return 'No';
    }

    if (!name) {
        return 'No';
    }

    if (!/^[a-zA-Z]/.test(name[0])) {
        return 'No';
    }

    const digitCount = [...name].filter(c => /\d/.test(c)).length;
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