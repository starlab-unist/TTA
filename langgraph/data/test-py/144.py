# Source Code
def simplify(x, n):
    a, b = x.split("/")
    c, d = n.split("/")
    numerator = int(a) * int(c)
    denom = int(b) * int(d)
    if (numerator/denom == int(numerator/denom)):
        return True
    return False

# Transformed Code (Semantically Equivalent)
def check_fraction_simplification(fraction1, fraction2):
    num1, denom1 = map(int, fraction1.split('/'))
    num2, denom2 = map(int, fraction2.split('/'))
    result_numerator = num1 * num2
    result_denominator = denom1 * denom2
    return result_numerator % result_denominator == 0

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("1/2", "2/4"),    # True: (1*2) / (2*4) = 1/4
        ("3/4", "4/8"),    # True: (3*4) / (4*8) = 12/32 = 3/8
        ("5/6", "2/3"),    # False: (5*2) / (6*3) = 10/18 != int(10/18)
        ("7/9", "9/18"),   # True: (7*9) / (9*18) = 63/162 = 7/18
        ("1/1", "1/1"),    # True: (1*1) / (1*1) = 1
        ("0/1", "5/10"),   # True: (0*5) / (1*10) = 0
        ("2/3", "3/6"),    # False: (2*3) / (3*6) = 6/18 != int(6/18)
        ("10/20", "20/40"),# True: (10*20) / (20*40) = 200/800 = 1/4
        ("1/3", "3/9"),    # True: (1*3) / (3*9) = 3/27 = 1/9
        ("5/7", "7/14")    # False: (5*7) / (7*14) = 35/98 != int(35/98)
    ]

    def test_0(self):
        self.assertEqual(simplify(self.test_cases[0][0], self.test_cases[0][1]), check_fraction_simplification(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(simplify(self.test_cases[1][0], self.test_cases[1][1]), check_fraction_simplification(self.test_cases[1][0], self.test_cases[1][1]))
        
    def test_2(self):
        self.assertEqual(simplify(self.test_cases[2][0], self.test_cases[2][1]), check_fraction_simplification(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(simplify(self.test_cases[3][0], self.test_cases[3][1]), check_fraction_simplification(self.test_cases[3][0], self.test_cases[3][1]))
    
    def test_4(self):
        self.assertEqual(simplify(self.test_cases[4][0], self.test_cases[4][1]), check_fraction_simplification(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(simplify(self.test_cases[5][0], self.test_cases[5][1]), check_fraction_simplification(self.test_cases[5][0], self.test_cases[5][1]))
    
    def test_6(self):
        self.assertEqual(simplify(self.test_cases[6][0], self.test_cases[6][1]), check_fraction_simplification(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(simplify(self.test_cases[7][0], self.test_cases[7][1]), check_fraction_simplification(self.test_cases[7][0], self.test_cases[7][1]))
    
    def test_8(self):
        self.assertEqual(simplify(self.test_cases[8][0], self.test_cases[8][1]), check_fraction_simplification(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(simplify(self.test_cases[9][0], self.test_cases[9][1]), check_fraction_simplification(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()