def special_factorial(n):
    fact_i = 1
    special_fact = 1
    for i in range(1, n+1):
        fact_i *= i
        special_fact *= fact_i
    return special_fact

def compute_special_product(n):
    current_factorial = 1
    cumulative_product = 1
    index = 1

    while index <= n:
        current_factorial *= index
        cumulative_product *= current_factorial
        index += 1

    return cumulative_product

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,      # Edge case: n = 0
        1,      # Simple case: n = 1
        2,      # Simple case: n = 2
        3,      # Simple case: n = 3
        4,      # Simple case: n = 4
        5,      # Simple case: n = 5
        6,      # Simple case: n = 6
        10,     # Larger number: n = 10
        20,     # Larger number: n = 20
        100     # Very large number: n = 100
    ]

    def test_0(self):
        self.assertEqual(special_factorial(self.test_cases[0]), compute_special_product(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(special_factorial(self.test_cases[1]), compute_special_product(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(special_factorial(self.test_cases[2]), compute_special_product(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(special_factorial(self.test_cases[3]), compute_special_product(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(special_factorial(self.test_cases[4]), compute_special_product(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(special_factorial(self.test_cases[5]), compute_special_product(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(special_factorial(self.test_cases[6]), compute_special_product(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(special_factorial(self.test_cases[7]), compute_special_product(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(special_factorial(self.test_cases[8]), compute_special_product(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(special_factorial(self.test_cases[9]), compute_special_product(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()