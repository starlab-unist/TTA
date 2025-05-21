# Source Code
def pairs_sum_to_zero(l):
    for i, l1 in enumerate(l):
        for j in range(i + 1, len(l)):
            if l1 + l[j] == 0:
                return True
    return False

# Transformed Code (Semantically Equivalent)
def check_for_zero_sum_pairs(numbers):
    index = 0
    while index < len(numbers):
        current_number = numbers[index]
        next_index = index + 1
        while next_index < len(numbers):
            if current_number + numbers[next_index] == 0:
                return True
            next_index += 1
        index += 1
    return False

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([], False),
        ([1, -1], True),
        ([2, 3, -2], True),
        ([0, 0], True),
        ([5, 7, 9], False),
        ([-5, -7, -9], False),
        ([1, 2, 3, -3], True),
        ([10, 20, -10, 30], True),
        ([4, 5, 6, 7, 8], False),
        ([0, 1, 2, 3, 4, 5, -5], True)
    ]

    def test_0(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[0][0]), check_for_zero_sum_pairs(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[1][0]), check_for_zero_sum_pairs(self.test_cases[1][0]))
    
    def test_2(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[2][0]), check_for_zero_sum_pairs(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[3][0]), check_for_zero_sum_pairs(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[4][0]), check_for_zero_sum_pairs(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[5][0]), check_for_zero_sum_pairs(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[6][0]), check_for_zero_sum_pairs(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[7][0]), check_for_zero_sum_pairs(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[8][0]), check_for_zero_sum_pairs(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(pairs_sum_to_zero(self.test_cases[9][0]), check_for_zero_sum_pairs(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()