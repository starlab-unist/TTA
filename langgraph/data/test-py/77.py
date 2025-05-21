def iscube(a):
    a = abs(a)
    return int(round(a ** (1. / 3))) ** 3 == a

def check_perfect_cube(number):
    number = abs(number)
    cube_root = round(number ** (1/3))
    return cube_root ** 3 == number

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        27,     # 3^3
        -27,    # -3^3 but abs is used so it should be treated as 3^3
        64,     # 4^3
        -64,    # -4^3 but abs is used so it should be treated as 4^3
        0,      # 0^3
        1,      # 1^3
        2,      # Not a perfect cube
        -8,     # -2^3 but abs is used so it should be treated as 2^3
        15,     # Not a perfect cube
        125     # 5^3
    ]

    def test_0(self):
        self.assertEqual(iscube(self.test_cases[0]), check_perfect_cube(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(iscube(self.test_cases[1]), check_perfect_cube(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(iscube(self.test_cases[2]), check_perfect_cube(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(iscube(self.test_cases[3]), check_perfect_cube(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(iscube(self.test_cases[4]), check_perfect_cube(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(iscube(self.test_cases[5]), check_perfect_cube(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(iscube(self.test_cases[6]), check_perfect_cube(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(iscube(self.test_cases[7]), check_perfect_cube(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(iscube(self.test_cases[8]), check_perfect_cube(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(iscube(self.test_cases[9]), check_perfect_cube(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()