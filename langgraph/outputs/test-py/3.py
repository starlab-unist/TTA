from typing import List


def below_zero(operations: List[int]) -> bool:
    balance = 0

    for op in operations:
        balance += op
        if balance < 0:
            return True

    return False

from typing import List

def balance_falls_negative(transactions: List[int]) -> bool:
    current_total = 0
    position = 0
    while position < len(transactions):
        current_total += transactions[position]
        if current_total < 0:
            return True
        position += 1
    return False

import unittest

class TestFunctionEquivalence(unittest.TestCase):
    test_cases = [
        [1, 2, 3],
        [1, -2, 3],
        [1, 2, -3],
        [-1, 2, 3],
        [1, -1, 2],
        [10, -5, -10],
        [],
        [0, 0, 0],
        [1, 2, 3, -7],
        [5, -3, -4]
    ]

    def test_0(self):
        self.assertEqual(below_zero(self.test_cases[0]), balance_falls_negative(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(below_zero(self.test_cases[1]), balance_falls_negative(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(below_zero(self.test_cases[2]), balance_falls_negative(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(below_zero(self.test_cases[3]), balance_falls_negative(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(below_zero(self.test_cases[4]), balance_falls_negative(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(below_zero(self.test_cases[5]), balance_falls_negative(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(below_zero(self.test_cases[6]), balance_falls_negative(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(below_zero(self.test_cases[7]), balance_falls_negative(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(below_zero(self.test_cases[8]), balance_falls_negative(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(below_zero(self.test_cases[9]), balance_falls_negative(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()