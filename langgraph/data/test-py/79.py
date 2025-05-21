# Source Code
def decimal_to_binary(decimal):
    return "db" + bin(decimal)[2:] + "db"

# Transformed Code (Semantically Equivalent)
def convert_decimal_to_binary(number):
    binary_representation = bin(number).replace("0b", "")
    return f"db{binary_representation}db"
# method name: decimal_to_binary -> convert_decimal_to_binary
# parameter name: decimal -> number
# replaced slicing [2:] with replace("0b", "")
# used f-string for formatting the return statement

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        2,
        5,
        10,
        15,
        32,
        64,
        255,
        1023
    ]

    def test_0(self):
        self.assertEqual(decimal_to_binary(self.test_cases[0]), convert_decimal_to_binary(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(decimal_to_binary(self.test_cases[1]), convert_decimal_to_binary(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(decimal_to_binary(self.test_cases[2]), convert_decimal_to_binary(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(decimal_to_binary(self.test_cases[3]), convert_decimal_to_binary(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(decimal_to_binary(self.test_cases[4]), convert_decimal_to_binary(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(decimal_to_binary(self.test_cases[5]), convert_decimal_to_binary(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(decimal_to_binary(self.test_cases[6]), convert_decimal_to_binary(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(decimal_to_binary(self.test_cases[7]), convert_decimal_to_binary(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(decimal_to_binary(self.test_cases[8]), convert_decimal_to_binary(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(decimal_to_binary(self.test_cases[9]), convert_decimal_to_binary(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()