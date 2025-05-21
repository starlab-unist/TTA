def prime_length(string):
    l = len(string)
    if l == 0 or l == 1:
        return False
    for i in range(2, l):
        if l % i == 0:
            return False
    return True

def check_prime_string_length(input_text):
    string_length = len(input_text)
    if string_length < 2:
        return False
    divisor = 2
    while divisor < string_length:
        if string_length % divisor == 0:
            return False
        divisor += 1
    return True

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "",
        "a",
        "ab",
        "abc",
        "abcd",
        "abcde",
        "abcdef",
        "abcdefgh",
        "abcdefghi",
        "abcdefghij"
    ]

    def test_0(self):
        self.assertEqual(prime_length(self.test_cases[0]), check_prime_string_length(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(prime_length(self.test_cases[1]), check_prime_string_length(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(prime_length(self.test_cases[2]), check_prime_string_length(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(prime_length(self.test_cases[3]), check_prime_string_length(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(prime_length(self.test_cases[4]), check_prime_string_length(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(prime_length(self.test_cases[5]), check_prime_string_length(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(prime_length(self.test_cases[6]), check_prime_string_length(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(prime_length(self.test_cases[7]), check_prime_string_length(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(prime_length(self.test_cases[8]), check_prime_string_length(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(prime_length(self.test_cases[9]), check_prime_string_length(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()