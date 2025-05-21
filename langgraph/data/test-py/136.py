# Source Code
def largest_smallest_integers(lst):
    smallest = list(filter(lambda x: x < 0, lst))
    largest = list(filter(lambda x: x > 0, lst))
    return (max(smallest) if smallest else None, min(largest) if largest else None)

# Transformed Code (Semantically Equivalent)
def find_extreme_values(numbers):
    negative_numbers = [num for num in numbers if num < 0]
    positive_numbers = [num for num in numbers if num > 0]

    max_negative = max(negative_numbers) if negative_numbers else None
    min_positive = min(positive_numbers) if positive_numbers else None

    return (max_negative, min_positive)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, -1, -2, -3],  # Mixed negatives and positives
        [-5, -4, -3, -2, -1],     # All negatives
        [5, 4, 3, 2, 1],          # All positives
        [0, 0, 0],                # Only zeros
        [],                       # Empty list
        [-10, 0, 10],             # Single negative and positive
        [-1, -2, 0, 2, 1],        # Mixed with zero
        [100],                    # Single positive
        [-100],                   # Single negative
        [1, -1, 2, -2, 3, -3]     # Alternating positives and negatives
    ]

    def test_0(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[0]), find_extreme_values(self.test_cases[0]))

    def test_1(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[1]), find_extreme_values(self.test_cases[1]))

    def test_2(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[2]), find_extreme_values(self.test_cases[2]))

    def test_3(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[3]), find_extreme_values(self.test_cases[3]))

    def test_4(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[4]), find_extreme_values(self.test_cases[4]))

    def test_5(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[5]), find_extreme_values(self.test_cases[5]))

    def test_6(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[6]), find_extreme_values(self.test_cases[6]))

    def test_7(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[7]), find_extreme_values(self.test_cases[7]))

    def test_8(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[8]), find_extreme_values(self.test_cases[8]))

    def test_9(self):
        self.assertEqual(largest_smallest_integers(self.test_cases[9]), find_extreme_values(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()