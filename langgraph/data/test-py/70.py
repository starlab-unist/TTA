def strange_sort_list(lst):
    res, switch = [], True
    while lst:
        res.append(min(lst) if switch else max(lst))
        lst.remove(res[-1])
        switch = not switch
    return res

from itertools import cycle

def alternate_sort(sequence):
    sorted_sequence = []
    toggle = cycle([True, False])

    while sequence:
        should_pick_min = next(toggle)
        selected_value = min(sequence) if should_pick_min else max(sequence)
        sorted_sequence.append(selected_value)
        sequence.remove(selected_value)

    return sorted_sequence

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 1, 2],
        [9, 7, 5, 3, 1],
        [10, 20, 30, 40, 50],
        [5, 5, 5, 5],
        [1],
        [],
        [8, 6, 7, 5, 3, 0, 9],
        [2, 2, 2, 1, 1, 1, 3, 3, 3],
        [-1, -2, -3, -4, -5],
        [100, 200, 150, 50, 250]
    ]

    def test_0(self):
        self.assertEqual(strange_sort_list(self.test_cases[0]), alternate_sort(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(strange_sort_list(self.test_cases[1]), alternate_sort(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(strange_sort_list(self.test_cases[2]), alternate_sort(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(strange_sort_list(self.test_cases[3]), alternate_sort(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(strange_sort_list(self.test_cases[4]), alternate_sort(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(strange_sort_list(self.test_cases[5]), alternate_sort(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(strange_sort_list(self.test_cases[6]), alternate_sort(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(strange_sort_list(self.test_cases[7]), alternate_sort(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(strange_sort_list(self.test_cases[8]), alternate_sort(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(strange_sort_list(self.test_cases[9]), alternate_sort(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()