def specialFilter(nums):
    
    count = 0
    for num in nums:
        if num > 10:
            odd_digits = (1, 3, 5, 7, 9)
            number_as_string = str(num)
            if int(number_as_string[0]) in odd_digits and int(number_as_string[-1]) in odd_digits:
                count += 1
        
    return count 

def count_special_numbers(numbers):
    
    total = 0
    iterator = iter(numbers)
    
    while True:
        try:
            current_number = next(iterator)
            if current_number > 10:
                odd_digits_set = {1, 3, 5, 7, 9}
                num_str = str(current_number)
                if int(num_str[0]) in odd_digits_set and int(num_str[-1]) in odd_digits_set:
                    total += 1
        except StopIteration:
            break
        
    return total

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [5, 13, 37, 91, 24, 17],
        [11, 13, 15, 17, 19, 21],
        [10, 11, 12, 13, 14, 15],
        [22, 24, 26, 28, 30],
        [135, 147, 159, 171, 183],
        [111, 133, 155, 177, 199],
        [3, 5, 7, 9, 10, 20, 30],
        [11, 33, 55, 77, 99, 101],
        [113, 135, 157, 179, 191, 213],
        []
    ]

    def test_0(self):
        self.assertEqual(specialFilter(self.test_cases[0]), count_special_numbers(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(specialFilter(self.test_cases[1]), count_special_numbers(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(specialFilter(self.test_cases[2]), count_special_numbers(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(specialFilter(self.test_cases[3]), count_special_numbers(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(specialFilter(self.test_cases[4]), count_special_numbers(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(specialFilter(self.test_cases[5]), count_special_numbers(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(specialFilter(self.test_cases[6]), count_special_numbers(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(specialFilter(self.test_cases[7]), count_special_numbers(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(specialFilter(self.test_cases[8]), count_special_numbers(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(specialFilter(self.test_cases[9]), count_special_numbers(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()