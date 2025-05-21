def any_int(x, y, z):
    if isinstance(x, int) and isinstance(y, int) and isinstance(z, int):
        if (x + y == z) or (x + z == y) or (y + z == x):
            return True
        return False
    return False

def check_sum_of_two_equals_third(a, b, c):
    if all(isinstance(i, int) for i in (a, b, c)):
        if a + b == c or a + c == b or b + c == a:
            return True
        return False
    return False

# method name: any_int -> check_sum_of_two_equals_third
# parameter names: x -> a, y -> b, z -> c
# replaced individual isinstance checks with a generator expression inside all()
# maintained the same logic and output structure

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, 2, 3),   # True: 1 + 2 == 3
        (5, 3, 2),   # True: 3 + 2 == 5
        (4, 6, 10),  # True: 4 + 6 == 10
        (7, 3, 4),   # True: 3 + 4 == 7
        (1, 1, 2),   # True: 1 + 1 == 2
        (10, 5, 5),  # False: No two numbers sum to the third
        (0, 0, 0),   # True: 0 + 0 == 0
        (-1, -2, -3),# True: -1 + -2 == -3
        (1.5, 2, 3.5), # False: Not all inputs are integers
        ("a", 2, 3)   # False: Not all inputs are integers
    ]

    def test_0(self):
        self.assertEqual(any_int(*self.test_cases[0]), check_sum_of_two_equals_third(*self.test_cases[0]))

    def test_1(self):
        self.assertEqual(any_int(*self.test_cases[1]), check_sum_of_two_equals_third(*self.test_cases[1]))
    
    def test_2(self):
        self.assertEqual(any_int(*self.test_cases[2]), check_sum_of_two_equals_third(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(any_int(*self.test_cases[3]), check_sum_of_two_equals_third(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(any_int(*self.test_cases[4]), check_sum_of_two_equals_third(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(any_int(*self.test_cases[5]), check_sum_of_two_equals_third(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(any_int(*self.test_cases[6]), check_sum_of_two_equals_third(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(any_int(*self.test_cases[7]), check_sum_of_two_equals_third(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(any_int(*self.test_cases[8]), check_sum_of_two_equals_third(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(any_int(*self.test_cases[9]), check_sum_of_two_equals_third(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()