def unique_digits(x):
    odd_digit_elements = []
    for i in x:
        if all(int(c) % 2 == 1 for c in str(i)):
            odd_digit_elements.append(i)
    return sorted(odd_digit_elements)

def filter_odd_digit_numbers(numbers):
    odd_digit_numbers = []
    iterator = iter(numbers)
    
    while True:
        try:
            number = next(iterator)
            if all(int(digit) % 2 != 0 for digit in str(number)):
                odd_digit_numbers.append(number)
        except StopIteration:
            break
    
    return sorted(odd_digit_numbers)

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [135, 246, 357, 579],
        [111, 333, 555, 777, 999],
        [222, 444, 666, 888],
        [13579, 2468, 12345],
        [1, 3, 5, 7, 9],
        [0, 2, 4, 6, 8],
        [135, 579, 791, 913],
        [],
        [113, 135, 357, 579],
        [123, 321, 213, 456]
    ]

    def test_0(self):
        self.assertEqual(unique_digits(self.test_cases[0]), filter_odd_digit_numbers(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(unique_digits(self.test_cases[1]), filter_odd_digit_numbers(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(unique_digits(self.test_cases[2]), filter_odd_digit_numbers(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(unique_digits(self.test_cases[3]), filter_odd_digit_numbers(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(unique_digits(self.test_cases[4]), filter_odd_digit_numbers(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(unique_digits(self.test_cases[5]), filter_odd_digit_numbers(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(unique_digits(self.test_cases[6]), filter_odd_digit_numbers(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(unique_digits(self.test_cases[7]), filter_odd_digit_numbers(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(unique_digits(self.test_cases[8]), filter_odd_digit_numbers(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(unique_digits(self.test_cases[9]), filter_odd_digit_numbers(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()