# Source Code
def sort_array(arr):
    return sorted(sorted(arr), key=lambda x: bin(x)[2:].count('1'))

# Transformed Code (Semantically Equivalent)
def arrange_by_binary_ones(sequence):
    def count_ones_in_binary(number):
        return bin(number).count('1')
    
    return sorted(sorted(sequence), key=count_ones_in_binary)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 7, 8, 9],          # Mixed numbers with different binary '1' counts
        [5, 3, 15, 7, 2],      # Numbers with varying binary '1' counts
        [0, 1, 2, 3, 4, 5, 6], # Sequential numbers starting from 0
        [10, 20, 30, 40, 50],  # Multiples of 10
        [31, 14, 7, 3, 1],     # Descending powers of 2 minus 1
        [64, 128, 256, 512],   # Powers of 2
        [1, 1, 1, 1],          # All ones
        [0, 0, 0, 0],          # All zeros
        [13, 9, 5, 7, 11],     # Mixed numbers with same '1' count in binary
        [2, 4, 8, 16, 32]      # Powers of 2 starting from 2^1
    ]

    def test_0(self):
        self.assertEqual(sort_array(self.test_cases[0]), arrange_by_binary_ones(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sort_array(self.test_cases[1]), arrange_by_binary_ones(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sort_array(self.test_cases[2]), arrange_by_binary_ones(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sort_array(self.test_cases[3]), arrange_by_binary_ones(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sort_array(self.test_cases[4]), arrange_by_binary_ones(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sort_array(self.test_cases[5]), arrange_by_binary_ones(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sort_array(self.test_cases[6]), arrange_by_binary_ones(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sort_array(self.test_cases[7]), arrange_by_binary_ones(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sort_array(self.test_cases[8]), arrange_by_binary_ones(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sort_array(self.test_cases[9]), arrange_by_binary_ones(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()