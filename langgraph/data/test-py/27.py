def flip_case(string: str) -> str:
    return string.swapcase()

def invert_character_case(input_text: str) -> str:
    result = ''
    for char in input_text:
        if char.islower():
            result += char.upper()
        elif char.isupper():
            result += char.lower()
        else:
            result += char
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello World",
        "Python3.8",
        "1234567890",
        "FLIPCASEflipcase",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "!@#$%^&*()_+",
        "ALLCAPS",
        "alllower",
        "MiXeD CaSe",
        ""
    ]

    def test_0(self):
        self.assertEqual(flip_case(self.test_cases[0]), invert_character_case(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(flip_case(self.test_cases[1]), invert_character_case(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(flip_case(self.test_cases[2]), invert_character_case(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(flip_case(self.test_cases[3]), invert_character_case(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(flip_case(self.test_cases[4]), invert_character_case(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(flip_case(self.test_cases[5]), invert_character_case(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(flip_case(self.test_cases[6]), invert_character_case(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(flip_case(self.test_cases[7]), invert_character_case(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(flip_case(self.test_cases[8]), invert_character_case(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(flip_case(self.test_cases[9]), invert_character_case(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()