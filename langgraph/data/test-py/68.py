def pluck(arr):
    if(len(arr) == 0): return []
    evens = list(filter(lambda x: x%2 == 0, arr))
    if(evens == []): return []
    return [min(evens), arr.index(min(evens))]

def extract_min_even_and_index(sequence):
    if not sequence:
        return []

    even_numbers = [num for num in sequence if num % 2 == 0]
    if not even_numbers:
        return []

    smallest_even = min(even_numbers)
    position_of_smallest_even = sequence.index(smallest_even)

    return [smallest_even, position_of_smallest_even]

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3, 4, 5], [2, 1]),
        ([10, 21, 3, 7, 8], [8, 4]),
        ([], []),
        ([1, 3, 5, 7], []),
        ([2, 4, 6, 8], [2, 0]),
        ([9, 7, 5, 3, 2, 4, 6, 8], [2, 4]),
        ([0, 1, 2, 3, 4, 5], [0, 0]),
        ([11, 13, 17, 19, 23, 29, 2], [2, 6]),
        ([8, 6, 4, 2, 0], [0, 4]),
        ([2, 2, 2, 2, 2], [2, 0])
    ]

    def test_0(self):
        self.assertEqual(pluck(self.test_cases[0][0]), extract_min_even_and_index(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(pluck(self.test_cases[1][0]), extract_min_even_and_index(self.test_cases[1][0]))
    
    def test_2(self):
        self.assertEqual(pluck(self.test_cases[2][0]), extract_min_even_and_index(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(pluck(self.test_cases[3][0]), extract_min_even_and_index(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(pluck(self.test_cases[4][0]), extract_min_even_and_index(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(pluck(self.test_cases[5][0]), extract_min_even_and_index(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(pluck(self.test_cases[6][0]), extract_min_even_and_index(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(pluck(self.test_cases[7][0]), extract_min_even_and_index(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(pluck(self.test_cases[8][0]), extract_min_even_and_index(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(pluck(self.test_cases[9][0]), extract_min_even_and_index(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()