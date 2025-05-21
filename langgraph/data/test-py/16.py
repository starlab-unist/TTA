def count_distinct_characters(string: str) -> int:
    return len(set(string.lower()))

def determine_unique_char_count(input_text: str) -> int:
    unique_chars = set(input_text.lower())
    return len(unique_chars)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello",
        "Python",
        "OpenAI",
        "AaBbCc",
        "1234567890",
        "!@#$%^&*()",
        "aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz",
        "The quick brown fox jumps over the lazy dog",
        "",
        " ",
    ]

    def test_0(self):
        self.assertEqual(count_distinct_characters(self.test_cases[0]), determine_unique_char_count(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(count_distinct_characters(self.test_cases[1]), determine_unique_char_count(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(count_distinct_characters(self.test_cases[2]), determine_unique_char_count(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(count_distinct_characters(self.test_cases[3]), determine_unique_char_count(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(count_distinct_characters(self.test_cases[4]), determine_unique_char_count(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(count_distinct_characters(self.test_cases[5]), determine_unique_char_count(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(count_distinct_characters(self.test_cases[6]), determine_unique_char_count(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(count_distinct_characters(self.test_cases[7]), determine_unique_char_count(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(count_distinct_characters(self.test_cases[8]), determine_unique_char_count(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(count_distinct_characters(self.test_cases[9]), determine_unique_char_count(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()