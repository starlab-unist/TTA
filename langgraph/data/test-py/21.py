from typing import List
import unittest

# Source Code
def rescale_to_unit(numbers: List[float]) -> List[float]:
    min_number = min(numbers)
    max_number = max(numbers)
    return [(x - min_number) / (max_number - min_number) for x in numbers]

# Transformed Code (Semantically Equivalent)
def normalize_values(values: List[float]) -> List[float]:
    smallest_value = min(values)
    largest_value = max(values)
    
    normalized_list = []
    for value in values:
        normalized_value = (value - smallest_value) / (largest_value - smallest_value)
        normalized_list.append(normalized_value)
    
    return normalized_list

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1.0, 2.0, 3.0, 4.0, 5.0],
        [10.0, 20.0, 30.0, 40.0, 50.0],
        [5.0, 5.0, 5.0, 5.0],
        [-1.0, -2.0, -3.0, -4.0, -5.0],
        [0.0, 100.0],
        [3.14, 2.71, 1.618, 0.577],
        [100.0, 200.0, 300.0, 400.0, 500.0],
        [1.0, 1.0, 2.0, 2.0, 3.0, 3.0],
        [-5.0, 0.0, 5.0],
        [1000.0]
    ]

    def test_0(self):
        self.assertEqual(rescale_to_unit(self.test_cases[0]), normalize_values(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(rescale_to_unit(self.test_cases[1]), normalize_values(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(rescale_to_unit(self.test_cases[2]), normalize_values(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(rescale_to_unit(self.test_cases[3]), normalize_values(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(rescale_to_unit(self.test_cases[4]), normalize_values(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(rescale_to_unit(self.test_cases[5]), normalize_values(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(rescale_to_unit(self.test_cases[6]), normalize_values(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(rescale_to_unit(self.test_cases[7]), normalize_values(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(rescale_to_unit(self.test_cases[8]), normalize_values(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(rescale_to_unit(self.test_cases[9]), normalize_values(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()