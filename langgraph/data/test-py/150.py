def x_or_y(n, x, y):
    if n == 1:
        return y
    for i in range(2, n):
        if n % i == 0:
            return y
            break
    else:
        return x

def determine_value_based_on_divisibility(number, value_if_not_prime, value_if_prime):
    if number == 1:
        return value_if_prime

    divisor = 2
    while divisor < number:
        if number % divisor == 0:
            return value_if_prime
        divisor += 1
    else:
        return value_if_not_prime

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, "not_prime", "prime"),
        (2, "not_prime", "prime"),
        (3, "not_prime", "prime"),
        (4, "not_prime", "prime"),
        (5, "not_prime", "prime"),
        (6, "not_prime", "prime"),
        (7, "not_prime", "prime"),
        (8, "not_prime", "prime"),
        (9, "not_prime", "prime"),
        (10, "not_prime", "prime")
    ]

    def test_0(self):
        self.assertEqual(x_or_y(*self.test_cases[0]), determine_value_based_on_divisibility(*self.test_cases[0]))

    def test_1(self):
        self.assertEqual(x_or_y(*self.test_cases[1]), determine_value_based_on_divisibility(*self.test_cases[1]))

    def test_2(self):
        self.assertEqual(x_or_y(*self.test_cases[2]), determine_value_based_on_divisibility(*self.test_cases[2]))

    def test_3(self):
        self.assertEqual(x_or_y(*self.test_cases[3]), determine_value_based_on_divisibility(*self.test_cases[3]))

    def test_4(self):
        self.assertEqual(x_or_y(*self.test_cases[4]), determine_value_based_on_divisibility(*self.test_cases[4]))

    def test_5(self):
        self.assertEqual(x_or_y(*self.test_cases[5]), determine_value_based_on_divisibility(*self.test_cases[5]))

    def test_6(self):
        self.assertEqual(x_or_y(*self.test_cases[6]), determine_value_based_on_divisibility(*self.test_cases[6]))

    def test_7(self):
        self.assertEqual(x_or_y(*self.test_cases[7]), determine_value_based_on_divisibility(*self.test_cases[7]))

    def test_8(self):
        self.assertEqual(x_or_y(*self.test_cases[8]), determine_value_based_on_divisibility(*self.test_cases[8]))

    def test_9(self):
        self.assertEqual(x_or_y(*self.test_cases[9]), determine_value_based_on_divisibility(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()