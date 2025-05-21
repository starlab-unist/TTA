from typing import List


def factorize(n: int) -> List[int]:
    import math
    fact = []
    i = 2
    while i <= int(math.sqrt(n) + 1):
        if n % i == 0:
            fact.append(i)
            n //= i
        else:
            i += 1

    if n > 1:
        fact.append(n)
    return fact


from typing import List
import math

def decompose_number(number: int) -> List[int]:
    factors = []
    divisor = 2
    while divisor <= math.isqrt(number):
        if number % divisor == 0:
            factors.append(divisor)
            number //= divisor
        else:
            divisor += 1

    if number > 1:
        factors.append(number)
    return factors

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        15
    ]

    def test_0(self):
        self.assertEqual(factorize(self.test_cases[0]), decompose_number(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(factorize(self.test_cases[1]), decompose_number(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(factorize(self.test_cases[2]), decompose_number(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(factorize(self.test_cases[3]), decompose_number(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(factorize(self.test_cases[4]), decompose_number(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(factorize(self.test_cases[5]), decompose_number(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(factorize(self.test_cases[6]), decompose_number(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(factorize(self.test_cases[7]), decompose_number(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(factorize(self.test_cases[8]), decompose_number(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(factorize(self.test_cases[9]), decompose_number(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()