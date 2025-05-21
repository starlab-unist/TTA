def order_by_points(nums):
    def digits_sum(n):
        neg = 1
        if n < 0: n, neg = -1 * n, -1 
        n = [int(i) for i in str(n)]
        n[0] = n[0] * neg
        return sum(n)
    return sorted(nums, key=digits_sum)

def sort_numbers_by_digit_sum(numbers):
    def calculate_weight(number):
        sign = -1 if number < 0 else 1
        absolute_value = abs(number)
        digits = [int(digit) for digit in str(absolute_value)]
        digits[0] *= sign
        return sum(digits)
    
    return sorted(numbers, key=calculate_weight)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([123, 321, 213], [123, 213, 321]),
        ([-12, -21, 12, 21], [-12, 12, -21, 21]),
        ([0, 5, 10, 15], [0, 5, 10, 15]),
        ([987, 879, 798], [798, 879, 987]),
        ([-1234, -4321, 1234, 4321], [-1234, 1234, -4321, 4321]),
        ([555, 666, 777], [555, 666, 777]),
        ([-9, -8, -7, -6], [-6, -7, -8, -9]),
        ([100, 200, 300], [100, 200, 300]),
        ([5, -5, 10, -10], [5, -5, 10, -10]),
        ([111, -111, 222, -222], [111, -111, 222, -222])
    ]

    def test_0(self):
        self.assertEqual(order_by_points(self.test_cases[0][0]), sort_numbers_by_digit_sum(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(order_by_points(self.test_cases[1][0]), sort_numbers_by_digit_sum(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(order_by_points(self.test_cases[2][0]), sort_numbers_by_digit_sum(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(order_by_points(self.test_cases[3][0]), sort_numbers_by_digit_sum(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(order_by_points(self.test_cases[4][0]), sort_numbers_by_digit_sum(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(order_by_points(self.test_cases[5][0]), sort_numbers_by_digit_sum(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(order_by_points(self.test_cases[6][0]), sort_numbers_by_digit_sum(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(order_by_points(self.test_cases[7][0]), sort_numbers_by_digit_sum(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(order_by_points(self.test_cases[8][0]), sort_numbers_by_digit_sum(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(order_by_points(self.test_cases[9][0]), sort_numbers_by_digit_sum(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()