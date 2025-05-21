def below_threshold(l: list, t: int):
    for e in l:
        if e >= t:
            return False
    return True

def all_elements_under_limit(elements: list, threshold: int):
    index = 0
    while index < len(elements):
        if elements[index] >= threshold:
            return False
        index += 1
    return True

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([], 10),                     # Empty list
        ([1, 2, 3, 4], 5),           # All elements below threshold
        ([10, 20, 30], 10),          # First element equals threshold
        ([5, 6, 7, 8], 5),           # First element equals threshold
        ([1, 2, 3, 4, 10], 5),       # One element above threshold
        ([9, 8, 7, 6, 5], 10),       # All elements below threshold
        ([10, 9, 8, 7, 6], 10),      # First element equals threshold
        ([1, 2, 3, 4, 5], 1),        # Threshold less than all elements
        ([0, -1, -2, -3], 0),        # Negative numbers below threshold
        ([-1, -2, -3, 0], 0)         # Negative numbers below threshold with zero
    ]

    def test_0(self):
        self.assertEqual(below_threshold(self.test_cases[0][0], self.test_cases[0][1]), all_elements_under_limit(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(below_threshold(self.test_cases[1][0], self.test_cases[1][1]), all_elements_under_limit(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(below_threshold(self.test_cases[2][0], self.test_cases[2][1]), all_elements_under_limit(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(below_threshold(self.test_cases[3][0], self.test_cases[3][1]), all_elements_under_limit(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(below_threshold(self.test_cases[4][0], self.test_cases[4][1]), all_elements_under_limit(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(below_threshold(self.test_cases[5][0], self.test_cases[5][1]), all_elements_under_limit(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(below_threshold(self.test_cases[6][0], self.test_cases[6][1]), all_elements_under_limit(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(below_threshold(self.test_cases[7][0], self.test_cases[7][1]), all_elements_under_limit(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(below_threshold(self.test_cases[8][0], self.test_cases[8][1]), all_elements_under_limit(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(below_threshold(self.test_cases[9][0], self.test_cases[9][1]), all_elements_under_limit(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()