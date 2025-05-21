def get_closest_vowel(word):
    if len(word) < 3:
        return ""

    vowels = {"a", "e", "i", "o", "u", "A", "E", 'O', 'U', 'I'}
    for i in range(len(word)-2, 0, -1):
        if word[i] in vowels:
            if (word[i+1] not in vowels) and (word[i-1] not in vowels):
                return word[i]
    return ""

def find_innermost_solo_vowel(phrase):
    if len(phrase) < 3:
        return ""
    
    vowel_set = set("aeiouAEIOU")
    index = len(phrase) - 2
    
    while index > 0:
        if phrase[index] in vowel_set:
            if phrase[index + 1] not in vowel_set and phrase[index - 1] not in vowel_set:
                return phrase[index]
        index -= 1
    
    return ""

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello",
        "beautiful",
        "sequence",
        "aeiou",
        "bcdfg",
        "aebcdfg",
        "racecar",
        "xylophone",
        "umbrella",
        "algorithm"
    ]

    def test_0(self):
        self.assertEqual(get_closest_vowel(self.test_cases[0]), find_innermost_solo_vowel(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(get_closest_vowel(self.test_cases[1]), find_innermost_solo_vowel(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(get_closest_vowel(self.test_cases[2]), find_innermost_solo_vowel(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(get_closest_vowel(self.test_cases[3]), find_innermost_solo_vowel(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(get_closest_vowel(self.test_cases[4]), find_innermost_solo_vowel(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(get_closest_vowel(self.test_cases[5]), find_innermost_solo_vowel(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(get_closest_vowel(self.test_cases[6]), find_innermost_solo_vowel(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(get_closest_vowel(self.test_cases[7]), find_innermost_solo_vowel(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(get_closest_vowel(self.test_cases[8]), find_innermost_solo_vowel(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(get_closest_vowel(self.test_cases[9]), find_innermost_solo_vowel(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()