import hashlib

# Source Code
def string_to_md5(text):
    import hashlib
    return hashlib.md5(text.encode('ascii')).hexdigest() if text else None

# Transformed Code (Semantically Equivalent)
def convert_text_to_hash(input_string):
    if not input_string:
        return None
    encoded_string = input_string.encode('ascii')
    md5_hash = hashlib.md5(encoded_string).hexdigest()
    return md5_hash

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello, World!",
        "OpenAI",
        "Python is fun!",
        "1234567890",
        "",
        "a",
        "MD5 hash",
        "unittest",
        "transformed code",
        "semantically equivalent"
    ]

    def test_0(self):
        self.assertEqual(string_to_md5(self.test_cases[0]), convert_text_to_hash(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(string_to_md5(self.test_cases[1]), convert_text_to_hash(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(string_to_md5(self.test_cases[2]), convert_text_to_hash(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(string_to_md5(self.test_cases[3]), convert_text_to_hash(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(string_to_md5(self.test_cases[4]), convert_text_to_hash(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(string_to_md5(self.test_cases[5]), convert_text_to_hash(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(string_to_md5(self.test_cases[6]), convert_text_to_hash(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(string_to_md5(self.test_cases[7]), convert_text_to_hash(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(string_to_md5(self.test_cases[8]), convert_text_to_hash(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(string_to_md5(self.test_cases[9]), convert_text_to_hash(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()