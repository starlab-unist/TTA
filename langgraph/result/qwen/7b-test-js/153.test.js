// Source Code
function Strongest_Extension(class_name, extensions) {
    let strong = extensions[0];
    let my_val = Array.from(extensions[0]).filter(x => x >= 'A' && x <= 'Z').length -
                 Array.from(extensions[0]).filter(x => x >= 'a' && x <= 'z').length;
    
    for (let s of extensions) {
        let val = Array.from(s).filter(x => x >= 'A' && x <= 'Z').length -
                  Array.from(s).filter(x => x >= 'a' && x <= 'z').length;
        
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
    let maxStrength = Array.from(addonList[0]).reduce((acc, char) => acc + (char === char.toUpperCase() ? 1 : -1), 0);

    for (let addon of addonList) {
        let currentStrength = Array.from(addon).reduce((acc, char) => acc + (char === char.toUpperCase() ? 1 : -1), 0);
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
        it(`test case ${index}`, () => {
            expect(Strongest_Extension(className, extensions)).toBe(findPowerfulAddon(className, extensions));
        });
    });
});