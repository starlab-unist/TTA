# Source Code
def hex_key(num):
    primes = ('2', '3', '5', '7', 'B', 'D')
    total = 0
    for i in range(0, len(num)):
        if num[i] in primes:
            total += 1
    return total

# Transformed Code (Semantically Equivalent)
def count_prime_hex_digits(hex_string):
    prime_hex_digits = {'2', '3', '5', '7', 'B', 'D'}
    count = 0
    index = 0
    while index < len(hex_string):
        if hex_string[index] in prime_hex_digits:
            count += 1
        index += 1
    return count

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "23456789ABCDEF",
        "FFFFFFFF",
        "1234567890",
        "BDBDBD",
        "222222",
        "777777",
        "",
        "AEC",
        "BEEF",
        "DEADBEEF"
    ]

    def test_0(self):
        self.assertEqual(hex_key(self.test_cases[0]), count_prime_hex_digits(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(hex_key(self.test_cases[1]), count_prime_hex_digits(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(hex_key(self.test_cases[2]), count_prime_hex_digits(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(hex_key(self.test_cases[3]), count_prime_hex_digits(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(hex_key(self.test_cases[4]), count_prime_hex_digits(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(hex_key(self.test_cases[5]), count_prime_hex_digits(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(hex_key(self.test_cases[6]), count_prime_hex_digits(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(hex_key(self.test_cases[7]), count_prime_hex_digits(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(hex_key(self.test_cases[8]), count_prime_hex_digits(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(hex_key(self.test_cases[9]), count_prime_hex_digits(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()