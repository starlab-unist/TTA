from typing import List, Tuple

# Source Code
def rolling_max(numbers: List[int]) -> List[int]:
    running_max = None
    result = []

    for n in numbers:
        if running_max is None:
            running_max = n
        else:
            running_max = max(running_max, n)

        result.append(running_max)

    return result

# Transformed Code (Semantically Equivalent)
def compute_rolling_maximum(values: List[int]) -> List[int]:
    current_max = None
    max_history = []

    index = 0
    while index < len(values):
        if current_max is None:
            current_max = values[index]
        elif values[index] > current_max:
            current_max = values[index]

        max_history.append(current_max)
        index += 1

    return max_history

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([], []),
        ([5], [5]),
        ([1, 2, 3, 4, 5], [1, 2, 3, 4, 5]),
        ([5, 4, 3, 2, 1], [5, 5, 5, 5, 5]),
        ([1, 5, 3, 6, 2], [1, 5, 5, 6, 6]),
        ([3, 3, 3, 3, 3], [3, 3, 3, 3, 3]),
        ([10, 9, 8, 7, 11], [10, 10, 10, 10, 11]),
        ([1, 2], [1, 2]),
        ([2, 1], [2, 2]),
        ([1], [1])
    ]

    def test_0(self):
        self.assertEqual(rolling_max(self.test_cases[0]), compute_rolling_maximum(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(rolling_max(self.test_cases[1]), compute_rolling_maximum(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(rolling_max(self.test_cases[2]), compute_rolling_maximum(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(rolling_max(self.test_cases[3]), compute_rolling_maximum(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(rolling_max(self.test_cases[4]), compute_rolling_maximum(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(rolling_max(self.test_cases[5]), compute_rolling_maximum(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(rolling_max(self.test_cases[6]), compute_rolling_maximum(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(rolling_max(self.test_cases[7]), compute_rolling_maximum(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(rolling_max(self.test_cases[8]), compute_rolling_maximum(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(rolling_max(self.test_cases[9]), compute_rolling_maximum(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()