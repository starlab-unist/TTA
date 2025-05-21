# Source Code
def do_algebra(operator, operand):
    expression = str(operand[0])
    for oprt, oprn in zip(operator, operand[1:]):
        expression += oprt + str(oprn)
    return eval(expression)

# Transformed Code (Semantically Equivalent)
def evaluate_expression(operators, values):
    result_string = str(values[0])
    index = 0
    while index < len(operators):
        result_string += operators[index] + str(values[index + 1])
        index += 1
    return eval(result_string)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (['+', '*', '-'], [2, 3, 4, 5]),  # (2 + 3) * 4 - 5 = 9
        (['-', '/'], [10, 5, 2]),         # 10 - 5 / 2 = 7.5
        (['*', '+', '/'], [1, 2, 3, 4]),   # (1 * 2) + 3 / 4 = 2.75
        (['+', '-', '*', '/'], [10, 5, 3, 2, 4]),  # ((10 + 5) - 3) * 2 / 4 = 4.0
        (['**', '+'], [2, 3, 4]),          # 2 ** 3 + 4 = 12
        (['+', '-', '+'], [1, 1, 1, 1]),   # 1 + 1 - 1 + 1 = 2
        (['*', '*', '*'], [2, 2, 2, 2]),   # 2 * 2 * 2 * 2 = 16
        (['/', '+', '-'], [8, 4, 2, 1]),   # 8 / 4 + 2 - 1 = 3.0
        (['+', '-', '*', '/'], [0, 1, 1, 1, 1]),  # (0 + 1) - 1 * 1 / 1 = 0.0
        (['**', '*', '+'], [2, 3, 4, 5]),   # (2 ** 3) * 4 + 5 = 37
    ]

    def test_0(self):
        self.assertEqual(do_algebra(self.test_cases[0][0], self.test_cases[0][1]), evaluate_expression(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(do_algebra(self.test_cases[1][0], self.test_cases[1][1]), evaluate_expression(self.test_cases[1][0], self.test_cases[1][1]))

    def test_2(self):
        self.assertEqual(do_algebra(self.test_cases[2][0], self.test_cases[2][1]), evaluate_expression(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(do_algebra(self.test_cases[3][0], self.test_cases[3][1]), evaluate_expression(self.test_cases[3][0], self.test_cases[3][1]))

    def test_4(self):
        self.assertEqual(do_algebra(self.test_cases[4][0], self.test_cases[4][1]), evaluate_expression(self.test_cases[4][0], self.test_cases[4][1]))
    
    def test_5(self):
        self.assertEqual(do_algebra(self.test_cases[5][0], self.test_cases[5][1]), evaluate_expression(self.test_cases[5][0], self.test_cases[5][1]))

    def test_6(self):
        self.assertEqual(do_algebra(self.test_cases[6][0], self.test_cases[6][1]), evaluate_expression(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(do_algebra(self.test_cases[7][0], self.test_cases[7][1]), evaluate_expression(self.test_cases[7][0], self.test_cases[7][1]))

    def test_8(self):
        self.assertEqual(do_algebra(self.test_cases[8][0], self.test_cases[8][1]), evaluate_expression(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(do_algebra(self.test_cases[9][0], self.test_cases[9][1]), evaluate_expression(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()