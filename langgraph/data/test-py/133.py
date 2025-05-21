def sum_squares(lst):
    import math
    squared = 0
    for i in lst:
        squared += math.ceil(i)**2
    return squared

def calculate_total_squared_ceilings(numbers):
    import math
    total = 0
    iterator = iter(numbers)
    while True:
        try:
            number = next(iterator)
            total += math.ceil(number) ** 2
        except StopIteration:
            break
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3],
        [-1.5, 2.3, -3.7],
        [0, 0, 0],
        [4.9, 5.1, 6.5],
        [10, -10, 20],
        [1.1, 1.9, 2.5],
        [-1, -2, -3],
        [],
        [0.99, 1.01, 2.99],
        [5]
    ]

    def test_0(self):
        self.assertEqual(sum_squares(self.test_cases[0]), calculate_total_squared_ceilings(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sum_squares(self.test_cases[1]), calculate_total_squared_ceilings(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sum_squares(self.test_cases[2]), calculate_total_squared_ceilings(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sum_squares(self.test_cases[3]), calculate_total_squared_ceilings(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sum_squares(self.test_cases[4]), calculate_total_squared_ceilings(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sum_squares(self.test_cases[5]), calculate_total_squared_ceilings(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sum_squares(self.test_cases[6]), calculate_total_squared_ceilings(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sum_squares(self.test_cases[7]), calculate_total_squared_ceilings(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sum_squares(self.test_cases[8]), calculate_total_squared_ceilings(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sum_squares(self.test_cases[9]), calculate_total_squared_ceilings(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()