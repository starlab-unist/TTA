def triangle_area(a, b, c):
    if a + b <= c or a + c <= b or b + c <= a:
        return -1 
    s = (a + b + c)/2    
    area = (s * (s - a) * (s - b) * (s - c)) ** 0.5
    area = round(area, 2)
    return area

def compute_triangle_area(side1, side2, side3):
    if side1 + side2 <= side3 or side1 + side3 <= side2 or side2 + side3 <= side1:
        return -1
    
    semi_perimeter = (side1 + side2 + side3) / 2
    computed_area = (semi_perimeter * (semi_perimeter - side1) * (semi_perimeter - side2) * (semi_perimeter - side3)) ** 0.5
    rounded_area = round(computed_area, 2)
    
    return rounded_area

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (3, 4, 5),      # valid triangle
        (10, 6, 8),     # valid triangle
        (7, 10, 5),     # valid triangle
        (1, 1, 2),      # invalid triangle
        (5, 5, 5),      # equilateral triangle
        (0, 4, 5),      # invalid triangle with zero side
        (-3, 4, 5),     # invalid triangle with negative side
        (6, 8, 10),     # valid right triangle
        (2, 2, 3.464),  # valid isosceles triangle
        (12, 5, 13)     # valid triangle
    ]

    def test_0(self):
        self.assertEqual(triangle_area(*self.test_cases[0]), compute_triangle_area(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(triangle_area(*self.test_cases[1]), compute_triangle_area(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(triangle_area(*self.test_cases[2]), compute_triangle_area(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(triangle_area(*self.test_cases[3]), compute_triangle_area(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(triangle_area(*self.test_cases[4]), compute_triangle_area(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(triangle_area(*self.test_cases[5]), compute_triangle_area(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(triangle_area(*self.test_cases[6]), compute_triangle_area(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(triangle_area(*self.test_cases[7]), compute_triangle_area(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(triangle_area(*self.test_cases[8]), compute_triangle_area(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(triangle_area(*self.test_cases[9]), compute_triangle_area(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()