# Source Code (original_function)
def largest_divisor(n: int) -> int:
    for i in reversed(range(n)):
        if n % i == 0:
            return i

# Transformed Code (transformed_function)
def find_greatest_divisor(number: int) -> int:
    divisor = number - 1
    while divisor > 0:
        if number % divisor == 0:
            return divisor
        divisor -= 1

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, None),       # Edge case: no divisors for 1 (original function will raise an error)
        (2, 1),
        (3, 1),
        (4, 2),
        (5, 1),
        (6, 3),
        (10, 5),
        (15, 5),
        (20, 10),
        (25, 5)
    ]

    def test_0(self):
        with self.assertRaises(ZeroDivisionError):
            largest_divisor(self.test_cases[0][0])
        self.assertEqual(find_greatest_divisor(self.test_cases[0][0]), self.test_cases[0][1])

    def test_1(self):
        self.assertEqual(largest_divisor(self.test_cases[1][0]), find_greatest_divisor(self.test_cases[1][0]))

    def test_2(self):
        self.assertEqual(largest_divisor(self.test_cases[2][0]), find_greatest_divisor(self.test_cases[2][0]))

    def test_3(self):
        self.assertEqual(largest_divisor(self.test_cases[3][0]), find_greatest_divisor(self.test_cases[3][0]))

    def test_4(self):
        self.assertEqual(largest_divisor(self.test_cases[4][0]), find_greatest_divisor(self.test_cases[4][0]))

    def test_5(self):
        self.assertEqual(largest_divisor(self.test_cases[5][0]), find_greatest_divisor(self.test_cases[5][0]))

    def test_6(self):
        self.assertEqual(largest_divisor(self.test_cases[6][0]), find_greatest_divisor(self.test_cases[6][0]))

    def test_7(self):
        self.assertEqual(largest_divisor(self.test_cases[7][0]), find_greatest_divisor(self.test_cases[7][0]))

    def test_8(self):
        self.assertEqual(largest_divisor(self.test_cases[8][0]), find_greatest_divisor(self.test_cases[8][0]))

    def test_9(self):
        self.assertEqual(largest_divisor(self.test_cases[9][0]), find_greatest_divisor(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()