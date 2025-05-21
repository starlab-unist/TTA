from typing import List
import unittest

# Source Code
def below_zero(operations: List[int]) -> bool:
    balance = 0

    for op in operations:
        balance += op
        if balance < 0:
            return True

    return False

# Transformed Code (Semantically Equivalent)
def check_negative_balance(transactions: List[int]) -> bool:
    current_balance = 0

    index = 0
    while index < len(transactions):
        current_balance += transactions[index]
        if current_balance < 0:
            return True
        index += 1

    return False

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([], False),
        ([1, 2, 3], False),
        ([-1, -2, -3], True),
        ([10, -5, -6], True),
        ([10, -5, 5], False),
        ([0, 0, 0], False),
        ([1, -1, 1, -1, 1, -2], True),
        ([-1, 1, -1, 1, -1, 1], True),
        ([1, 2, 3, -7], True),
        ([5, 5, 5, 5, -20], True)
    ]

    def test_0(self):
        self.assertEqual(below_zero(self.test_cases[0][0]), check_negative_balance(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(below_zero(self.test_cases[1][0]), check_negative_balance(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(below_zero(self.test_cases[2][0]), check_negative_balance(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(below_zero(self.test_cases[3][0]), check_negative_balance(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(below_zero(self.test_cases[4][0]), check_negative_balance(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(below_zero(self.test_cases[5][0]), check_negative_balance(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(below_zero(self.test_cases[6][0]), check_negative_balance(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(below_zero(self.test_cases[7][0]), check_negative_balance(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(below_zero(self.test_cases[8][0]), check_negative_balance(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(below_zero(self.test_cases[9][0]), check_negative_balance(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()