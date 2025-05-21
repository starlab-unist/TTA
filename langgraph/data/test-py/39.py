def prime_fib(n: int):
    import math

    def is_prime(p):
        if p < 2:
            return False
        for k in range(2, min(int(math.sqrt(p)) + 1, p - 1)):
            if p % k == 0:
                return False
        return True
    f = [0, 1]
    while True:
        f.append(f[-1] + f[-2])
        if is_prime(f[-1]):
            n -= 1
        if n == 0:
            return f[-1]

def find_nth_prime_fibonacci(index: int):
    import math

    def check_prime(number):
        if number < 2:
            return False
        limit = min(int(math.sqrt(number)) + 1, number - 1)
        divisor = 2
        while divisor < limit:
            if number % divisor == 0:
                return False
            divisor += 1
        return True

    fibonacci_sequence = [0, 1]
    while True:
        next_fib = fibonacci_sequence[-1] + fibonacci_sequence[-2]
        fibonacci_sequence.append(next_fib)
        if check_prime(next_fib):
            index -= 1
        if index == 0:
            return next_fib

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        1,  # First prime Fibonacci number is 2
        2,  # Second prime Fibonacci number is 3
        3,  # Third prime Fibonacci number is 5
        4,  # Fourth prime Fibonacci number is 13
        5,  # Fifth prime Fibonacci number is 89
        6,  # Sixth prime Fibonacci number is 233
        7,  # Seventh prime Fibonacci number is 1597
        8,  # Eighth prime Fibonacci number is 28657
        9,  # Ninth prime Fibonacci number is 514229
        10  # Tenth prime Fibonacci number is 433494437
    ]

    def test_0(self):
        self.assertEqual(prime_fib(self.test_cases[0]), find_nth_prime_fibonacci(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(prime_fib(self.test_cases[1]), find_nth_prime_fibonacci(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(prime_fib(self.test_cases[2]), find_nth_prime_fibonacci(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(prime_fib(self.test_cases[3]), find_nth_prime_fibonacci(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(prime_fib(self.test_cases[4]), find_nth_prime_fibonacci(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(prime_fib(self.test_cases[5]), find_nth_prime_fibonacci(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(prime_fib(self.test_cases[6]), find_nth_prime_fibonacci(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(prime_fib(self.test_cases[7]), find_nth_prime_fibonacci(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(prime_fib(self.test_cases[8]), find_nth_prime_fibonacci(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(prime_fib(self.test_cases[9]), find_nth_prime_fibonacci(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()