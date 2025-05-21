from typing import List, Tuple
import unittest

# Source Code
def find_closest_elements(numbers: List[float]) -> Tuple[float, float]:
    closest_pair = None
    distance = None

    for idx, elem in enumerate(numbers):
        for idx2, elem2 in enumerate(numbers):
            if idx != idx2:
                if distance is None:
                    distance = abs(elem - elem2)
                    closest_pair = tuple(sorted([elem, elem2]))
                else:
                    new_distance = abs(elem - elem2)
                    if new_distance < distance:
                        distance = new_distance
                        closest_pair = tuple(sorted([elem, elem2]))

    return closest_pair

# Transformed Code (Semantically Equivalent)
def determine_nearest_pair(values: List[float]) -> Tuple[float, float]:
    nearest_pair = None
    min_gap = None

    index = 0
    while index < len(values):
        inner_index = 0
        while inner_index < len(values):
            if index != inner_index:
                current_difference = abs(values[index] - values[inner_index])
                if min_gap is None or current_difference < min_gap:
                    min_gap = current_difference
                    nearest_pair = tuple(sorted([values[index], values[inner_index]]))
            inner_index += 1
        index += 1

    return nearest_pair


# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1.0, 2.0, 3.0, 4.0],
        [5.5, 3.3, 2.2, 8.8, 9.9],
        [-1.0, -2.0, -3.0, -4.0],
        [10.0, 10.0, 10.0, 10.0],
        [0.1, 0.2, 0.3, 0.4, 0.5],
        [100.0, 99.0, 101.0, 98.0],
        [0.0, 0.0, 0.0, 0.0],
        [1.5, 2.5, 3.5, 4.5],
        [1000.1, 1000.2, 999.9, 1001.1],
        [1.0]
    ]

    def test_0(self):
        self.assertEqual(find_closest_elements(self.test_cases[0]), determine_nearest_pair(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(find_closest_elements(self.test_cases[1]), determine_nearest_pair(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(find_closest_elements(self.test_cases[2]), determine_nearest_pair(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(find_closest_elements(self.test_cases[3]), determine_nearest_pair(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(find_closest_elements(self.test_cases[4]), determine_nearest_pair(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(find_closest_elements(self.test_cases[5]), determine_nearest_pair(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(find_closest_elements(self.test_cases[6]), determine_nearest_pair(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(find_closest_elements(self.test_cases[7]), determine_nearest_pair(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(find_closest_elements(self.test_cases[8]), determine_nearest_pair(self.test_cases[8]))
    
    def test_9(self):
        # This case should handle the scenario where there is only one element in the list.
        # The function should return None as there are no pairs to compare.
        self.assertIsNone(find_closest_elements(self.test_cases[9]))
        self.assertIsNone(determine_nearest_pair(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()