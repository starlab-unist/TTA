def is_equal_to_sum_even(n):
    return n % 2 == 0 and n >= 8

def check_even_and_minimum_eight(number):
    return number % 2 == 0 and number >= 8

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (4, False),
        (6, False),
        (8, True),
        (10, True),
        (12, True),
        (7, False),
        (9, False),
        (0, False),
        (-2, False),
        (8.0, True),  # Edge case: float that is an integer
        (10.5, False)  # Edge case: non-integer float
    ]

    def test_0(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[0][0]), check_even_and_minimum_eight(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[1][0]), check_even_and_minimum_eight(self.test_cases[1][0]))

    def test_2(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[2][0]), check_even_and_minimum_eight(self.test_cases[2][0]))

    def test_3(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[3][0]), check_even_and_minimum_eight(self.test_cases[3][0]))

    def test_4(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[4][0]), check_even_and_minimum_eight(self.test_cases[4][0]))

    def test_5(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[5][0]), check_even_and_minimum_eight(self.test_cases[5][0]))

    def test_6(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[6][0]), check_even_and_minimum_eight(self.test_cases[6][0]))

    def test_7(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[7][0]), check_even_and_minimum_eight(self.test_cases[7][0]))

    def test_8(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[8][0]), check_even_and_minimum_eight(self.test_cases[8][0]))

    def test_9(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[9][0]), check_even_and_minimum_eight(self.test_cases[9][0]))

    def test_10(self):
        self.assertEqual(is_equal_to_sum_even(self.test_cases[10][0]), check_even_and_minimum_eight(self.test_cases[10][0]))

if __name__ == '__main__':
    unittest.main()