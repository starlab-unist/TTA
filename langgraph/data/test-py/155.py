# Source Code
def even_odd_count(num):
    even_count = 0
    odd_count = 0
    for i in str(abs(num)):
        if int(i)%2==0:
            even_count +=1
        else:
            odd_count +=1
    return (even_count, odd_count)

# Transformed Code (Semantically Equivalent)
def tally_even_odd_digits(number):
    even_tally = 0
    odd_tally = 0
    index = 0
    num_str = str(abs(number))
    
    while index < len(num_str):
        digit = int(num_str[index])
        if digit % 2 == 0:
            even_tally += 1
        else:
            odd_tally += 1
        index += 1
    
    return (even_tally, odd_tally)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        1234567890,
        -1234567890,
        24680,
        13579,
        0,
        111222333444,
        987654321,
        -987654321,
        1000000,
        1
    ]

    def test_0(self):
        self.assertEqual(even_odd_count(self.test_cases[0]), tally_even_odd_digits(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(even_odd_count(self.test_cases[1]), tally_even_odd_digits(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(even_odd_count(self.test_cases[2]), tally_even_odd_digits(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(even_odd_count(self.test_cases[3]), tally_even_odd_digits(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(even_odd_count(self.test_cases[4]), tally_even_odd_digits(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(even_odd_count(self.test_cases[5]), tally_even_odd_digits(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(even_odd_count(self.test_cases[6]), tally_even_odd_digits(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(even_odd_count(self.test_cases[7]), tally_even_odd_digits(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(even_odd_count(self.test_cases[8]), tally_even_odd_digits(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(even_odd_count(self.test_cases[9]), tally_even_odd_digits(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()