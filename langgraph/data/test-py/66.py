def digitSum(s):
    if s == "": return 0
    return sum(ord(char) if char.isupper() else 0 for char in s)

def calculate_uppercase_ascii_sum(input_string):
    if input_string == "":
        return 0
    
    total = 0
    for character in input_string:
        if character.isupper():
            total += ord(character)
    
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "",
        "abc",
        "ABC",
        "Hello World!",
        "Python3.8",
        "OpenAI",
        "1234567890",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        "MIXeD CaSe 123",
        "UPPER lower"
    ]

    def test_0(self):
        self.assertEqual(digitSum(self.test_cases[0]), calculate_uppercase_ascii_sum(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(digitSum(self.test_cases[1]), calculate_uppercase_ascii_sum(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(digitSum(self.test_cases[2]), calculate_uppercase_ascii_sum(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(digitSum(self.test_cases[3]), calculate_uppercase_ascii_sum(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(digitSum(self.test_cases[4]), calculate_uppercase_ascii_sum(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(digitSum(self.test_cases[5]), calculate_uppercase_ascii_sum(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(digitSum(self.test_cases[6]), calculate_uppercase_ascii_sum(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(digitSum(self.test_cases[7]), calculate_uppercase_ascii_sum(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(digitSum(self.test_cases[8]), calculate_uppercase_ascii_sum(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(digitSum(self.test_cases[9]), calculate_uppercase_ascii_sum(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()