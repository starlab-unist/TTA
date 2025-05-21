def strlen(string: str) -> int:
    return len(string)

def calculate_string_length(text: str) -> int:
    count = 0
    for character in text:
        count += 1
    return count

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "",
        "a",
        "hello",
        "OpenAI",
        "1234567890",
        "!@#$%^&*()",
        "spaces in between",
        "repeated repeated repeated",
        "A quick brown fox jumps over the lazy dog",
        "Python unittest framework"
    ]

    def test_0(self):
        self.assertEqual(strlen(self.test_cases[0]), calculate_string_length(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(strlen(self.test_cases[1]), calculate_string_length(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(strlen(self.test_cases[2]), calculate_string_length(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(strlen(self.test_cases[3]), calculate_string_length(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(strlen(self.test_cases[4]), calculate_string_length(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(strlen(self.test_cases[5]), calculate_string_length(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(strlen(self.test_cases[6]), calculate_string_length(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(strlen(self.test_cases[7]), calculate_string_length(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(strlen(self.test_cases[8]), calculate_string_length(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(strlen(self.test_cases[9]), calculate_string_length(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()