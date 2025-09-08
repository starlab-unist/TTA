// Source Code
function StrongestExtension(className, extensions) {
    let strong = extensions[0];
    let myVal = 0;
    for (let s of extensions) {
        let val = 0;
        for (let x of s) {
            if (x >= 'A' && x <= 'Z') val++;
            if (x >= 'a' && x <= 'z') val--;
        }
        if (val > myVal) {
            strong = s;
            myVal = val;
        }
    }
    let ans = className + "." + strong;
    return ans;
}

// Transformed Code (Semantically Equivalent)
function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = 0;

    for (let addon of addonList) {
        let currentStrength = 0;
        for (let char of addon) {
            if (char === char.toUpperCase()) {
                currentStrength++;
            } else if (char === char.toLowerCase()) {
                currentStrength--;
            }
        }
        if (currentStrength > maxStrength) {
            powerfulAddon = addon;
            maxStrength = currentStrength;
        }
    }

    let result = `${baseClass}.${powerfulAddon}`;
    return result;
}

// Test Cases
describe('StrongestExtension vs findPowerfulAddon equivalence tests', () => {
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

    test.each(testCases)('Input: "%s", %p', (className, extensions) => {
        expect(StrongestExtension(className, extensions)).toEqual(findPowerfulAddon(className, extensions));
    });
});