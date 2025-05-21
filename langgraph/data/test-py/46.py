def fib4(n: int):
    results = [0, 0, 2, 0]
    if n < 4:
        return results[n]

    for _ in range(4, n + 1):
        results.append(results[-1] + results[-2] + results[-3] + results[-4])
        results.pop(0)

    return results[-1]


def calculate_custom_fibonacci(index: int):
    sequence = [0, 0, 2, 0]
    if index < 4:
        return sequence[index]

    current_index = 4
    while current_index <= index:
        next_value = sequence[-1] + sequence[-2] + sequence[-3] + sequence[-4]
        sequence.append(next_value)
        sequence.pop(0)
        current_index += 1

    return sequence[-1]


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,  # Base case
        1,  # Base case
        2,  # Base case
        3,  # Base case
        4,  # First calculated value
        5,  # Continue calculation
        6,  # Continue calculation
        7,  # Continue calculation
        8,  # Continue calculation
        9   # Continue calculation
    ]

    def test_0(self):
        self.assertEqual(fib4(self.test_cases[0]), calculate_custom_fibonacci(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(fib4(self.test_cases[1]), calculate_custom_fibonacci(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(fib4(self.test_cases[2]), calculate_custom_fibonacci(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(fib4(self.test_cases[3]), calculate_custom_fibonacci(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(fib4(self.test_cases[4]), calculate_custom_fibonacci(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(fib4(self.test_cases[5]), calculate_custom_fibonacci(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(fib4(self.test_cases[6]), calculate_custom_fibonacci(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(fib4(self.test_cases[7]), calculate_custom_fibonacci(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(fib4(self.test_cases[8]), calculate_custom_fibonacci(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(fib4(self.test_cases[9]), calculate_custom_fibonacci(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()