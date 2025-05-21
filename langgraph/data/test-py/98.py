def count_upper(s):
    count = 0
    for i in range(0,len(s),2):
        if s[i] in "AEIOU":
            count += 1
    return count

def tally_even_index_vowels(input_string):
    vowel_count = 0
    index = 0
    while index < len(input_string):
        if index % 2 == 0 and input_string[index] in "AEIOU":
            vowel_count += 1
        index += 1
    return vowel_count

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("", 0),
        ("A", 1),
        ("B", 0),
        ("AEIOU", 3),
        ("aeiou", 0),
        ("AbEcIdOfUg", 2),
        ("abcdefgHIJKL", 0),
        ("HELLOworld", 1),
        ("Python", 0),
        ("UPPERlower", 1),
        ("AEIOU" * 5, 8),  # "AEIOUAEIOUAEIOUAEIOUAEIOU"
        ("AxBxCxDxExF", 3)
    ]

    def test_0(self):
        self.assertEqual(count_upper(self.test_cases[0][0]), tally_even_index_vowels(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(count_upper(self.test_cases[1][0]), tally_even_index_vowels(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(count_upper(self.test_cases[2][0]), tally_even_index_vowels(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(count_upper(self.test_cases[3][0]), tally_even_index_vowels(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(count_upper(self.test_cases[4][0]), tally_even_index_vowels(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(count_upper(self.test_cases[5][0]), tally_even_index_vowels(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(count_upper(self.test_cases[6][0]), tally_even_index_vowels(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(count_upper(self.test_cases[7][0]), tally_even_index_vowels(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(count_upper(self.test_cases[8][0]), tally_even_index_vowels(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(count_upper(self.test_cases[9][0]), tally_even_index_vowels(self.test_cases[9][0]))

    def test_10(self):
        self.assertEqual(count_upper(self.test_cases[10][0]), tally_even_index_vowels(self.test_cases[10][0]))

    def test_11(self):
        self.assertEqual(count_upper(self.test_cases[11][0]), tally_even_index_vowels(self.test_cases[11][0]))

if __name__ == '__main__':
    unittest.main()