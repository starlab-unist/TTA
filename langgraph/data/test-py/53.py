def add(x: int, y: int):
    return x + y

def compute_sum(a: int, b: int) -> int:
    total = a + b
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, 2),
        (-1, -1),
        (0, 0),
        (100, 200),
        (-50, 50),
        (123456789, 987654321),
        (0, 1),
        (10, -10),
        (999, 1),
        (1, 999)
    ]

    def test_0(self):
        self.assertEqual(add(*self.test_cases[0]), compute_sum(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(add(*self.test_cases[1]), compute_sum(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(add(*self.test_cases[2]), compute_sum(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(add(*self.test_cases[3]), compute_sum(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(add(*self.test_cases[4]), compute_sum(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(add(*self.test_cases[5]), compute_sum(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(add(*self.test_cases[6]), compute_sum(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(add(*self.test_cases[7]), compute_sum(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(add(*self.test_cases[8]), compute_sum(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(add(*self.test_cases[9]), compute_sum(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()