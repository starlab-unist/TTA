# Source Code
def generate_integers(a, b):
    lower = max(2, min(a, b))
    upper = min(8, max(a, b))

    return [i for i in range(lower, upper+1) if i % 2 == 0]

# Transformed Code (Semantically Equivalent)
def produce_even_numbers(x, y):
    start = max(2, min(x, y))
    end = min(8, max(x, y))

    even_numbers = []
    current = start
    while current <= end:
        if current % 2 == 0:
            even_numbers.append(current)
        current += 1

    return even_numbers

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, 5),
        (3, 9),
        (6, 2),
        (8, 8),
        (0, 4),
        (7, 7),
        (2, 2),
        (10, 1),
        (5, 5),
        (4, 4)
    ]

    def test_0(self):
        self.assertEqual(generate_integers(*self.test_cases[0]), produce_even_numbers(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(generate_integers(*self.test_cases[1]), produce_even_numbers(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(generate_integers(*self.test_cases[2]), produce_even_numbers(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(generate_integers(*self.test_cases[3]), produce_even_numbers(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(generate_integers(*self.test_cases[4]), produce_even_numbers(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(generate_integers(*self.test_cases[5]), produce_even_numbers(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(generate_integers(*self.test_cases[6]), produce_even_numbers(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(generate_integers(*self.test_cases[7]), produce_even_numbers(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(generate_integers(*self.test_cases[8]), produce_even_numbers(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(generate_integers(*self.test_cases[9]), produce_even_numbers(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()