def get_positive(l: list):
    return [e for e in l if e > 0]

def extract_positive_numbers(input_list: list):
    positive_numbers = []
    index = 0

    while index < len(input_list):
        if input_list[index] > 0:
            positive_numbers.append(input_list[index])
        index += 1

    return positive_numbers

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, -2, 3, 4, -5],
        [-1, -2, -3, -4, -5],
        [0, 0, 0, 0],
        [10, 20, 30, 40, 50],
        [],
        [-10, 0, 10],
        [5],
        [-5],
        [1, 2, 3, 4, 5, -6, -7, -8, -9, -10],
        [100, 200, 300, -100, -200, -300]
    ]

    def test_0(self):
        self.assertEqual(get_positive(self.test_cases[0]), extract_positive_numbers(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(get_positive(self.test_cases[1]), extract_positive_numbers(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(get_positive(self.test_cases[2]), extract_positive_numbers(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(get_positive(self.test_cases[3]), extract_positive_numbers(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(get_positive(self.test_cases[4]), extract_positive_numbers(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(get_positive(self.test_cases[5]), extract_positive_numbers(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(get_positive(self.test_cases[6]), extract_positive_numbers(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(get_positive(self.test_cases[7]), extract_positive_numbers(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(get_positive(self.test_cases[8]), extract_positive_numbers(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(get_positive(self.test_cases[9]), extract_positive_numbers(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()