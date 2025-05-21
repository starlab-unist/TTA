def change_base(x: int, base: int):
    ret = ""
    while x > 0:
        ret = str(x % base) + ret
        x //= base
    return ret

def convert_to_base(number: int, target_base: int) -> str:
    result = ""
    while number > 0:
        remainder = number % target_base
        result = str(remainder) + result
        number = number // target_base
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (10, 2),   # Binary representation of 10 is 1010
        (255, 16), # Hexadecimal representation of 255 is ff
        (100, 10), # Decimal representation of 100 is 100
        (7, 3),    # Base 3 representation of 7 is 21
        (0, 5),    # Any base representation of 0 is 0
        (1, 2),    # Binary representation of 1 is 1
        (9, 4),    # Base 4 representation of 9 is 21
        (31, 8),   # Octal representation of 31 is 37
        (64, 2),   # Binary representation of 64 is 1000000
        (81, 9)    # Base 9 representation of 81 is 100
    ]

    def test_0(self):
        self.assertEqual(change_base(*self.test_cases[0]), convert_to_base(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(change_base(*self.test_cases[1]), convert_to_base(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(change_base(*self.test_cases[2]), convert_to_base(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(change_base(*self.test_cases[3]), convert_to_base(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(change_base(*self.test_cases[4]), convert_to_base(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(change_base(*self.test_cases[5]), convert_to_base(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(change_base(*self.test_cases[6]), convert_to_base(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(change_base(*self.test_cases[7]), convert_to_base(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(change_base(*self.test_cases[8]), convert_to_base(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(change_base(*self.test_cases[9]), convert_to_base(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()