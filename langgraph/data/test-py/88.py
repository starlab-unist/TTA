# Source Code
def sort_array(array):
    return [] if len(array) == 0 else sorted(array, reverse= (array[0]+array[-1]) % 2 == 0) 

# Transformed Code (Semantically Equivalent)
def arrange_sequence(sequence):
    if not sequence:
        return []
    
    reverse_order = (sequence[0] + sequence[-1]) % 2 == 0
    return sorted(sequence, reverse=reverse_order)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 1, 4, 1, 5, 9],
        [10, 20, 30, 40, 50],
        [5, 3, 8, 6, 7, 2],
        [7, 2, 9, 4, 6],
        [1],
        [],
        [2, 4, 6, 8, 10],
        [9, 7, 5, 3, 1],
        [11, 22, 33, 44, 55],
        [100, 200, 300, 400, 500]
    ]

    def test_0(self):
        self.assertEqual(sort_array(self.test_cases[0]), arrange_sequence(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sort_array(self.test_cases[1]), arrange_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sort_array(self.test_cases[2]), arrange_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sort_array(self.test_cases[3]), arrange_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sort_array(self.test_cases[4]), arrange_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sort_array(self.test_cases[5]), arrange_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sort_array(self.test_cases[6]), arrange_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sort_array(self.test_cases[7]), arrange_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sort_array(self.test_cases[8]), arrange_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sort_array(self.test_cases[9]), arrange_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()