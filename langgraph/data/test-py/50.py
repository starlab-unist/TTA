def encode_shift(s: str):
    """
    returns encoded string by shifting every character by 5 in the alphabet.
    """
    return "".join([chr(((ord(ch) + 5 - ord("a")) % 26) + ord("a")) for ch in s])


def decode_shift(s: str):
    return "".join([chr(((ord(ch) - 5 - ord("a")) % 26) + ord("a")) for ch in s])


def shift_encode(input_string: str):
    """
    Encodes the input string by shifting each character forward by 5 positions in the alphabet.
    """
    encoded_chars = []
    for character in input_string:
        shifted_char = chr(((ord(character) + 5 - ord("a")) % 26) + ord("a"))
        encoded_chars.append(shifted_char)
    return ''.join(encoded_chars)


def shift_decode(encoded_string: str):
    decoded_chars = []
    index = 0
    while index < len(encoded_string):
        original_char = chr(((ord(encoded_string[index]) - 5 - ord("a")) % 26) + ord("a"))
        decoded_chars.append(original_char)
        index += 1
    return ''.join(decoded_chars)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "abcde",
        "fghij",
        "vwxyz",
        "hello",
        "world",
        "python",
        "unittest",
        "shift",
        "encode",
        "decode"
    ]

    def test_0(self):
        self.assertEqual(encode_shift(self.test_cases[0]), shift_encode(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(encode_shift(self.test_cases[1]), shift_encode(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(encode_shift(self.test_cases[2]), shift_encode(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(encode_shift(self.test_cases[3]), shift_encode(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(encode_shift(self.test_cases[4]), shift_encode(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(encode_shift(self.test_cases[5]), shift_encode(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(encode_shift(self.test_cases[6]), shift_encode(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(encode_shift(self.test_cases[7]), shift_encode(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(encode_shift(self.test_cases[8]), shift_encode(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(encode_shift(self.test_cases[9]), shift_encode(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()