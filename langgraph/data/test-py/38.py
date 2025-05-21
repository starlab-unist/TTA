def encode_cyclic(s: str):
    """
    returns encoded string by cycling groups of three characters.
    """
    # split string to groups. Each of length 3.
    groups = [s[(3 * i):min((3 * i + 3), len(s))] for i in range((len(s) + 2) // 3)]
    # cycle elements in each group. Unless group has fewer elements than 3.
    groups = [(group[1:] + group[0]) if len(group) == 3 else group for group in groups]
    return "".join(groups)


def decode_cyclic(s: str):
    return encode_cyclic(encode_cyclic(s))


def transform_cyclic_string(input_string: str):
    """
    Returns encoded string by cycling groups of three characters.
    """
    # Divide the string into chunks of three characters
    chunks = [input_string[i:i+3] for i in range(0, len(input_string), 3)]
    
    # Rotate each chunk if it contains exactly three characters
    rotated_chunks = [(chunk[1:] + chunk[0]) if len(chunk) == 3 else chunk for chunk in chunks]
    
    # Join all chunks back into a single string
    return ''.join(rotated_chunks)


def reverse_cyclic_transformation(encoded_string: str):
    # Apply the transformation twice to decode the string
    return transform_cyclic_string(transform_cyclic_string(encoded_string))


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "abcdef",
        "hello world",
        "abcde",
        "a",
        "",
        "python",
        "123456789",
        "transform",
        "cyclic",
        "unittest"
    ]

    def test_0(self):
        self.assertEqual(encode_cyclic(self.test_cases[0]), transform_cyclic_string(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(encode_cyclic(self.test_cases[1]), transform_cyclic_string(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(encode_cyclic(self.test_cases[2]), transform_cyclic_string(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(encode_cyclic(self.test_cases[3]), transform_cyclic_string(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(encode_cyclic(self.test_cases[4]), transform_cyclic_string(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(encode_cyclic(self.test_cases[5]), transform_cyclic_string(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(encode_cyclic(self.test_cases[6]), transform_cyclic_string(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(encode_cyclic(self.test_cases[7]), transform_cyclic_string(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(encode_cyclic(self.test_cases[8]), transform_cyclic_string(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(encode_cyclic(self.test_cases[9]), transform_cyclic_string(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()