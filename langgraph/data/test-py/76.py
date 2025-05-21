def is_simple_power(x, n):
    if (n == 1): 
        return (x == 1) 
    power = 1
    while (power < x): 
        power = power * n 
    return (power == x) 

def check_power_relation(base, exponent):
    if exponent == 1:
        return base == 1
    
    current_value = 1
    while current_value < base:
        current_value *= exponent
    
    return current_value == base

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, 1),     # True: 1^1 = 1
        (8, 2),     # False: No power of 2 equals 8 exactly within the loop
        (9, 3),     # True: 3^2 = 9
        (27, 3),    # True: 3^3 = 27
        (16, 4),    # True: 4^2 = 16
        (10, 10),   # True: 10^1 = 10
        (256, 2),   # True: 2^8 = 256
        (1, 5),     # False: 5^0 = 1, but loop condition fails for x > 1 when n > 1
        (0, 2),     # False: No power of 2 equals 0
        (7, 3)      # False: No power of 3 equals 7 exactly within the loop
    ]

    def test_0(self):
        self.assertEqual(is_simple_power(*self.test_cases[0]), check_power_relation(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_simple_power(*self.test_cases[1]), check_power_relation(*self.test_cases[1]))

    def test_2(self):
        self.assertEqual(is_simple_power(*self.test_cases[2]), check_power_relation(*self.test_cases[2]))

    def test_3(self):
        self.assertEqual(is_simple_power(*self.test_cases[3]), check_power_relation(*self.test_cases[3]))

    def test_4(self):
        self.assertEqual(is_simple_power(*self.test_cases[4]), check_power_relation(*self.test_cases[4]))

    def test_5(self):
        self.assertEqual(is_simple_power(*self.test_cases[5]), check_power_relation(*self.test_cases[5]))

    def test_6(self):
        self.assertEqual(is_simple_power(*self.test_cases[6]), check_power_relation(*self.test_cases[6]))

    def test_7(self):
        self.assertEqual(is_simple_power(*self.test_cases[7]), check_power_relation(*self.test_cases[7]))

    def test_8(self):
        self.assertEqual(is_simple_power(*self.test_cases[8]), check_power_relation(*self.test_cases[8]))

    def test_9(self):
        self.assertEqual(is_simple_power(*self.test_cases[9]), check_power_relation(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()