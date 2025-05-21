def max_fill(grid, capacity):
    import math
    return sum([math.ceil(sum(arr)/capacity) for arr in grid])

import math

def calculate_max_load(matrix, limit):
    total_load = 0
    for row in matrix:
        total_load += math.ceil(sum(row) / limit)
    return total_load

# method name: max_fill -> calculate_max_load
# parameter name: grid -> matrix, capacity -> limit
# replaced list comprehension with a for loop to iterate over rows
# used a running total (total_load) instead of summing a list comprehension directly

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([[10, 20], [30, 40]], 10),
        ([[5, 5], [5, 5]], 5),
        ([[1, 1, 1], [2, 2, 2], [3, 3, 3]], 1),
        ([[0, 0], [0, 0]], 1),
        ([[7, 8, 9], [10, 11, 12]], 5),
        ([[100]], 10),
        ([[10, 20, 30], [40, 50, 60]], 25),
        ([[1, 2], [3, 4], [5, 6]], 3),
        ([[15, 15], [15, 15], [15, 15]], 10),
        ([[2, 4, 6], [8, 10, 12], [14, 16, 18]], 7)
    ]

    def test_0(self):
        self.assertEqual(max_fill(self.test_cases[0][0], self.test_cases[0][1]), calculate_max_load(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(max_fill(self.test_cases[1][0], self.test_cases[1][1]), calculate_max_load(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(max_fill(self.test_cases[2][0], self.test_cases[2][1]), calculate_max_load(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(max_fill(self.test_cases[3][0], self.test_cases[3][1]), calculate_max_load(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(max_fill(self.test_cases[4][0], self.test_cases[4][1]), calculate_max_load(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(max_fill(self.test_cases[5][0], self.test_cases[5][1]), calculate_max_load(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(max_fill(self.test_cases[6][0], self.test_cases[6][1]), calculate_max_load(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(max_fill(self.test_cases[7][0], self.test_cases[7][1]), calculate_max_load(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(max_fill(self.test_cases[8][0], self.test_cases[8][1]), calculate_max_load(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(max_fill(self.test_cases[9][0], self.test_cases[9][1]), calculate_max_load(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()