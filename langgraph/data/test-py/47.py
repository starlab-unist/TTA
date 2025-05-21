# Source Code
def median(l: list):
    l = sorted(l)
    if len(l) % 2 == 1:
        return l[len(l) // 2]
    else:
        return (l[len(l) // 2 - 1] + l[len(l) // 2]) / 2.0

# Transformed Code (Semantically Equivalent)
def calculate_median(values: list):
    sorted_values = sorted(values)
    mid_index = len(sorted_values) // 2
    
    if len(sorted_values) % 2 == 0:
        return (sorted_values[mid_index - 1] + sorted_values[mid_index]) / 2.0
    else:
        return sorted_values[mid_index]

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([3, 1, 2], 2),
        ([4, 1, 3, 2], 2.5),
        ([7], 7),
        ([8, 9], 8.5),
        ([10, 2, 5, 1, 8, 9, 3], 5),
        ([5, 5, 5, 5, 5], 5),
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5.5),
        ([100, 200, 300, 400, 500, 600, 700, 800, 900, 1000], 550.0),
        ([1.5, 2.5, 3.5], 2.5),
        ([-1, -2, -3, -4, -5], -3)
    ]

    def test_0(self):
        self.assertEqual(median(self.test_cases[0][0]), calculate_median(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(median(self.test_cases[1][0]), calculate_median(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(median(self.test_cases[2][0]), calculate_median(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(median(self.test_cases[3][0]), calculate_median(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(median(self.test_cases[4][0]), calculate_median(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(median(self.test_cases[5][0]), calculate_median(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(median(self.test_cases[6][0]), calculate_median(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(median(self.test_cases[7][0]), calculate_median(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(median(self.test_cases[8][0]), calculate_median(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(median(self.test_cases[9][0]), calculate_median(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()