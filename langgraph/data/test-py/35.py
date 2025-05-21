def max_element(l: list):
    m = l[0]
    for e in l:
        if e > m:
            m = e
    return m

def find_maximum_value(elements: list):
    current_max = elements[0]
    index = 1
    while index < len(elements):
        if elements[index] > current_max:
            current_max = elements[index]
        index += 1
    return current_max

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5],
        [-7, -1, -5, -3, -9],
        [10, 20, 30, 40, 50],
        [100],
        [0, 0, 0, 0],
        [5, 5, 5, 5, 6],
        [-1, -2, -3, -4, -5, -6],
        [1],
        [2, 2, 2, 1, 1, 1],
        [9, 8, 7, 6, 5, 4, 3, 2, 1]
    ]

    def test_0(self):
        self.assertEqual(max_element(self.test_cases[0]), find_maximum_value(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(max_element(self.test_cases[1]), find_maximum_value(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(max_element(self.test_cases[2]), find_maximum_value(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(max_element(self.test_cases[3]), find_maximum_value(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(max_element(self.test_cases[4]), find_maximum_value(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(max_element(self.test_cases[5]), find_maximum_value(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(max_element(self.test_cases[6]), find_maximum_value(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(max_element(self.test_cases[7]), find_maximum_value(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(max_element(self.test_cases[8]), find_maximum_value(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(max_element(self.test_cases[9]), find_maximum_value(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()