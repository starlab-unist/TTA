// Source Code
function Strongest_Extension(class_name, extensions) {
    let strong = extensions[0];
    let my_val = extensions[0].split('').filter(x => /[A-Z]/.test(x)).length - extensions[0].split('').filter(x => /[a-z]/.test(x)).length;

    for (let s of extensions) {
        let val = s.split('').filter(x => /[A-Z]/.test(x)).length - s.split('').filter(x => /[a-z]/.test(x)).length;
        if (val > my_val) {
            strong = s;
            my_val = val;
        }
    }

    let ans = class_name + "." + strong;
    return ans;
}

// Transformed Code
function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = addonList[0].split('').reduce((sum, char) => sum + (char === char.toUpperCase() ? 1 : -1), 0);

    for (let addon of addonList) {
        let currentStrength = addon.split('').reduce((sum, char) => sum + (char === char.toUpperCase() ? 1 : -1), 0);
        if (currentStrength > maxStrength) {
            powerfulAddon = addon;
            maxStrength = currentStrength;
        }
    }

    let result = `${baseClass}.${powerfulAddon}`;
    return result;
}

// Test Cases
describe('Strongest_Extension vs findPowerfulAddon equivalence tests', () => {
    const testCases = [
        ["ClassName", ["Ext1", "EXT2", "ext3"]],
        ["Base", ["AddonA", "ADDONB", "addonC"]],
        ["Main", ["UPPER", "lower", "MiXeD"]],
        ["Test", ["aBcDeFgHiJ", "KLMnopQRSt", "UVwxYZ123"]],
        ["Sample", ["abc", "ABC", "AbC"]],
        ["Example", ["", "A", "a"]],
        ["Case", ["UPPERCASE", "lowercase", "MixedCase"]],
        ["Check", ["same", "SAME", "SaMe"]],
        ["Compare", ["123456", "!@#$%^", "abcdef"]],
        ["Evaluate", ["UPPERlower", "UPPERLOWER", "upperlower"]]
    ];

    testCases.forEach(([class_name, extensions], index) => {
        it(`Test case ${index}`, () => {
            expect(Strongest_Extension(class_name, extensions)).toEqual(findPowerfulAddon(class_name, extensions));
        });
    });
});