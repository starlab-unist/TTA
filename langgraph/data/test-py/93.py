def encode(message):
    vowels = "aeiouAEIOU"
    vowels_replace = dict([(i, chr(ord(i) + 2)) for i in vowels])
    message = message.swapcase()
    return ''.join([vowels_replace[i] if i in vowels else i for i in message])

# Transformed Code (Semantically Equivalent)
def transform_message(input_text):
    vowel_set = "aeiouAEIOU"
    vowel_mapping = {char: chr(ord(char) + 2) for char in vowel_set}
    modified_text = input_text.swapcase()
    result = ''.join(vowel_mapping.get(char, char) for char in modified_text)
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello World",
        "Python Programming",
        "OpenAI",
        "encode",
        "AEIOUaeiou",
        "1234567890",
        "Symbols #$%^&*()",
        "Mixed CASE",
        "aBcDeFgHiJkLmNoPqRsTuVwXyZ",
        ""
    ]

    def test_0(self):
        self.assertEqual(encode(self.test_cases[0]), transform_message(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(encode(self.test_cases[1]), transform_message(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(encode(self.test_cases[2]), transform_message(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(encode(self.test_cases[3]), transform_message(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(encode(self.test_cases[4]), transform_message(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(encode(self.test_cases[5]), transform_message(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(encode(self.test_cases[6]), transform_message(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(encode(self.test_cases[7]), transform_message(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(encode(self.test_cases[8]), transform_message(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(encode(self.test_cases[9]), transform_message(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()