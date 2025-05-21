from typing import List
import unittest

# Source Code
def concatenate(strings: List[str]) -> str:
    return ''.join(strings)

# Transformed Code (Semantically Equivalent)
def merge_strings(string_list: List[str]) -> str:
    result = ""
    index = 0
    while index < len(string_list):
        result += string_list[index]
        index += 1
    return result

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (["Hello", " ", "World"], "Hello World"),
        (["Python", "3.9"], "Python3.9"),
        ([], ""),
        (["single"], "single"),
        (["a", "b", "c", "d"], "abcd"),
        (["123", "456", "789"], "123456789"),
        (["space", " ", "between"], "space between"),
        (["no", "spaces"], "nospaces"),
        (["multiple", "   ", "spaces"], "multiple   spaces"),
        (["line1\n", "line2\n", "line3"], "line1\nline2\nline3")
    ]

    def test_0(self):
        self.assertEqual(concatenate(self.test_cases[0][0]), merge_strings(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(concatenate(self.test_cases[1][0]), merge_strings(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(concatenate(self.test_cases[2][0]), merge_strings(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(concatenate(self.test_cases[3][0]), merge_strings(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(concatenate(self.test_cases[4][0]), merge_strings(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(concatenate(self.test_cases[5][0]), merge_strings(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(concatenate(self.test_cases[6][0]), merge_strings(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(concatenate(self.test_cases[7][0]), merge_strings(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(concatenate(self.test_cases[8][0]), merge_strings(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(concatenate(self.test_cases[9][0]), merge_strings(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()