def greatest_common_divisor(a: int, b: int) -> int:
    while b:
        a, b = b, a % b
    return a

def find_highest_common_factor(num1: int, num2: int) -> int:
    while num2 != 0:
        remainder = num1 % num2
        num1 = num2
        num2 = remainder
    return num1

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (48, 18),  # GCD is 6
        (56, 98),  # GCD is 14
        (101, 103), # GCD is 1 (prime numbers)
        (270, 192), # GCD is 6
        (0, 5),    # GCD is 5
        (5, 0),    # GCD is 5
        (0, 0),    # GCD is 0
        (20, 30),  # GCD is 10
        (7, 3),    # GCD is 1
        (100, 10)  # GCD is 10
    ]

    def test_0(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[0]), find_highest_common_factor(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[1]), find_highest_common_factor(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[2]), find_highest_common_factor(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[3]), find_highest_common_factor(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[4]), find_highest_common_factor(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[5]), find_highest_common_factor(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[6]), find_highest_common_factor(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[7]), find_highest_common_factor(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[8]), find_highest_common_factor(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(greatest_common_divisor(*self.test_cases[9]), find_highest_common_factor(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()