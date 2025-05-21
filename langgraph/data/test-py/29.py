from typing import List
import unittest

# Source Code
def filter_by_prefix(strings: List[str], prefix: str) -> List[str]:
    return [x for x in strings if x.startswith(prefix)]

# Transformed Code (Semantically Equivalent)
def select_strings_with_starting_chars(word_list: List[str], start_sequence: str) -> List[str]:
    filtered_words = []
    for word in word_list:
        if word.startswith(start_sequence):
            filtered_words.append(word)
    return filtered_words

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (["apple", "banana", "apricot", "avocado"], "a"),
        (["hello", "world", "hi", "house"], "h"),
        (["test", "testing", "tested"], "te"),
        (["one", "two", "three"], "f"),
        ([], "a"),
        (["same", "same", "same"], "sa"),
        (["prefix", "preface", "presentation"], "pre"),
        (["123abc", "abc123", "123456"], "123"),
        (["no_match", "nomatch", "notmatch"], "noma"),
        (["a", "b", "c", "d"], "z")
    ]

    def test_0(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[0]), select_strings_with_starting_chars(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[1]), select_strings_with_starting_chars(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[2]), select_strings_with_starting_chars(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[3]), select_strings_with_starting_chars(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[4]), select_strings_with_starting_chars(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[5]), select_strings_with_starting_chars(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[6]), select_strings_with_starting_chars(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[7]), select_strings_with_starting_chars(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[8]), select_strings_with_starting_chars(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(filter_by_prefix(*self.test_cases[9]), select_strings_with_starting_chars(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()