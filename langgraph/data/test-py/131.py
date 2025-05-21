def digits(n):
    product = 1
    odd_count = 0
    for digit in str(n):
        int_digit = int(digit)
        if int_digit % 2 == 1:
            product = product * int_digit
            odd_count += 1
    if odd_count == 0:
        return 0
    else:
        return product

def calculate_odd_digit_product(number):
    result = 1
    odd_digits_found = 0
    digit_iterator = iter(str(number))
    
    while True:
        try:
            current_digit = int(next(digit_iterator))
            if current_digit % 2 != 0:
                result *= current_digit
                odd_digits_found += 1
        except StopIteration:
            break
    
    return result if odd_digits_found > 0 else 0

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        123456789,
        2468,
        13579,
        11111,
        0,
        987654321,
        2222222,
        123,
        555555,
        9
    ]

    def test_0(self):
        self.assertEqual(digits(self.test_cases[0]), calculate_odd_digit_product(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(digits(self.test_cases[1]), calculate_odd_digit_product(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(digits(self.test_cases[2]), calculate_odd_digit_product(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(digits(self.test_cases[3]), calculate_odd_digit_product(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(digits(self.test_cases[4]), calculate_odd_digit_product(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(digits(self.test_cases[5]), calculate_odd_digit_product(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(digits(self.test_cases[6]), calculate_odd_digit_product(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(digits(self.test_cases[7]), calculate_odd_digit_product(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(digits(self.test_cases[8]), calculate_odd_digit_product(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(digits(self.test_cases[9]), calculate_odd_digit_product(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()