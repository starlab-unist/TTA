def maximum(arr, k):
    if k == 0:
        return []
    arr.sort()
    ans = arr[-k:]
    return ans

def find_top_k_elements(sequence, count):
    if count == 0:
        return []

    sorted_sequence = sorted(sequence)
    top_elements = sorted_sequence[-count:]

    return top_elements

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3, 4, 5], 3),
        ([5, 4, 3, 2, 1], 2),
        ([10, 9, 8, 7, 6], 5),
        ([1, 1, 1, 1, 1], 3),
        ([], 1),
        ([1, 2, 3], 0),
        ([-1, -2, -3, -4], 2),
        ([100, 200, 300, 400, 500], 0),
        ([5, 5, 5, 5, 5, 5], 6),
        ([10, 20, 30, 40, 50], 1)
    ]

    def test_0(self):
        self.assertEqual(maximum(*self.test_cases[0]), find_top_k_elements(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(maximum(*self.test_cases[1]), find_top_k_elements(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(maximum(*self.test_cases[2]), find_top_k_elements(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(maximum(*self.test_cases[3]), find_top_k_elements(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(maximum(*self.test_cases[4]), find_top_k_elements(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(maximum(*self.test_cases[5]), find_top_k_elements(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(maximum(*self.test_cases[6]), find_top_k_elements(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(maximum(*self.test_cases[7]), find_top_k_elements(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(maximum(*self.test_cases[8]), find_top_k_elements(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(maximum(*self.test_cases[9]), find_top_k_elements(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()