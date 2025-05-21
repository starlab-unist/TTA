# Source Code
def minSubArraySum(nums):
    if not nums:
        return 0
    max_sum = 0
    s = 0
    for num in nums:
        s += -num
        if (s < 0):
            s = 0
        max_sum = max(s, max_sum)
    if max_sum == 0:
        max_sum = max(-i for i in nums)
    min_sum = -max_sum
    return min_sum

# Transformed Code (Semantically Equivalent)
def calculate_minimum_subarray_sum(numbers):
    if not numbers:
        return 0
    current_sum = 0
    highest_negative_sum = 0
    for value in numbers:
        current_sum += -value
        if current_sum < 0:
            current_sum = 0
        highest_negative_sum = max(current_sum, highest_negative_sum)
    
    if highest_negative_sum == 0:
        highest_negative_sum = max(-val for val in numbers)
    
    minimum_sum = -highest_negative_sum
    return minimum_sum

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3], -6),
        ([-1, -2, -3, -4], -10),
        ([5, -1, 5], -1),
        ([0, 0, 0], 0),
        ([1], -1),
        ([-1], -1),
        ([1, -1, 1, -1], -2),
        ([3, -4, 2, -3, -1, 7, -5], -6),
        ([10, -3, 4, -2, -1, 10], -6),
        ([], 0),  # Edge case: empty list
    ]

    def test_0(self):
        self.assertEqual(minSubArraySum(self.test_cases[0][0]), calculate_minimum_subarray_sum(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(minSubArraySum(self.test_cases[1][0]), calculate_minimum_subarray_sum(self.test_cases[1][0]))

    def test_2(self):
        self.assertEqual(minSubArraySum(self.test_cases[2][0]), calculate_minimum_subarray_sum(self.test_cases[2][0]))

    def test_3(self):
        self.assertEqual(minSubArraySum(self.test_cases[3][0]), calculate_minimum_subarray_sum(self.test_cases[3][0]))

    def test_4(self):
        self.assertEqual(minSubArraySum(self.test_cases[4][0]), calculate_minimum_subarray_sum(self.test_cases[4][0]))

    def test_5(self):
        self.assertEqual(minSubArraySum(self.test_cases[5][0]), calculate_minimum_subarray_sum(self.test_cases[5][0]))

    def test_6(self):
        self.assertEqual(minSubArraySum(self.test_cases[6][0]), calculate_minimum_subarray_sum(self.test_cases[6][0]))

    def test_7(self):
        self.assertEqual(minSubArraySum(self.test_cases[7][0]), calculate_minimum_subarray_sum(self.test_cases[7][0]))

    def test_8(self):
        self.assertEqual(minSubArraySum(self.test_cases[8][0]), calculate_minimum_subarray_sum(self.test_cases[8][0]))

    def test_9(self):
        self.assertEqual(minSubArraySum(self.test_cases[9][0]), calculate_minimum_subarray_sum(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()