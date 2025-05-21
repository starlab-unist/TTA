# Source Code
def find_max(words):
    return sorted(words, key = lambda x: (-len(set(x)), x))[0]

# Transformed Code (Semantically Equivalent)
def determine_longest_unique_char_string(word_list):
    def custom_sort_key(word):
        return (-len(set(word)), word)
    
    sorted_words = sorted(word_list, key=custom_sort_key)
    return sorted_words[0]

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ["apple", "banana", "cherry"],
        ["abc", "abcd", "abcde"],
        ["aaaa", "bb", "c"],
        ["hello", "world", "python"],
        ["same", "size", "test"],
        ["unique", "chars", "words"],
        ["one", "two", "three"],
        ["four", "five", "six"],
        ["seven", "eight", "nine"],
        ["ten", "eleven", "twelve"]
    ]

    def test_0(self):
        self.assertEqual(find_max(self.test_cases[0]), determine_longest_unique_char_string(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(find_max(self.test_cases[1]), determine_longest_unique_char_string(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(find_max(self.test_cases[2]), determine_longest_unique_char_string(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(find_max(self.test_cases[3]), determine_longest_unique_char_string(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(find_max(self.test_cases[4]), determine_longest_unique_char_string(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(find_max(self.test_cases[5]), determine_longest_unique_char_string(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(find_max(self.test_cases[6]), determine_longest_unique_char_string(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(find_max(self.test_cases[7]), determine_longest_unique_char_string(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(find_max(self.test_cases[8]), determine_longest_unique_char_string(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(find_max(self.test_cases[9]), determine_longest_unique_char_string(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()