# Source Code
def truncate_number(number: float) -> float:
    return number % 1.0

# Transformed Code (Semantically Equivalent)
def extract_decimal_part(value: float) -> float:
    decimal_part = value - int(value)
    return decimal_part

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        3.14159,
        0.99999,
        123.456,
        -789.123,
        0.0,
        -0.0,
        100.0,
        -100.0,
        1.0,
        -1.0
    ]

    def test_0(self):
        self.assertEqual(truncate_number(self.test_cases[0]), extract_decimal_part(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(truncate_number(self.test_cases[1]), extract_decimal_part(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(truncate_number(self.test_cases[2]), extract_decimal_part(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(truncate_number(self.test_cases[3]), extract_decimal_part(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(truncate_number(self.test_cases[4]), extract_decimal_part(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(truncate_number(self.test_cases[5]), extract_decimal_part(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(truncate_number(self.test_cases[6]), extract_decimal_part(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(truncate_number(self.test_cases[7]), extract_decimal_part(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(truncate_number(self.test_cases[8]), extract_decimal_part(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(truncate_number(self.test_cases[9]), extract_decimal_part(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()