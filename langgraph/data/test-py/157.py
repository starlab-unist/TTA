def right_angle_triangle(a, b, c):
    return a*a == b*b + c*c or b*b == a*a + c*c or c*c == a*a + b*b

def is_right_angled(x, y, z):
    sides_squared = [x**2, y**2, z**2]
    sides_squared.sort()
    return sides_squared[0] + sides_squared[1] == sides_squared[2]

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (3, 4, 5),   # True: 3^2 + 4^2 = 5^2
        (5, 12, 13), # True: 5^2 + 12^2 = 13^2
        (1, 1, 1),   # False: not a right triangle
        (6, 8, 10),  # True: 6^2 + 8^2 = 10^2
        (7, 24, 25), # True: 7^2 + 24^2 = 25^2
        (9, 40, 41), # True: 9^2 + 40^2 = 41^2
        (2, 2, 3),   # False: not a right triangle
        (8, 15, 17), # True: 8^2 + 15^2 = 17^2
        (10, 24, 26),# True: 10^2 + 24^2 = 26^2
        (5, 5, 7)    # False: not a right triangle
    ]

    def test_0(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[0]), is_right_angled(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[1]), is_right_angled(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[2]), is_right_angled(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[3]), is_right_angled(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[4]), is_right_angled(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[5]), is_right_angled(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[6]), is_right_angled(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[7]), is_right_angled(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[8]), is_right_angled(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(right_angle_triangle(*self.test_cases[9]), is_right_angled(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()