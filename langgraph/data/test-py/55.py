def fib(n: int):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fib(n - 1) + fib(n - 2)

def calculate_fibonacci(sequence_index: int):
    if sequence_index == 0:
        return 0
    elif sequence_index == 1:
        return 1

    previous, current = 0, 1
    index = 2
    while index <= sequence_index:
        previous, current = current, previous + current
        index += 1

    return current

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        2,
        3,
        4,
        5,
        10,
        15,
        20,
        25
    ]

    def test_0(self):
        self.assertEqual(fib(self.test_cases[0]), calculate_fibonacci(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(fib(self.test_cases[1]), calculate_fibonacci(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(fib(self.test_cases[2]), calculate_fibonacci(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(fib(self.test_cases[3]), calculate_fibonacci(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(fib(self.test_cases[4]), calculate_fibonacci(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(fib(self.test_cases[5]), calculate_fibonacci(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(fib(self.test_cases[6]), calculate_fibonacci(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(fib(self.test_cases[7]), calculate_fibonacci(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(fib(self.test_cases[8]), calculate_fibonacci(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(fib(self.test_cases[9]), calculate_fibonacci(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()