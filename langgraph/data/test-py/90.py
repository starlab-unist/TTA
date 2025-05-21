# Source Code
def next_smallest(lst):
    lst = sorted(set(lst))
    return None if len(lst) < 2 else lst[1]

# Transformed Code (Semantically Equivalent)
def find_second_minimum(numbers):
    unique_numbers = sorted(list(set(numbers)))

    if len(unique_numbers) < 2:
        return None

    return unique_numbers[1]

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([3, 1, 4, 1, 5, 9], 3),
        ([10, 20, 20, 10, 30], 20),
        ([1, 2, 3, 4, 5], 2),
        ([5, 5, 5, 5, 5], None),
        ([7], None),
        ([], None),
        ([9, 8, 7, 6, 5, 4, 3, 2, 1], 2),
        ([0, -1, -2, -3, -4], -3),
        ([-10, -20, -10, -30, -20], -20),
        ([100, 200, 300, 100, 200, 300], 200)
    ]

    def test_0(self):
        self.assertEqual(next_smallest(self.test_cases[0][0]), find_second_minimum(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(next_smallest(self.test_cases[1][0]), find_second_minimum(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(next_smallest(self.test_cases[2][0]), find_second_minimum(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(next_smallest(self.test_cases[3][0]), find_second_minimum(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(next_smallest(self.test_cases[4][0]), find_second_minimum(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(next_smallest(self.test_cases[5][0]), find_second_minimum(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(next_smallest(self.test_cases[6][0]), find_second_minimum(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(next_smallest(self.test_cases[7][0]), find_second_minimum(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(next_smallest(self.test_cases[8][0]), find_second_minimum(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(next_smallest(self.test_cases[9][0]), find_second_minimum(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()