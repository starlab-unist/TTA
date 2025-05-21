from typing import List
import collections

# Source Code
def remove_duplicates(numbers: List[int]) -> List[int]:
    c = collections.Counter(numbers)
    return [n for n in numbers if c[n] <= 1]

# Transformed Code (Semantically Equivalent)
def filter_unique_elements(num_list: List[int]) -> List[int]:
    count_map = collections.Counter(num_list)
    unique_numbers = [num for num in num_list if count_map[num] == 1]
    return unique_numbers

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    def setUp(self):
        self.test_cases = [
            ([1, 2, 2, 3, 4, 4, 5], [1, 3, 5]),
            ([10, 20, 20, 30, 30, 30, 40], [10, 40]),
            ([1, 1, 1, 1, 1], []),
            ([5, 7, 8, 9, 10], [5, 7, 8, 9, 10]),
            ([], []),
            ([123, 456, 789], [123, 456, 789]),
            ([1, 2, 3, 4, 5, 1, 2, 3, 4, 5], []),
            ([0, 0, 0, 1, 1, 1, 2, 2, 3], [3]),
            ([7, 8, 9, 7, 8, 10], [9, 10]),
            ([42], [42])
        ]

    def test_0(self):
        self.assertEqual(remove_duplicates(self.test_cases[0][0]), filter_unique_elements(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(remove_duplicates(self.test_cases[1][0]), filter_unique_elements(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(remove_duplicates(self.test_cases[2][0]), filter_unique_elements(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(remove_duplicates(self.test_cases[3][0]), filter_unique_elements(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(remove_duplicates(self.test_cases[4][0]), filter_unique_elements(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(remove_duplicates(self.test_cases[5][0]), filter_unique_elements(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(remove_duplicates(self.test_cases[6][0]), filter_unique_elements(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(remove_duplicates(self.test_cases[7][0]), filter_unique_elements(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(remove_duplicates(self.test_cases[8][0]), filter_unique_elements(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(remove_duplicates(self.test_cases[9][0]), filter_unique_elements(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()