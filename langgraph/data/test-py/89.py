def encrypt(s):
    d = 'abcdefghijklmnopqrstuvwxyz'
    out = ''
    for c in s:
        if c in d:
            out += d[(d.index(c)+2*2) % 26]
        else:
            out += c
    return out

def cipher_text(input_string):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    result = []
    for character in input_string:
        if character in alphabet:
            new_index = (alphabet.index(character) + 4) % 26
            result.append(alphabet[new_index])
        else:
            result.append(character)
    return ''.join(result)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello",
        "world",
        "abcxyz",
        "python",
        "12345",
        "!@#$%",
        "encrypt this string",
        "a quick brown fox jumps over the lazy dog",
        "the quick brown fox jumps over the lazy dog",
        "abcdefghijklmnopqrstuvwxyz"
    ]

    def test_0(self):
        self.assertEqual(encrypt(self.test_cases[0]), cipher_text(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(encrypt(self.test_cases[1]), cipher_text(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(encrypt(self.test_cases[2]), cipher_text(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(encrypt(self.test_cases[3]), cipher_text(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(encrypt(self.test_cases[4]), cipher_text(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(encrypt(self.test_cases[5]), cipher_text(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(encrypt(self.test_cases[6]), cipher_text(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(encrypt(self.test_cases[7]), cipher_text(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(encrypt(self.test_cases[8]), cipher_text(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(encrypt(self.test_cases[9]), cipher_text(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()