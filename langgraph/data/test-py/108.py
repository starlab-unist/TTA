def count_nums(arr):
    def digits_sum(n):
        neg = 1
        if n < 0: n, neg = -1 * n, -1 
        n = [int(i) for i in str(n)]
        n[0] = n[0] * neg
        return sum(n)
    return len(list(filter(lambda x: x > 0, [digits_sum(i) for i in arr])))

def tally_positive_digit_sums(numbers):
    def compute_digit_sum(number):
        sign = -1 if number < 0 else 1
        absolute_value = abs(number)
        digit_list = [int(digit) for digit in str(absolute_value)]
        digit_list[0] *= sign
        return sum(digit_list)

    positive_sums_count = 0
    for num in numbers:
        if compute_digit_sum(num) > 0:
            positive_sums_count += 1

    return positive_sums_count

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [123, -456, 789], 
        [-111, 222, -333, 444],
        [0, 0, 0],
        [-1, 1, -1, 1],
        [999, -888, 777, -666],
        [1001, 2002, -3003, 4004],
        [-5, 5, -5, 5, -5],
        [10, -20, 30, -40, 50],
        [987654321, -123456789],
        [-12345, 12345, -12345]
    ]

    def test_0(self):
        self.assertEqual(count_nums(self.test_cases[0]), tally_positive_digit_sums(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(count_nums(self.test_cases[1]), tally_positive_digit_sums(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(count_nums(self.test_cases[2]), tally_positive_digit_sums(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(count_nums(self.test_cases[3]), tally_positive_digit_sums(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(count_nums(self.test_cases[4]), tally_positive_digit_sums(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(count_nums(self.test_cases[5]), tally_positive_digit_sums(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(count_nums(self.test_cases[6]), tally_positive_digit_sums(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(count_nums(self.test_cases[7]), tally_positive_digit_sums(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(count_nums(self.test_cases[8]), tally_positive_digit_sums(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(count_nums(self.test_cases[9]), tally_positive_digit_sums(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()