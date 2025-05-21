# Source Code
def sum_squares(lst):
    """
    This function processes a list of numbers, squaring elements at indices divisible by 3,
    cubing elements at indices divisible by 4 but not 3, and leaving other elements unchanged.
    It then returns the sum of the processed list.
    """
    result = []
    for i in range(len(lst)):
        if i % 3 == 0:
            result.append(lst[i] ** 2)
        elif i % 4 == 0 and i % 3 != 0:
            result.append(lst[i] ** 3)
        else:
            result.append(lst[i])
    return sum(result)

# Transformed Code (Semantically Equivalent)
def calculate_special_sum(numbers):
    """
    This function processes a list of numbers, squaring elements at indices divisible by 3,
    cubing elements at indices divisible by 4 but not 3, and leaving other elements unchanged.
    It then returns the sum of the processed list.
    """
    transformed_numbers = []

    index = 0
    while index < len(numbers):
        if index % 3 == 0:
            transformed_numbers.append(numbers[index] ** 2)
        elif index % 4 == 0 and index % 3 != 0:
            transformed_numbers.append(numbers[index] ** 3)
        else:
            transformed_numbers.append(numbers[index])
        
        index += 1

    return sum(transformed_numbers)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],          # Simple list with small integers
        [0, 0, 0, 0, 0],          # List of zeros
        [1, 1, 1, 1, 1],          # List of ones
        [-1, -2, -3, -4, -5],     # Simple list with negative integers
        [10, 20, 30, 40, 50],     # List of larger integers
        [9, 8, 7, 6, 5],          # Decreasing list of integers
        [1, -1, 1, -1, 1],        # Alternating positive and negative integers
        [],                       # Empty list
        [2, 3, 4, 5, 6, 7, 8],    # Simple list with small integers
        [5, 0, 10, 0, 15]         # List containing zeros
    ]

    def test_0(self):
        self.assertEqual(sum_squares(self.test_cases[0]), calculate_special_sum(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sum_squares(self.test_cases[1]), calculate_special_sum(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sum_squares(self.test_cases[2]), calculate_special_sum(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sum_squares(self.test_cases[3]), calculate_special_sum(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sum_squares(self.test_cases[4]), calculate_special_sum(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sum_squares(self.test_cases[5]), calculate_special_sum(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sum_squares(self.test_cases[6]), calculate_special_sum(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sum_squares(self.test_cases[7]), calculate_special_sum(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sum_squares(self.test_cases[8]), calculate_special_sum(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sum_squares(self.test_cases[9]), calculate_special_sum(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()