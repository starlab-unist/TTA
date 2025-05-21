def derivative(xs: list):
    return [(i * x) for i, x in enumerate(xs)][1:]

def compute_derivative(coefficients: list):
    result = []
    index = 1
    while index < len(coefficients):
        result.append(index * coefficients[index])
        index += 1
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 1, 2, 4],       # Expected output: [1, 4, 12]
        [0, 5, 0, 7],       # Expected output: [5, 0, 21]
        [1, 3, 5, 7, 9],    # Expected output: [3, 10, 21, 36]
        [2, 0, 0, 0],       # Expected output: [0, 0, 0]
        [10, 20, 30],       # Expected output: [20, 60]
        [5],                # Expected output: []
        [],                 # Expected output: []
        [1, -1, 1, -1],     # Expected output: [-1, 2, -3]
        [0, 0, 0, 0, 0],    # Expected output: [0, 0, 0, 0]
        [7, 6, 5, 4, 3, 2]  # Expected output: [6, 10, 12, 12, 10]
    ]

    def test_0(self):
        self.assertEqual(derivative(self.test_cases[0]), compute_derivative(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(derivative(self.test_cases[1]), compute_derivative(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(derivative(self.test_cases[2]), compute_derivative(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(derivative(self.test_cases[3]), compute_derivative(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(derivative(self.test_cases[4]), compute_derivative(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(derivative(self.test_cases[5]), compute_derivative(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(derivative(self.test_cases[6]), compute_derivative(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(derivative(self.test_cases[7]), compute_derivative(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(derivative(self.test_cases[8]), compute_derivative(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(derivative(self.test_cases[9]), compute_derivative(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()