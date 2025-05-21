def sort_even(l: list):
    evens = l[::2]
    odds = l[1::2]
    evens.sort()
    ans = []
    for e, o in zip(evens, odds):
        ans.extend([e, o])
    if len(evens) > len(odds):
        ans.append(evens[-1])
    return ans

def rearrange_even_odd(numbers: list):
    even_elements = numbers[::2]
    odd_elements = numbers[1::2]
    even_elements.sort()
    result = []

    index = 0
    while index < len(odd_elements):
        result.append(even_elements[index])
        result.append(odd_elements[index])
        index += 1

    if len(even_elements) > len(odd_elements):
        result.append(even_elements[-1])

    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([2, 3, 4, 5, 6], [2, 3, 4, 5, 6]),
        ([10, 9, 8, 7, 6, 5], [6, 9, 8, 7, 10, 5]),
        ([1, 3, 5, 7, 2, 4, 6, 8], [1, 3, 2, 4, 5, 7, 6, 8]),
        ([1, 2], [1, 2]),
        ([5], [5]),
        ([], []),
        ([7, 1, 9, 3, 11, 5, 13], [7, 1, 9, 3, 11, 5, 13]),
        ([4, 2, 6, 8, 0, 10, 12, 14], [0, 2, 4, 8, 6, 10, 12, 14]),
        ([15, 14, 13, 12, 11, 10, 9], [9, 14, 11, 12, 13, 10, 15]),
        ([20, 19, 22, 21, 24, 23, 26, 25, 28], [20, 19, 22, 21, 24, 23, 26, 25, 28])
    ]

    def test_0(self):
        self.assertEqual(sort_even(self.test_cases[0][0]), rearrange_even_odd(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(sort_even(self.test_cases[1][0]), rearrange_even_odd(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(sort_even(self.test_cases[2][0]), rearrange_even_odd(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(sort_even(self.test_cases[3][0]), rearrange_even_odd(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(sort_even(self.test_cases[4][0]), rearrange_even_odd(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(sort_even(self.test_cases[5][0]), rearrange_even_odd(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(sort_even(self.test_cases[6][0]), rearrange_even_odd(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(sort_even(self.test_cases[7][0]), rearrange_even_odd(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(sort_even(self.test_cases[8][0]), rearrange_even_odd(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(sort_even(self.test_cases[9][0]), rearrange_even_odd(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()