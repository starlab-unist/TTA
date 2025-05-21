# Source Code
def modp(n: int, p: int):
    ret = 1
    for i in range(n):
        ret = (2 * ret) % p
    return ret

# Transformed Code (Semantically Equivalent)
def calculate_modular_exponentiation(base_count: int, modulus: int):
    result = 1
    index = 0
    while index < base_count:
        result = (2 * result) % modulus
        index += 1
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (0, 5),       # n=0, p=5
        (1, 3),       # n=1, p=3
        (2, 7),       # n=2, p=7
        (3, 4),       # n=3, p=4
        (5, 10),      # n=5, p=10
        (10, 13),     # n=10, p=13
        (20, 17),     # n=20, p=17
        (31, 31),     # n=31, p=31
        (50, 61),     # n=50, p=61
        (100, 97)     # n=100, p=97
    ]

    def test_0(self):
        self.assertEqual(modp(self.test_cases[0][0], self.test_cases[0][1]), calculate_modular_exponentiation(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(modp(self.test_cases[1][0], self.test_cases[1][1]), calculate_modular_exponentiation(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(modp(self.test_cases[2][0], self.test_cases[2][1]), calculate_modular_exponentiation(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(modp(self.test_cases[3][0], self.test_cases[3][1]), calculate_modular_exponentiation(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(modp(self.test_cases[4][0], self.test_cases[4][1]), calculate_modular_exponentiation(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(modp(self.test_cases[5][0], self.test_cases[5][1]), calculate_modular_exponentiation(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(modp(self.test_cases[6][0], self.test_cases[6][1]), calculate_modular_exponentiation(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(modp(self.test_cases[7][0], self.test_cases[7][1]), calculate_modular_exponentiation(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(modp(self.test_cases[8][0], self.test_cases[8][1]), calculate_modular_exponentiation(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(modp(self.test_cases[9][0], self.test_cases[9][1]), calculate_modular_exponentiation(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()