def count_up_to(n):
    primes = []
    for i in range(2, n):
        is_prime = True
        for j in range(2, i):
            if i % j == 0:
                is_prime = False
                break
        if is_prime:
            primes.append(i)
    return primes

def find_primes_below(limit):
    prime_numbers = []
    candidate = 2
    while candidate < limit:
        divisor = 2
        is_divisible = False
        while divisor < candidate:
            if candidate % divisor == 0:
                is_divisible = True
                break
            divisor += 1
        if not is_divisible:
            prime_numbers.append(candidate)
        candidate += 1
    return prime_numbers

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        10,  # Simple case with multiple primes below the limit
        2,   # Edge case where limit is less than the smallest prime
        3,   # Case where there's only one prime below the limit
        20,  # Larger number to check performance and correctness
        1,   # Edge case where limit is 1
        0,   # Edge case where limit is 0
        5,   # Simple case with multiple primes below the limit
        15,  # Case with some primes but not many
        29,  # Prime number itself as the limit
        30   # Number just above a prime to check if it includes that prime
    ]

    def test_0(self):
        self.assertEqual(count_up_to(self.test_cases[0]), find_primes_below(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(count_up_to(self.test_cases[1]), find_primes_below(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(count_up_to(self.test_cases[2]), find_primes_below(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(count_up_to(self.test_cases[3]), find_primes_below(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(count_up_to(self.test_cases[4]), find_primes_below(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(count_up_to(self.test_cases[5]), find_primes_below(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(count_up_to(self.test_cases[6]), find_primes_below(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(count_up_to(self.test_cases[7]), find_primes_below(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(count_up_to(self.test_cases[8]), find_primes_below(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(count_up_to(self.test_cases[9]), find_primes_below(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()