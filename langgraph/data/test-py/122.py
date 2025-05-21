def add_elements(arr, k):
    return sum(elem for elem in arr[:k] if len(str(elem)) <= 2)

def calculate_sum_of_small_numbers(numbers, count):
    total = 0
    index = 0
    
    while index < count and index < len(numbers):
        if len(str(numbers[index])) <= 2:
            total += numbers[index]
        index += 1
    
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 10, 100, 1000], 3),
        ([5, 23, 456, 7890], 4),
        ([99, 100, 101, 102], 2),
        ([1, 2, 3, 4, 5], 5),
        ([123, 45, 67, 89, 10], 5),
        ([111, 222, 333, 44, 55], 3),
        ([1, 1, 1, 1, 1], 1),
        ([], 1),
        ([10, 20, 30, 40, 50], 0),
        ([9, 8, 7, 6, 5], 5)
    ]

    def test_0(self):
        self.assertEqual(add_elements(self.test_cases[0][0], self.test_cases[0][1]), calculate_sum_of_small_numbers(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(add_elements(self.test_cases[1][0], self.test_cases[1][1]), calculate_sum_of_small_numbers(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(add_elements(self.test_cases[2][0], self.test_cases[2][1]), calculate_sum_of_small_numbers(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(add_elements(self.test_cases[3][0], self.test_cases[3][1]), calculate_sum_of_small_numbers(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(add_elements(self.test_cases[4][0], self.test_cases[4][1]), calculate_sum_of_small_numbers(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(add_elements(self.test_cases[5][0], self.test_cases[5][1]), calculate_sum_of_small_numbers(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(add_elements(self.test_cases[6][0], self.test_cases[6][1]), calculate_sum_of_small_numbers(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(add_elements(self.test_cases[7][0], self.test_cases[7][1]), calculate_sum_of_small_numbers(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(add_elements(self.test_cases[8][0], self.test_cases[8][1]), calculate_sum_of_small_numbers(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(add_elements(self.test_cases[9][0], self.test_cases[9][1]), calculate_sum_of_small_numbers(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()