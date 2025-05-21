def is_palindrome(text: str):
    for i in range(len(text)):
        if text[i] != text[len(text) - 1 - i]:
            return False
    return True

def check_palindrome(sequence: str):
    index = 0
    length = len(sequence)
    
    while index < length // 2:
        if sequence[index] != sequence[length - index - 1]:
            return False
        index += 1
    return True

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "racecar",
        "level",
        "hello",
        "world",
        "",
        "a",
        "abba",
        "abcba",
        "noon",
        "python"
    ]

    def test_0(self):
        self.assertEqual(is_palindrome(self.test_cases[0]), check_palindrome(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_palindrome(self.test_cases[1]), check_palindrome(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_palindrome(self.test_cases[2]), check_palindrome(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_palindrome(self.test_cases[3]), check_palindrome(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_palindrome(self.test_cases[4]), check_palindrome(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_palindrome(self.test_cases[5]), check_palindrome(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_palindrome(self.test_cases[6]), check_palindrome(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_palindrome(self.test_cases[7]), check_palindrome(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_palindrome(self.test_cases[8]), check_palindrome(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_palindrome(self.test_cases[9]), check_palindrome(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()