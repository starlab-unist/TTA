def Strongest_Extension(class_name, extensions):
    strong = extensions[0]
    my_val = len([x for x in extensions[0] if x.isalpha() and x.isupper()]) - len([x for x in extensions[0] if x.isalpha() and x.islower()])
    for s in extensions:
        val = len([x for x in s if x.isalpha() and x.isupper()]) - len([x for x in s if x.isalpha() and x.islower()])
        if val > my_val:
            strong = s
            my_val = val

    ans = class_name + "." + strong
    return ans


def find_powerful_addon(base_class, addon_list):
    powerful_addon = addon_list[0]
    max_strength = sum(1 for char in addon_list[0] if char.isupper()) - sum(1 for char in addon_list[0] if char.islower())

    for addon in addon_list:
        current_strength = sum(1 for char in addon if char.isupper()) - sum(1 for char in addon if char.islower())
        if current_strength > max_strength:
            powerful_addon = addon
            max_strength = current_strength

    result = f"{base_class}.{powerful_addon}"
    return result


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("ClassName", ["Ext1", "EXT2", "ext3"]),
        ("Base", ["AddonA", "ADDONB", "addonC"]),
        ("Main", ["UPPER", "lower", "MiXeD"]),
        ("Test", ["aBcDeFgHiJ", "KLMnopQRSt", "UVwxYZ123"]),
        ("Sample", ["abc", "ABC", "AbC"]),
        ("Example", ["", "A", "a"]),
        ("Case", ["UPPERCASE", "lowercase", "MixedCase"]),
        ("Check", ["same", "SAME", "SaMe"]),
        ("Compare", ["123456", "!@#$%^", "abcdef"]),
        ("Evaluate", ["UPPERlower", "UPPERLOWER", "upperlower"])
    ]

    def test_0(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[0]), find_powerful_addon(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[1]), find_powerful_addon(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[2]), find_powerful_addon(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[3]), find_powerful_addon(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[4]), find_powerful_addon(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[5]), find_powerful_addon(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[6]), find_powerful_addon(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[7]), find_powerful_addon(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[8]), find_powerful_addon(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(Strongest_Extension(*self.test_cases[9]), find_powerful_addon(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()