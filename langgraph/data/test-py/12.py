from typing import List, Optional
import unittest

# Source Code
def longest(strings: List[str]) -> Optional[str]:
    if not strings:
        return None

    maxlen = max(len(x) for x in strings)
    for s in strings:
        if len(s) == maxlen:
            return s

# Transformed Code (Semantically Equivalent)
def find_longest_string(string_list: List[str]) -> Optional[str]:
    if not string_list:
        return None

    max_length = max((len(item) for item in string_list))
    for element in string_list:
        if len(element) == max_length:
            return element

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (["apple", "banana", "cherry"], "banana"),
        (["dog", "cat"], "dog"),
        ([], None),
        (["a", "ab", "abc", "abcd", "abcde", "abcd"], "abcde"),
        (["same", "size", "word"], "same"),
        (["one", "two", "three", "four"], "three"),
        (["short", "longer", "longest", "longerer", "longererest"], "longererest"),
        (["1234567890", "123", "123456789"], "1234567890"),
        (["same", "same", "same"], "same"),
        (["unique"], "unique")
    ]

    def test_0(self):
        self.assertEqual(longest(self.test_cases[0][0]), find_longest_string(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(longest(self.test_cases[1][0]), find_longest_string(self.test_cases[1][0]))

    def test_2(self):
        self.assertEqual(longest(self.test_cases[2][0]), find_longest_string(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(longest(self.test_cases[3][0]), find_longest_string(self.test_cases[3][0]))

    def test_4(self):
        self.assertEqual(longest(self.test_cases[4][0]), find_longest_string(self.test_cases[4][0]))
    
    def test_5(self):
        self.assertEqual(longest(self.test_cases[5][0]), find_longest_string(self.test_cases[5][0]))

    def test_6(self):
        self.assertEqual(longest(self.test_cases[6][0]), find_longest_string(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(longest(self.test_cases[7][0]), find_longest_string(self.test_cases[7][0]))

    def test_8(self):
        self.assertEqual(longest(self.test_cases[8][0]), find_longest_string(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(longest(self.test_cases[9][0]), find_longest_string(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()