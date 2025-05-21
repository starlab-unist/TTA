from typing import List
import unittest

# Source Code
def has_close_elements(numbers: List[float], threshold: float) -> bool:
    for idx, elem in enumerate(numbers):
        for idx2, elem2 in enumerate(numbers):
            if idx != idx2:
                distance = abs(elem - elem2)
                if distance < threshold:
                    return True

    return False

# Transformed Code (Semantically Equivalent)
def contains_nearby_elements(values: List[float], limit: float) -> bool:
    index = 0
    while index < len(values):
        inner_index = 0
        while inner_index < len(values):
            if index != inner_index:
                gap = abs(values[index] - values[inner_index])
                if gap < limit:
                    return True
            inner_index += 1
        index += 1

    return False

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1.0, 2.0, 3.0], 0.5),
        ([1.0, 2.0, 3.0], 1.5),
        ([1.1, 2.2, 3.3], 0.1),
        ([1.1, 2.2, 3.3], 1.2),
        ([0.0, 0.0, 0.0], 0.0),
        ([0.0, 0.1, 0.2], 0.05),
        ([5.0, 4.9, 4.8], 0.2),
        ([10.0, 20.0, 30.0], 5.0),
        ([1.0, 1.0, 1.0, 1.0], 0.1),
        ([1.0, 2.0, 3.0, 4.0, 5.0], 1.1)
    ]

    expected_results = [
        False,
        True,
        False,
        True,
        True,
        False,
        True,
        False,
        True,
        True
    ]

    def test_0(self):
        self.assertEqual(has_close_elements(self.test_cases[0][0], self.test_cases[0][1]), contains_nearby_elements(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(has_close_elements(self.test_cases[1][0], self.test_cases[1][1]), contains_nearby_elements(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(has_close_elements(self.test_cases[2][0], self.test_cases[2][1]), contains_nearby_elements(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(has_close_elements(self.test_cases[3][0], self.test_cases[3][1]), contains_nearby_elements(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(has_close_elements(self.test_cases[4][0], self.test_cases[4][1]), contains_nearby_elements(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(has_close_elements(self.test_cases[5][0], self.test_cases[5][1]), contains_nearby_elements(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(has_close_elements(self.test_cases[6][0], self.test_cases[6][1]), contains_nearby_elements(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(has_close_elements(self.test_cases[7][0], self.test_cases[7][1]), contains_nearby_elements(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(has_close_elements(self.test_cases[8][0], self.test_cases[8][1]), contains_nearby_elements(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(has_close_elements(self.test_cases[9][0], self.test_cases[9][1]), contains_nearby_elements(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()