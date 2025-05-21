def starts_one_ends(n):
    if n == 1: return 1
    return 18 * (10 ** (n - 2))

def calculate_special_number(length):
    if length == 1:
        return 1
    multiplier = 18
    base = 10 ** (length - 2)
    return multiplier * base

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    def test_0(self):
        self.assertEqual(starts_one_ends(self.test_cases[0]), calculate_special_number(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(starts_one_ends(self.test_cases[1]), calculate_special_number(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(starts_one_ends(self.test_cases[2]), calculate_special_number(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(starts_one_ends(self.test_cases[3]), calculate_special_number(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(starts_one_ends(self.test_cases[4]), calculate_special_number(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(starts_one_ends(self.test_cases[5]), calculate_special_number(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(starts_one_ends(self.test_cases[6]), calculate_special_number(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(starts_one_ends(self.test_cases[7]), calculate_special_number(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(starts_one_ends(self.test_cases[8]), calculate_special_number(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(starts_one_ends(self.test_cases[9]), calculate_special_number(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()