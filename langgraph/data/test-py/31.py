# Source Code
def is_prime(n):
    if n < 2:
        return False
    for k in range(2, n - 1):
        if n % k == 0:
            return False
    return True

# Transformed Code (Semantically Equivalent)
def check_prime(number):
    if number < 2:
        return False
    divisor = 2
    while divisor < number - 1:
        if number % divisor == 0:
            return False
        divisor += 1
    return True

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,      # Not prime (less than 2)
        1,      # Not prime (less than 2)
        2,      # Prime
        3,      # Prime
        4,      # Not prime
        5,      # Prime
        9,      # Not prime
        11,     # Prime
        16,     # Not prime
        17,     # Prime
    ]

    def test_0(self):
        self.assertEqual(is_prime(self.test_cases[0]), check_prime(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_prime(self.test_cases[1]), check_prime(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_prime(self.test_cases[2]), check_prime(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_prime(self.test_cases[3]), check_prime(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_prime(self.test_cases[4]), check_prime(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_prime(self.test_cases[5]), check_prime(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_prime(self.test_cases[6]), check_prime(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_prime(self.test_cases[7]), check_prime(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_prime(self.test_cases[8]), check_prime(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_prime(self.test_cases[9]), check_prime(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()