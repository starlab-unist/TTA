# Source Code
def is_sorted(lst):
    count_digit = dict([(i, 0) for i in lst])
    for i in lst:
        count_digit[i]+=1 
    if any(count_digit[i] > 2 for i in lst):
        return False
    if all(lst[i-1] <= lst[i] for i in range(1, len(lst))):
        return True
    else:
        return False
    

# Transformed Code (Semantically Equivalent)
def check_sorted_sequence(sequence):
    digit_count = {num: 0 for num in sequence}
    for number in sequence:
        digit_count[number] += 1
    
    if any(digit_count[num] > 2 for num in sequence):
        return False
    
    index = 1
    while index < len(sequence):
        if sequence[index - 1] > sequence[index]:
            return False
        index += 1
    
    return True

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],
        [5, 4, 3, 2, 1],
        [1, 1, 2, 2, 3, 3],
        [1, 1, 1, 2, 3],
        [1],
        [],
        [1, 2, 2, 3, 4, 5, 5],
        [10, 9, 8, 7, 6, 5],
        [1, 2, 3, 3, 3, 4, 5],
        [1, 2, 3, 4, 5, 5, 5]
    ]

    def test_0(self):
        self.assertEqual(is_sorted(self.test_cases[0]), check_sorted_sequence(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_sorted(self.test_cases[1]), check_sorted_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_sorted(self.test_cases[2]), check_sorted_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_sorted(self.test_cases[3]), check_sorted_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_sorted(self.test_cases[4]), check_sorted_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_sorted(self.test_cases[5]), check_sorted_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_sorted(self.test_cases[6]), check_sorted_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_sorted(self.test_cases[7]), check_sorted_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_sorted(self.test_cases[8]), check_sorted_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_sorted(self.test_cases[9]), check_sorted_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()