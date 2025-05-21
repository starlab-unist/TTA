def triples_sum_to_zero(l: list):
    for i in range(len(l)):
        for j in range(i + 1, len(l)):
            for k in range(j + 1, len(l)):
                if l[i] + l[j] + l[k] == 0:
                    return True
    return False

def check_for_zero_sum_triplets(numbers: list):
    length = len(numbers)
    index_i = 0
    
    while index_i < length:
        index_j = index_i + 1
        while index_j < length:
            index_k = index_j + 1
            while index_k < length:
                if numbers[index_i] + numbers[index_j] + numbers[index_k] == 0:
                    return True
                index_k += 1
            index_j += 1
        index_i += 1
    
    return False

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, -3],          # Simple case with sum zero
        [-1, 0, 1],          # Another simple case with sum zero
        [1, 2, 3],           # No triplets sum to zero
        [0, 0, 0],           # All elements are zero
        [1, -1, 2, -2, 3],   # Multiple pairs but no triplet sums to zero
        [-5, 2, 3, 4, 1],    # Triplet (-5, 2, 3) sums to zero
        [-10, 1, 3, 6, 7],   # Triplet (1, 3, -4) doesn't exist but others do not sum to zero
        [5, 5, 5, -15],      # Triplet (5, 5, -15) sums to zero
        [-2, 0, 2, 0],       # Multiple triplets with zeros and non-zeros
        []                   # Empty list should return False
    ]

    def test_0(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[0]), check_for_zero_sum_triplets(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[1]), check_for_zero_sum_triplets(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[2]), check_for_zero_sum_triplets(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[3]), check_for_zero_sum_triplets(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[4]), check_for_zero_sum_triplets(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[5]), check_for_zero_sum_triplets(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[6]), check_for_zero_sum_triplets(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[7]), check_for_zero_sum_triplets(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[8]), check_for_zero_sum_triplets(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(triples_sum_to_zero(self.test_cases[9]), check_for_zero_sum_triplets(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()