// Source Code
function Strongest_Extension(class_name, extensions) {
    let strong = extensions[0];
    let my_val = (strong.match(/[A-Z]/g) || []).length - (strong.match(/[a-z]/g) || []).length;
    
    for (let s of extensions) {
        let val = (s.match(/[A-Z]/g) || []).length - (s.match(/[a-z]/g) || []).length;
        if (val > my_val) {
            strong = s;
            my_val = val;
        }
    }

    let ans = class_name + "." + strong;
    return ans;
}

// Transformed Code (Semantically Equivalent)
function findPowerfulAddon(baseClass, addonList) {
    let powerfulAddon = addonList[0];
    let maxStrength = [...addonList[0]].filter(char => char === char.toUpperCase()).length - [...addonList[0]].filter(char => char === char.toLowerCase()).length;

    for (let addon of addonList) {
        let currentStrength = [...addon].filter(char => char === char.toUpperCase()).length - [...addon].filter(char => char === char.toLowerCase()).length;
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

    testCases.forEach(([className, extensions], index) => {
        it(`test_${index}`, () => {
            expect(Strongest_Extension(className, extensions)).toBe(findPowerfulAddon(className, extensions));
        });
    });
});