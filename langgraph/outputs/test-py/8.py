from typing import List, Tuple


def sum_product(numbers: List[int]) -> Tuple[int, int]:
    sum_value = 0
    prod_value = 1

    for n in numbers:
        sum_value += n
        prod_value *= n
    return sum_value, prod_value

from typing import List, Tuple

def compute_sum_and_multiply(nums: List[int]) -> Tuple[int, int]:
    total = 0
    product = 1
    index = 0
    while index < len(nums):
        total += nums[index]
        product *= nums[index]
        index += 1
    return total, product

import unittest

class TestFunctionEquivalence(unittest.TestCase):
    test_cases = [
        [],
        [0],
        [1],
        [1, 2],
        [2, 3],
        [-1, 2],
        [0, 1, 2],
        [1, 0, 2],
        [1, 2, 3],
        [-1, -2, -3]
    ]

    def test_0(self):
        self.assertEqual(sum_product(self.test_cases[0]), compute_sum_and_multiply(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sum_product(self.test_cases[1]), compute_sum_and_multiply(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sum_product(self.test_cases[2]), compute_sum_and_multiply(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sum_product(self.test_cases[3]), compute_sum_and_multiply(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sum_product(self.test_cases[4]), compute_sum_and_multiply(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sum_product(self.test_cases[5]), compute_sum_and_multiply(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sum_product(self.test_cases[6]), compute_sum_and_multiply(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sum_product(self.test_cases[7]), compute_sum_and_multiply(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sum_product(self.test_cases[8]), compute_sum_and_multiply(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sum_product(self.test_cases[9]), compute_sum_and_multiply(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()