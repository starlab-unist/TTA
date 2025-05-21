def solve(N):
    return bin(sum(int(i) for i in str(N)))[2:]

def convert_to_binary_string(number):
    digit_sum = sum(int(digit) for digit in str(number))
    binary_representation = bin(digit_sum)[2:]
    return binary_representation

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        9,
        123,
        456,
        789,
        1001,
        11111111,
        987654321,
        2**10
    ]

    def test_0(self):
        self.assertEqual(solve(self.test_cases[0]), convert_to_binary_string(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(solve(self.test_cases[1]), convert_to_binary_string(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(solve(self.test_cases[2]), convert_to_binary_string(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(solve(self.test_cases[3]), convert_to_binary_string(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(solve(self.test_cases[4]), convert_to_binary_string(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(solve(self.test_cases[5]), convert_to_binary_string(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(solve(self.test_cases[6]), convert_to_binary_string(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(solve(self.test_cases[7]), convert_to_binary_string(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(solve(self.test_cases[8]), convert_to_binary_string(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(solve(self.test_cases[9]), convert_to_binary_string(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()