const { sameChars, compareCharacterSets } = require('./path_to_your_functions'); // Update path as necessary

test('sameChars function: hello and olleh', () => {
    expect(sameChars("hello", "olleh")).toBe(compareCharacterSets("hello", "olleh"));
});

test('sameChars function: world and dlrow', () => {
    expect(sameChars("world", "dlrow")).toBe(compareCharacterSets("world", "dlrow"));
});

test('sameChars function: python and nothyp', () => {
    expect(sameChars("python", "nothyp")).toBe(compareCharacterSets("python", "nothyp"));
});

test('sameChars function: openai and ipaneo', () => {
    expect(sameChars("openai", "ipaneo")).toBe(compareCharacterSets("openai", "ipaneo"));
});

test('sameChars function: empty strings', () => {
    expect(sameChars("", "")).toBe(compareCharacterSets("", ""));
});

test('sameChars function: single character same', () => {
    expect(sameChars("a", "a")).toBe(compareCharacterSets("a", "a"));
});

test('sameChars function: ab and ba', () => {
    expect(sameChars("ab", "ba")).toBe(compareCharacterSets("ab", "ba"));
});

test('sameChars function: abc and cba', () => {
    expect(sameChars("abc", "cba")).toBe(compareCharacterSets("abc", "cba"));
});

test('sameChars function: abcd and dcba', () => {
    expect(sameChars("abcd", "dcba")).toBe(compareCharacterSets("abcd", "dcba"));
});

test('sameChars function: xyz and zyx', () => {
    expect(sameChars("xyz", "zyx")).toBe(compareCharacterSets("xyz", "zyx"));
});