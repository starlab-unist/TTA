# Source Code
def exchange(lst1, lst2):
    odd = 0
    even = 0
    for i in lst1:
        if i % 2 == 1:
            odd += 1
    for i in lst2:
        if i % 2 == 0:
            even += 1
    if even >= odd:
        return "YES"
    return "NO"

# Transformed Code (Semantically Equivalent)
def compare_parity(list_a, list_b):
    odd_count = 0
    even_count = 0
    index = 0
    
    while index < len(list_a):
        if list_a[index] % 2 != 0:
            odd_count += 1
        index += 1
    
    index = 0
    while index < len(list_b):
        if list_b[index] % 2 == 0:
            even_count += 1
        index += 1
    
    return "YES" if even_count >= odd_count else "NO"

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 3, 5], [2, 4, 6]),    # odd: 3, even: 3 -> YES
        ([1, 2, 3], [4, 5, 6]),    # odd: 2, even: 2 -> YES
        ([1, 1, 1], [2, 4, 6]),    # odd: 3, even: 3 -> YES
        ([1, 3, 5], [1, 3, 5]),    # odd: 3, even: 0 -> NO
        ([2, 4, 6], [1, 3, 5]),    # odd: 0, even: 3 -> YES
        ([], []),                  # odd: 0, even: 0 -> YES
        ([1], [2]),                # odd: 1, even: 1 -> YES
        ([1, 3, 5, 7], [2]),       # odd: 4, even: 1 -> NO
        ([2, 4, 6, 8], [1, 3, 5]), # odd: 3, even: 4 -> YES
        ([], [1, 3, 5]),           # odd: 0, even: 0 -> YES (since even >= odd)
    ]

    def test_0(self):
        self.assertEqual(exchange(self.test_cases[0][0], self.test_cases[0][1]), compare_parity(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(exchange(self.test_cases[1][0], self.test_cases[1][1]), compare_parity(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(exchange(self.test_cases[2][0], self.test_cases[2][1]), compare_parity(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(exchange(self.test_cases[3][0], self.test_cases[3][1]), compare_parity(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(exchange(self.test_cases[4][0], self.test_cases[4][1]), compare_parity(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(exchange(self.test_cases[5][0], self.test_cases[5][1]), compare_parity(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(exchange(self.test_cases[6][0], self.test_cases[6][1]), compare_parity(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(exchange(self.test_cases[7][0], self.test_cases[7][1]), compare_parity(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(exchange(self.test_cases[8][0], self.test_cases[8][1]), compare_parity(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(exchange(self.test_cases[9][0], self.test_cases[9][1]), compare_parity(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()