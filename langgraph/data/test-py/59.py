def largest_prime_factor(n: int):
    def is_prime(k):
        if k < 2:
            return False
        for i in range(2, k - 1):
            if k % i == 0:
                return False
        return True
    largest = 1
    for j in range(2, n + 1):
        if n % j == 0 and is_prime(j):
            largest = max(largest, j)
    return largest

def find_max_prime_divisor(number: int):
    def check_prime(candidate):
        if candidate < 2:
            return False
        divisor = 2
        while divisor * divisor <= candidate:
            if candidate % divisor == 0:
                return False
            divisor += 1
        return True

    max_prime = 1
    factor = 2
    while factor <= number:
        if number % factor == 0 and check_prime(factor):
            max_prime = factor
        factor += 1
    return max_prime

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20
    ]

    def test_0(self):
        self.assertEqual(largest_prime_factor(self.test_cases[0]), find_max_prime_divisor(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(largest_prime_factor(self.test_cases[1]), find_max_prime_divisor(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(largest_prime_factor(self.test_cases[2]), find_max_prime_divisor(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(largest_prime_factor(self.test_cases[3]), find_max_prime_divisor(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(largest_prime_factor(self.test_cases[4]), find_max_prime_divisor(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(largest_prime_factor(self.test_cases[5]), find_max_prime_divisor(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(largest_prime_factor(self.test_cases[6]), find_max_prime_divisor(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(largest_prime_factor(self.test_cases[7]), find_max_prime_divisor(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(largest_prime_factor(self.test_cases[8]), find_max_prime_divisor(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(largest_prime_factor(self.test_cases[9]), find_max_prime_divisor(self.test_cases[9]))
    
    def test_10(self):
        self.assertEqual(largest_prime_factor(self.test_cases[10]), find_max_prime_divisor(self.test_cases[10]))
    
    def test_11(self):
        self.assertEqual(largest_prime_factor(self.test_cases[11]), find_max_prime_divisor(self.test_cases[11]))
    
    def test_12(self):
        self.assertEqual(largest_prime_factor(self.test_cases[12]), find_max_prime_divisor(self.test_cases[12]))
    
    def test_13(self):
        self.assertEqual(largest_prime_factor(self.test_cases[13]), find_max_prime_divisor(self.test_cases[13]))
    
    def test_14(self):
        self.assertEqual(largest_prime_factor(self.test_cases[14]), find_max_prime_divisor(self.test_cases[14]))
    
    def test_15(self):
        self.assertEqual(largest_prime_factor(self.test_cases[15]), find_max_prime_divisor(self.test_cases[15]))
    
    def test_16(self):
        self.assertEqual(largest_prime_factor(self.test_cases[16]), find_max_prime_divisor(self.test_cases[16]))
    
    def test_17(self):
        self.assertEqual(largest_prime_factor(self.test_cases[17]), find_max_prime_divisor(self.test_cases[17]))
    
    def test_18(self):
        self.assertEqual(largest_prime_factor(self.test_cases[18]), find_max_prime_divisor(self.test_cases[18]))
    
    def test_19(self):
        self.assertEqual(largest_prime_factor(self.test_cases[19]), find_max_prime_divisor(self.test_cases[19]))

if __name__ == '__main__':
    unittest.main()