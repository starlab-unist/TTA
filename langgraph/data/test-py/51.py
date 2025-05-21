def remove_vowels(text):
    return "".join([s for s in text if s.lower() not in ["a", "e", "i", "o", "u"]])

def strip_vowels(input_string):
    vowels = set("aeiouAEIOU")
    result = []
    index = 0

    while index < len(input_string):
        char = input_string[index]
        if char not in vowels:
            result.append(char)
        index += 1

    return ''.join(result)

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello, World!",
        "Python Programming",
        "AEIOUaeiou",
        "abcdefghijklmnopqrstuvwxyz",
        "THE quick brown fox JUMPS over the LAZY dog",
        "1234567890",
        "!@#$%^&*()_+",
        "OpenAI",
        "a b c d e f g h i j",
        "This is a simple test case."
    ]

    def test_0(self):
        self.assertEqual(remove_vowels(self.test_cases[0]), strip_vowels(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(remove_vowels(self.test_cases[1]), strip_vowels(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(remove_vowels(self.test_cases[2]), strip_vowels(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(remove_vowels(self.test_cases[3]), strip_vowels(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(remove_vowels(self.test_cases[4]), strip_vowels(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(remove_vowels(self.test_cases[5]), strip_vowels(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(remove_vowels(self.test_cases[6]), strip_vowels(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(remove_vowels(self.test_cases[7]), strip_vowels(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(remove_vowels(self.test_cases[8]), strip_vowels(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(remove_vowels(self.test_cases[9]), strip_vowels(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()