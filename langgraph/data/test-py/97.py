# Source Code
def multiply(a, b):
    return abs(a % 10) * abs(b % 10)

# Transformed Code (Semantically Equivalent)
def calculate_unit_digit_product(x, y):
    unit_digit_x = abs(x % 10)
    unit_digit_y = abs(y % 10)
    product = unit_digit_x * unit_digit_y
    return product

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (123, 456),
        (-123, 456),
        (123, -456),
        (-123, -456),
        (0, 456),
        (123, 0),
        (0, 0),
        (789, 12345),
        (5, 9),
        (10, 10)
    ]

    def test_0(self):
        self.assertEqual(multiply(*self.test_cases[0]), calculate_unit_digit_product(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(multiply(*self.test_cases[1]), calculate_unit_digit_product(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(multiply(*self.test_cases[2]), calculate_unit_digit_product(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(multiply(*self.test_cases[3]), calculate_unit_digit_product(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(multiply(*self.test_cases[4]), calculate_unit_digit_product(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(multiply(*self.test_cases[5]), calculate_unit_digit_product(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(multiply(*self.test_cases[6]), calculate_unit_digit_product(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(multiply(*self.test_cases[7]), calculate_unit_digit_product(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(multiply(*self.test_cases[8]), calculate_unit_digit_product(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(multiply(*self.test_cases[9]), calculate_unit_digit_product(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()