from typing import List
import unittest


# Source Code
def mean_absolute_deviation(numbers: List[float]) -> float:
    mean = sum(numbers) / len(numbers)
    return sum(abs(x - mean) for x in numbers) / len(numbers)


# Transformed Code (Semantically Equivalent)
def calculate_mean_abs_dev(values: List[float]) -> float:
    average = sum(values) / len(values)
    deviation_sum = sum(abs(value - average) for value in values)
    return deviation_sum / len(values)


# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1.0, 2.0, 3.0], 0.6666666666666666),
        ([4.0, 5.0, 6.0, 7.0], 1.0),
        ([10.0, 10.0, 10.0], 0.0),
        ([1.0, 1.0, 2.0, 3.0, 4.0], 1.2),
        ([5.5, 5.5, 5.5, 5.5], 0.0),
        ([1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0], 2.5),
        ([0.0, 0.0, 0.0, 0.0, 0.0], 0.0),
        ([1.5, 2.5, 3.5, 4.5, 5.5], 1.2),
        ([100.0, 200.0, 300.0], 66.66666666666667),
        ([1.1, 2.2, 3.3, 4.4, 5.5], 1.32)
    ]

    def test_0(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[0][0]), calculate_mean_abs_dev(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[1][0]), calculate_mean_abs_dev(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[2][0]), calculate_mean_abs_dev(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[3][0]), calculate_mean_abs_dev(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[4][0]), calculate_mean_abs_dev(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[5][0]), calculate_mean_abs_dev(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[6][0]), calculate_mean_abs_dev(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[7][0]), calculate_mean_abs_dev(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[8][0]), calculate_mean_abs_dev(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(mean_absolute_deviation(self.test_cases[9][0]), calculate_mean_abs_dev(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()