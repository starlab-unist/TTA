# Source Code
def fibfib(n: int):
    if n == 0:
        return 0
    if n == 1:
        return 0
    if n == 2:
        return 1
    return fibfib(n - 1) + fibfib(n - 2) + fibfib(n - 3)

# Transformed Code (Semantically Equivalent)
def calculate_modified_fibonacci(index: int):
    if index == 0:
        return 0
    elif index == 1:
        return 0
    elif index == 2:
        return 1
    else:
        return (calculate_modified_fibonacci(index - 1) +
                calculate_modified_fibonacci(index - 2) +
                calculate_modified_fibonacci(index - 3))

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,  # Base case
        1,  # Base case
        2,  # Base case
        3,  # Simple case
        4,  # Slightly larger input
        5,  # Further recursion
        6,  # Further recursion
        7,  # Further recursion
        8,  # Further recursion
        9   # Larger input to test deeper recursion
    ]

    def test_0(self):
        self.assertEqual(fibfib(self.test_cases[0]), calculate_modified_fibonacci(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(fibfib(self.test_cases[1]), calculate_modified_fibonacci(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(fibfib(self.test_cases[2]), calculate_modified_fibonacci(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(fibfib(self.test_cases[3]), calculate_modified_fibonacci(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(fibfib(self.test_cases[4]), calculate_modified_fibonacci(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(fibfib(self.test_cases[5]), calculate_modified_fibonacci(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(fibfib(self.test_cases[6]), calculate_modified_fibonacci(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(fibfib(self.test_cases[7]), calculate_modified_fibonacci(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(fibfib(self.test_cases[8]), calculate_modified_fibonacci(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(fibfib(self.test_cases[9]), calculate_modified_fibonacci(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()