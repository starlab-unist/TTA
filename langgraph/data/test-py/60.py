def sum_to_n(n: int):
    return sum(range(n + 1))

def calculate_total_up_to(number: int):
    total_sum = 0
    current = 0
    
    while current <= number:
        total_sum += current
        current += 1
    
    return total_sum

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,      # Edge case: smallest possible input
        1,      # Simple case
        5,      # Small positive integer
        10,     # Medium positive integer
        20,     # Larger positive integer
        100,    # Large positive integer
        -1,     # Negative number (edge case)
        -5,     # Another negative number
        1000,   # Very large positive integer
        1       # Repeated simple case
    ]

    def test_0(self):
        self.assertEqual(sum_to_n(self.test_cases[0]), calculate_total_up_to(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sum_to_n(self.test_cases[1]), calculate_total_up_to(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sum_to_n(self.test_cases[2]), calculate_total_up_to(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sum_to_n(self.test_cases[3]), calculate_total_up_to(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sum_to_n(self.test_cases[4]), calculate_total_up_to(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sum_to_n(self.test_cases[5]), calculate_total_up_to(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sum_to_n(self.test_cases[6]), calculate_total_up_to(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sum_to_n(self.test_cases[7]), calculate_total_up_to(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sum_to_n(self.test_cases[8]), calculate_total_up_to(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sum_to_n(self.test_cases[9]), calculate_total_up_to(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()