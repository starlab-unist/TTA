def is_multiply_prime(a):
    def is_prime(n):
        for j in range(2,n):
            if n%j == 0:
                return False
        return True

    for i in range(2,101):
        if not is_prime(i): continue
        for j in range(2,101):
            if not is_prime(j): continue
            for k in range(2,101):
                if not is_prime(k): continue
                if i*j*k == a: return True
    return False

def check_product_of_three_primes(number):
    def prime_check(value):
        for divisor in range(2, value):
            if value % divisor == 0:
                return False
        return True

    prime_range = range(2, 101)
    for first in prime_range:
        if not prime_check(first):
            continue
        for second in prime_range:
            if not prime_check(second):
                continue
            for third in prime_range:
                if not prime_check(third):
                    continue
                if first * second * third == number:
                    return True
    return False

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        30,   # 2*3*5
        60,   # 2*2*3*5 (False)
        105,  # 3*5*7
        231,  # 3*7*11
        385,  # 5*7*11
        500,  # 2*2*5*5*5 (False)
        770,  # 2*5*7*11 (False)
        969,  # 3*11*29
        1001, # 7*11*13
        1385  # 5*11*25 (False)
    ]

    def test_0(self):
        self.assertEqual(is_multiply_prime(self.test_cases[0]), check_product_of_three_primes(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_multiply_prime(self.test_cases[1]), check_product_of_three_primes(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_multiply_prime(self.test_cases[2]), check_product_of_three_primes(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_multiply_prime(self.test_cases[3]), check_product_of_three_primes(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_multiply_prime(self.test_cases[4]), check_product_of_three_primes(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_multiply_prime(self.test_cases[5]), check_product_of_three_primes(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_multiply_prime(self.test_cases[6]), check_product_of_three_primes(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_multiply_prime(self.test_cases[7]), check_product_of_three_primes(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_multiply_prime(self.test_cases[8]), check_product_of_three_primes(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_multiply_prime(self.test_cases[9]), check_product_of_three_primes(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()