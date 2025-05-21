import math

# Source Code
def poly(xs: list, x: float):
    """
    Evaluates polynomial with coefficients xs at point x.
    return xs[0] + xs[1] * x + xs[1] * x^2 + .... xs[n] * x^n
    """
    return sum([coeff * math.pow(x, i) for i, coeff in enumerate(xs)])


def find_zero(xs: list):
    begin, end = -1., 1.
    while poly(xs, begin) * poly(xs, end) > 0:
        begin *= 2.0
        end *= 2.0
    while end - begin > 1e-10:
        center = (begin + end) / 2.0
        if poly(xs, center) * poly(xs, begin) > 0:
            begin = center
        else:
            end = center
    return begin

# Transformed Code (Semantically Equivalent)
def evaluate_polynomial(coefficients: list, point: float):
    """
    Evaluates polynomial with coefficients at a given point.
    return coefficients[0] + coefficients[1] * point + coefficients[2] * point^2 + .... + coefficients[n] * point^n
    """
    result = 0.0
    for power, coefficient in enumerate(coefficients):
        result += coefficient * math.pow(point, power)
    return result


def locate_root(coeffs: list):
    left_bound, right_bound = -1.0, 1.0
    while evaluate_polynomial(coeffs, left_bound) * evaluate_polynomial(coeffs, right_bound) > 0:
        left_bound *= 2.0
        right_bound *= 2.0
    
    while right_bound - left_bound > 1e-10:
        midpoint = (left_bound + right_bound) / 2.0
        if evaluate_polynomial(coeffs, midpoint) * evaluate_polynomial(coeffs, left_bound) > 0:
            left_bound = midpoint
        else:
            right_bound = midpoint
    
    return left_bound

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1], 2.0),
        ([1, -3, 2], 2.0),  # x^2 - 3x + 2 = (x-1)(x-2)
        ([1, 0, -4], 2.0),  # x^2 - 4 = (x-2)(x+2)
        ([2, -4, 2], 1.0),  # 2x^2 - 4x + 2 = 2(x-1)^2
        ([1, -6, 11, -6], 3.0),  # x^3 - 6x^2 + 11x - 6 = (x-1)(x-2)(x-3)
        ([1, -3, 3, -1], 1.0),  # x^3 - 3x^2 + 3x - 1 = (x-1)^3
        ([1, 0, 0, 0, -1], 1.0),  # x^4 - 1 = (x-1)(x+1)(x^2+1)
        ([1, -5, 10, -10, 5, -1], 1.0),  # x^5 - 5x^4 + 10x^3 - 10x^2 + 5x - 1 = (x-1)^5
        ([0, 1], 0.0),  # x
        ([0, 0, 1], 0.0)  # x^2
    ]

    def test_poly_and_evaluate_polynomial(self):
        for coefficients, point in self.test_cases:
            self.assertAlmostEqual(poly(coefficients, point), evaluate_polynomial(coefficients, point), places=9)

    def test_find_zero_and_locate_root(self):
        for coefficients, _ in self.test_cases:
            root1 = find_zero(coefficients)
            root2 = locate_root(coefficients)
            self.assertAlmostEqual(root1, root2, places=5)

if __name__ == '__main__':
    unittest.main()