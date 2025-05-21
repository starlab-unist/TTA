# Source Code
def compare(game, guess):
    return [abs(x-y) for x,y in zip(game,guess)]

# Transformed Code (Semantically Equivalent)
def evaluate_difference(actual, player_guess):
    differences = []
    index = 0
    while index < len(actual):
        differences.append(abs(actual[index] - player_guess[index]))
        index += 1
    return differences

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3], [1, 2, 3]),
        ([4, 5, 6], [7, 8, 9]),
        ([0, 0, 0], [1, 1, 1]),
        ([-1, -2, -3], [-1, -2, -3]),
        ([10, 20, 30], [30, 20, 10]),
        ([100, 200, 300], [150, 250, 350]),
        ([1, 1, 1, 1, 1], [1, 1, 1, 1, 1]),
        ([1, 2, 3, 4, 5], [5, 4, 3, 2, 1]),
        ([0, 1, 2, 3, 4], [4, 3, 2, 1, 0]),
        ([-5, -10, -15], [-15, -10, -5])
    ]

    def test_0(self):
        self.assertEqual(compare(*self.test_cases[0]), evaluate_difference(*self.test_cases[0]))

    def test_1(self):
        self.assertEqual(compare(*self.test_cases[1]), evaluate_difference(*self.test_cases[1]))

    def test_2(self):
        self.assertEqual(compare(*self.test_cases[2]), evaluate_difference(*self.test_cases[2]))

    def test_3(self):
        self.assertEqual(compare(*self.test_cases[3]), evaluate_difference(*self.test_cases[3]))

    def test_4(self):
        self.assertEqual(compare(*self.test_cases[4]), evaluate_difference(*self.test_cases[4]))

    def test_5(self):
        self.assertEqual(compare(*self.test_cases[5]), evaluate_difference(*self.test_cases[5]))

    def test_6(self):
        self.assertEqual(compare(*self.test_cases[6]), evaluate_difference(*self.test_cases[6]))

    def test_7(self):
        self.assertEqual(compare(*self.test_cases[7]), evaluate_difference(*self.test_cases[7]))

    def test_8(self):
        self.assertEqual(compare(*self.test_cases[8]), evaluate_difference(*self.test_cases[8]))

    def test_9(self):
        self.assertEqual(compare(*self.test_cases[9]), evaluate_difference(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()