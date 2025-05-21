def double_the_difference(lst):
    return sum([i**2 for i in lst if i > 0 and i%2!=0 and "." not in str(i)])

def calculate_modified_sum(numbers):
    total = 0
    for num in numbers:
        if num > 0 and num % 2 != 0 and isinstance(num, int):
            total += num ** 2
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],         # Mixed positive odd/even integers
        [-1, -3, -5, 0, 2, 4],   # Negative numbers and zero
        [7, 11, 13, 17],         # Only positive odd integers
        [8, 10, 12, 14],         # Only positive even integers
        [1.5, 3.5, 5.5],         # Floating point numbers
        [],                      # Empty list
        [1, 1.1, 3, 3.3, 5, 5.5],# Mixed integers and floats
        [21, 23, 25, 0, -27],    # Positive odd integers with zero and negative
        [9, 8, 7, 6, 5, 4, 3, 2, 1], # Descending order mixed odd/even integers
        [0]                      # Single element zero
    ]

    def test_0(self):
        self.assertEqual(double_the_difference(self.test_cases[0]), calculate_modified_sum(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(double_the_difference(self.test_cases[1]), calculate_modified_sum(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(double_the_difference(self.test_cases[2]), calculate_modified_sum(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(double_the_difference(self.test_cases[3]), calculate_modified_sum(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(double_the_difference(self.test_cases[4]), calculate_modified_sum(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(double_the_difference(self.test_cases[5]), calculate_modified_sum(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(double_the_difference(self.test_cases[6]), calculate_modified_sum(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(double_the_difference(self.test_cases[7]), calculate_modified_sum(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(double_the_difference(self.test_cases[8]), calculate_modified_sum(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(double_the_difference(self.test_cases[9]), calculate_modified_sum(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()