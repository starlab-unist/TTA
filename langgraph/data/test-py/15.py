# Source Code
def string_sequence(n: int) -> str:
    return ' '.join([str(x) for x in range(n + 1)])

# Transformed Code (Semantically Equivalent)
def generate_number_series(length: int) -> str:
    number_list = []
    index = 0

    while index <= length:
        number_list.append(str(index))
        index += 1

    series = ' '.join(number_list)
    return series

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        5,
        10,
        20,
        100,
        -1,  # Edge case: negative input
        3,
        7,
        15
    ]

    def test_0(self):
        self.assertEqual(string_sequence(self.test_cases[0]), generate_number_series(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(string_sequence(self.test_cases[1]), generate_number_series(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(string_sequence(self.test_cases[2]), generate_number_series(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(string_sequence(self.test_cases[3]), generate_number_series(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(string_sequence(self.test_cases[4]), generate_number_series(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(string_sequence(self.test_cases[5]), generate_number_series(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(string_sequence(self.test_cases[6]), generate_number_series(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(string_sequence(self.test_cases[7]), generate_number_series(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(string_sequence(self.test_cases[8]), generate_number_series(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(string_sequence(self.test_cases[9]), generate_number_series(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()