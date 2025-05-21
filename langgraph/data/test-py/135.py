def can_arrange(arr):
    ind = -1
    i = 1
    while i < len(arr):
        if arr[i] < arr[i-1]:
            ind = i
        i += 1
    return ind

# Transformed Code (Semantically Equivalent)
def find_first_decrease_index(sequence):
    position = -1
    index = 1
    while index < len(sequence):
        if sequence[index] < sequence[index - 1]:
            position = index
        index += 1
    return position

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],
        [5, 4, 3, 2, 1],
        [1, 3, 2, 4, 5],
        [10, 20, 30, 25, 40],
        [1, 1, 1, 1, 1],
        [1, 2, 3, 3, 2],
        [1],
        [],
        [7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1],
        [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5]
    ]

    def test_0(self):
        self.assertEqual(can_arrange(self.test_cases[0]), find_first_decrease_index(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(can_arrange(self.test_cases[1]), find_first_decrease_index(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(can_arrange(self.test_cases[2]), find_first_decrease_index(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(can_arrange(self.test_cases[3]), find_first_decrease_index(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(can_arrange(self.test_cases[4]), find_first_decrease_index(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(can_arrange(self.test_cases[5]), find_first_decrease_index(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(can_arrange(self.test_cases[6]), find_first_decrease_index(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(can_arrange(self.test_cases[7]), find_first_decrease_index(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(can_arrange(self.test_cases[8]), find_first_decrease_index(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(can_arrange(self.test_cases[9]), find_first_decrease_index(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()