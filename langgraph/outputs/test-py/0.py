from typing import List


def has_close_elements(numbers: List[float], threshold: float) -> bool:
    for idx, elem in enumerate(numbers):
        for idx2, elem2 in enumerate(numbers):
            if idx != idx2:
                distance = abs(elem - elem2)
                if distance < threshold:
                    return True

    return False

from typing import List
import itertools

def contains_nearby_pairs(values: List[float], max_distance: float) -> bool:
    for first, second in itertools.combinations(values, 2):
        if abs(first - second) < max_distance:
            return True
    return False

import unittest

class TestFunctionEquivalence(unittest.TestCase):
    test_cases = [
        ([1.0, 2.0, 3.0], 1.0),
        ([1.0, 1.5, 3.0], 1.0),
        ([1.0, 1.0, 3.0], 0.1),
        ([1.0, 2.0, 3.0], 0.5),
        ([], 0.5),
        ([5.0], 0.5),
        ([1.0, 2.0, 1.0], 0.5),
        ([1.0, 3.0, 5.0], 2.1),
        ([1.0, 3.0, 5.0], 2.0),
        ([1.0, 3.0, 5.0, 1.5], 0.6)
    ]

    def test_0(self):
        self.assertEqual(has_close_elements(*self.test_cases[0]), contains_nearby_pairs(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(has_close_elements(*self.test_cases[1]), contains_nearby_pairs(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(has_close_elements(*self.test_cases[2]), contains_nearby_pairs(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(has_close_elements(*self.test_cases[3]), contains_nearby_pairs(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(has_close_elements(*self.test_cases[4]), contains_nearby_pairs(*self.test_cases[4]))
    
    def test_5(self):
        self.assertEqual(has_close_elements(*self.test_cases[5]), contains_nearby_pairs(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(has_close_elements(*self.test_cases[6]), contains_nearby_pairs(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(has_close_elements(*self.test_cases[7]), contains_nearby_pairs(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(has_close_elements(*self.test_cases[8]), contains_nearby_pairs(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(has_close_elements(*self.test_cases[9]), contains_nearby_pairs(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()