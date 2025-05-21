# Source Code
def solution(lst):
    return sum([x for idx, x in enumerate(lst) if idx % 2 == 0 and x % 2 == 1])

# Transformed Code (Semantically Equivalent)
def calculate_odd_sum_at_even_indices(numbers):
    total = 0
    index = 0
    while index < len(numbers):
        if index % 2 == 0 and numbers[index] % 2 == 1:
            total += numbers[index]
        index += 1
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],          # Expected output: 9 (1 + 3 + 5)
        [2, 4, 6, 8, 10],         # Expected output: 0
        [1, 3, 5, 7, 9],          # Expected output: 15 (1 + 5 + 9)
        [],                       # Expected output: 0
        [1],                      # Expected output: 1
        [2, 2, 2, 2, 2, 2],       # Expected output: 0
        [1, 1, 1, 1, 1, 1],       # Expected output: 3 (1 + 1 + 1)
        [0, 1, 2, 3, 4, 5, 6],    # Expected output: 9 (1 + 3 + 5)
        [7, 8, 9, 10, 11, 12],    # Expected output: 18 (7 + 9 + 11)
        [13, 14, 15, 16, 17, 18]  # Expected output: 45 (13 + 15 + 17)
    ]

    def test_0(self):
        self.assertEqual(solution(self.test_cases[0]), calculate_odd_sum_at_even_indices(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(solution(self.test_cases[1]), calculate_odd_sum_at_even_indices(self.test_cases[1]))

    def test_2(self):
        self.assertEqual(solution(self.test_cases[2]), calculate_odd_sum_at_even_indices(self.test_cases[2]))

    def test_3(self):
        self.assertEqual(solution(self.test_cases[3]), calculate_odd_sum_at_even_indices(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(solution(self.test_cases[4]), calculate_odd_sum_at_even_indices(self.test_cases[4]))

    def test_5(self):
        self.assertEqual(solution(self.test_cases[5]), calculate_odd_sum_at_even_indices(self.test_cases[5]))

    def test_6(self):
        self.assertEqual(solution(self.test_cases[6]), calculate_odd_sum_at_even_indices(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(solution(self.test_cases[7]), calculate_odd_sum_at_even_indices(self.test_cases[7]))

    def test_8(self):
        self.assertEqual(solution(self.test_cases[8]), calculate_odd_sum_at_even_indices(self.test_cases[8]))

    def test_9(self):
        self.assertEqual(solution(self.test_cases[9]), calculate_odd_sum_at_even_indices(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()