def incr_list(l: list):
    return [(e + 1) for e in l]

def increment_elements(input_list: list):
    result = []
    index = 0
    while index < len(input_list):
        result.append(input_list[index] + 1)
        index += 1
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3, 4, 5],
        [-1, -2, -3, -4, -5],
        [0, 0, 0, 0],
        [],
        [100, 200, 300],
        [-100, 0, 100],
        [1],
        [-1],
        [0],
        [9, 8, 7, 6, 5]
    ]

    def test_0(self):
        self.assertEqual(incr_list(self.test_cases[0]), increment_elements(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(incr_list(self.test_cases[1]), increment_elements(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(incr_list(self.test_cases[2]), increment_elements(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(incr_list(self.test_cases[3]), increment_elements(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(incr_list(self.test_cases[4]), increment_elements(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(incr_list(self.test_cases[5]), increment_elements(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(incr_list(self.test_cases[6]), increment_elements(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(incr_list(self.test_cases[7]), increment_elements(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(incr_list(self.test_cases[8]), increment_elements(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(incr_list(self.test_cases[9]), increment_elements(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()