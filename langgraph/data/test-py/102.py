def choose_num(x, y):
    if x > y:
        return -1
    if y % 2 == 0:
        return y
    if x == y:
        return -1
    return y - 1

def select_number(a, b):
    if a > b:
        return -1
    elif b % 2 == 0:
        return b
    elif a == b:
        return -1
    else:
        return b - 1

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (3, 5),     # y > x and y is odd
        (4, 4),     # x == y
        (2, 6),     # y > x and y is even
        (7, 8),     # y > x and y is even
        (10, 10),   # x == y
        (5, 3),     # x > y
        (0, 2),     # y > x and y is even
        (1, 1),     # x == y
        (9, 11),    # y > x and y is odd
        (6, 7)      # y > x and y is odd
    ]

    def test_0(self):
        self.assertEqual(choose_num(*self.test_cases[0]), select_number(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(choose_num(*self.test_cases[1]), select_number(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(choose_num(*self.test_cases[2]), select_number(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(choose_num(*self.test_cases[3]), select_number(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(choose_num(*self.test_cases[4]), select_number(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(choose_num(*self.test_cases[5]), select_number(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(choose_num(*self.test_cases[6]), select_number(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(choose_num(*self.test_cases[7]), select_number(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(choose_num(*self.test_cases[8]), select_number(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(choose_num(*self.test_cases[9]), select_number(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()