def prod_signs(arr):
    if not arr: return None
    prod = 0 if 0 in arr else (-1) ** len(list(filter(lambda x: x < 0, arr)))
    return prod * sum([abs(i) for i in arr])

def calculate_signed_sum(numbers):
    if not numbers:
        return None
    
    negative_count = sum(1 for num in numbers if num < 0)
    contains_zero = any(num == 0 for num in numbers)
    
    sign = 0 if contains_zero else (-1) ** negative_count
    total_sum = sum(abs(num) for num in numbers)
    
    return sign * total_sum

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3],
        [-1, -2, -3],
        [1, -2, 3],
        [0, 1, 2, 3],
        [0, -1, -2, -3],
        [],
        [5, 7, -9, 12],
        [-5, -7, 9, -12],
        [0, 0, 0],
        [1, 1, 1, -1, -1, -1]
    ]

    def test_0(self):
        self.assertEqual(prod_signs(self.test_cases[0]), calculate_signed_sum(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(prod_signs(self.test_cases[1]), calculate_signed_sum(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(prod_signs(self.test_cases[2]), calculate_signed_sum(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(prod_signs(self.test_cases[3]), calculate_signed_sum(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(prod_signs(self.test_cases[4]), calculate_signed_sum(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(prod_signs(self.test_cases[5]), calculate_signed_sum(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(prod_signs(self.test_cases[6]), calculate_signed_sum(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(prod_signs(self.test_cases[7]), calculate_signed_sum(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(prod_signs(self.test_cases[8]), calculate_signed_sum(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(prod_signs(self.test_cases[9]), calculate_signed_sum(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()