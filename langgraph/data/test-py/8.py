from typing import List, Tuple
import unittest


# Source Code
def sum_product(numbers: List[int]) -> Tuple[int, int]:
    sum_value = 0
    prod_value = 1

    for n in numbers:
        sum_value += n
        prod_value *= n
    return sum_value, prod_value


# Transformed Code (Semantically Equivalent)
def calculate_aggregates(values: List[int]) -> Tuple[int, int]:
    total_sum = 0
    cumulative_product = 1

    index = 0
    while index < len(values):
        total_sum += values[index]
        cumulative_product *= values[index]
        index += 1

    return total_sum, cumulative_product


# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([], (0, 1)),
        ([1], (1, 1)),
        ([2, 3], (5, 6)),
        ([4, 5, 6], (15, 120)),
        ([7, 8, 9, 10], (34, 5040)),
        ([0, 1, 2, 3], (6, 0)),
        ([1, -1, 1, -1], (0, 1)),
        ([10, 20, 30], (60, 6000)),
        ([5, 5, 5, 5], (20, 625)),
        ([1, 2, 3, 4, 5], (15, 120))
    ]

    def test_0(self):
        self.assertEqual(sum_product(self.test_cases[0][0]), calculate_aggregates(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(sum_product(self.test_cases[1][0]), calculate_aggregates(self.test_cases[1][0]))

    def test_2(self):
        self.assertEqual(sum_product(self.test_cases[2][0]), calculate_aggregates(self.test_cases[2][0]))

    def test_3(self):
        self.assertEqual(sum_product(self.test_cases[3][0]), calculate_aggregates(self.test_cases[3][0]))

    def test_4(self):
        self.assertEqual(sum_product(self.test_cases[4][0]), calculate_aggregates(self.test_cases[4][0]))

    def test_5(self):
        self.assertEqual(sum_product(self.test_cases[5][0]), calculate_aggregates(self.test_cases[5][0]))

    def test_6(self):
        self.assertEqual(sum_product(self.test_cases[6][0]), calculate_aggregates(self.test_cases[6][0]))

    def test_7(self):
        self.assertEqual(sum_product(self.test_cases[7][0]), calculate_aggregates(self.test_cases[7][0]))

    def test_8(self):
        self.assertEqual(sum_product(self.test_cases[8][0]), calculate_aggregates(self.test_cases[8][0]))

    def test_9(self):
        self.assertEqual(sum_product(self.test_cases[9][0]), calculate_aggregates(self.test_cases[9][0]))


if __name__ == '__main__':
    unittest.main()