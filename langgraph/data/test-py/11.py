from typing import List

# Source Code
def string_xor(a: str, b: str) -> str:
    def xor(i, j):
        if i == j:
            return '0'
        else:
            return '1'

    return ''.join(xor(x, y) for x, y in zip(a, b))

# Transformed Code (Semantically Equivalent)
def binary_string_difference(str1: str, str2: str) -> str:
    def bit_diff(c1, c2):
        return '0' if c1 == c2 else '1'

    result = []
    index = 0
    while index < len(str1):
        result.append(bit_diff(str1[index], str2[index]))
        index += 1

    return ''.join(result)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("1101", "1001"),
        ("1111", "0000"),
        ("0000", "0000"),
        ("101010", "010101"),
        ("111000", "111000"),
        ("110011", "001100"),
        ("1", "1"),
        ("0", "0"),
        ("10", "01"),
        ("11111111", "00000000")
    ]

    def test_0(self):
        self.assertEqual(string_xor(self.test_cases[0][0], self.test_cases[0][1]), binary_string_difference(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(string_xor(self.test_cases[1][0], self.test_cases[1][1]), binary_string_difference(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(string_xor(self.test_cases[2][0], self.test_cases[2][1]), binary_string_difference(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(string_xor(self.test_cases[3][0], self.test_cases[3][1]), binary_string_difference(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(string_xor(self.test_cases[4][0], self.test_cases[4][1]), binary_string_difference(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(string_xor(self.test_cases[5][0], self.test_cases[5][1]), binary_string_difference(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(string_xor(self.test_cases[6][0], self.test_cases[6][1]), binary_string_difference(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(string_xor(self.test_cases[7][0], self.test_cases[7][1]), binary_string_difference(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(string_xor(self.test_cases[8][0], self.test_cases[8][1]), binary_string_difference(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(string_xor(self.test_cases[9][0], self.test_cases[9][1]), binary_string_difference(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()