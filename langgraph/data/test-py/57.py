def monotonic(l: list):
    if l == sorted(l) or l == sorted(l, reverse=True):
        return True
    return False

def check_monotonic_sequence(sequence: list):
    ascending = sequence.copy()
    descending = sequence.copy()
    
    ascending.sort()
    descending.sort(reverse=True)
    
    if sequence == ascending or sequence == descending:
        return True
    return False

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],       # strictly increasing
        [5, 4, 3, 2, 1],       # strictly decreasing
        [1, 1, 1, 1, 1],       # all elements are the same
        [1, 2, 2, 3, 4],       # non-decreasing
        [5, 5, 4, 4, 3, 2, 1], # non-increasing
        [1, 3, 2],             # not monotonic
        [],                    # empty list
        [10],                  # single element
        [3, 3, 2, 1, 1, 1],    # decreasing with duplicates
        [1, 1, 2, 2, 3, 3]     # increasing with duplicates
    ]

    def test_0(self):
        self.assertEqual(monotonic(self.test_cases[0]), check_monotonic_sequence(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(monotonic(self.test_cases[1]), check_monotonic_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(monotonic(self.test_cases[2]), check_monotonic_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(monotonic(self.test_cases[3]), check_monotonic_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(monotonic(self.test_cases[4]), check_monotonic_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(monotonic(self.test_cases[5]), check_monotonic_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(monotonic(self.test_cases[6]), check_monotonic_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(monotonic(self.test_cases[7]), check_monotonic_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(monotonic(self.test_cases[8]), check_monotonic_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(monotonic(self.test_cases[9]), check_monotonic_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()