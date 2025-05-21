# Source Code
def f(n):
    ret = []
    for i in range(1,n+1):
        if i%2 == 0:
            x = 1
            for j in range(1,i+1): x *= j
            ret += [x]
        else:
            x = 0
            for j in range(1,i+1): x += j
            ret += [x]
    return ret

# Transformed Code (Semantically Equivalent)
def generate_alternating_sequence(limit):
    result = []
    index = 1
    while index <= limit:
        if index % 2 == 0:
            factorial = 1
            inner_index = 1
            while inner_index <= index:
                factorial *= inner_index
                inner_index += 1
            result.append(factorial)
        else:
            summation = 0
            inner_index = 1
            while inner_index <= index:
                summation += inner_index
                inner_index += 1
            result.append(summation)
        index += 1
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,  # Edge case: no elements
        1,  # Only one element, odd
        2,  # Two elements, odd then even
        3,  # Three elements, odd, even, odd
        4,  # Four elements, odd, even, odd, even
        5,  # Five elements, odd, even, odd, even, odd
        10, # Ten elements
        20, # Twenty elements
        30, # Thirty elements
        50  # Fifty elements
    ]

    def test_0(self):
        self.assertEqual(f(self.test_cases[0]), generate_alternating_sequence(self.test_cases[0]))

    def test_1(self):
        self.assertEqual(f(self.test_cases[1]), generate_alternating_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(f(self.test_cases[2]), generate_alternating_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(f(self.test_cases[3]), generate_alternating_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(f(self.test_cases[4]), generate_alternating_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(f(self.test_cases[5]), generate_alternating_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(f(self.test_cases[6]), generate_alternating_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(f(self.test_cases[7]), generate_alternating_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(f(self.test_cases[8]), generate_alternating_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(f(self.test_cases[9]), generate_alternating_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()