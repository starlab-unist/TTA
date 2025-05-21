from typing import List

# Source Code
def sort_numbers(numbers: str) -> str:
    value_map = {
        'zero': 0,
        'one': 1,
        'two': 2,
        'three': 3,
        'four': 4,
        'five': 5,
        'six': 6,
        'seven': 7,
        'eight': 8,
        'nine': 9
    }
    return ' '.join(sorted([x for x in numbers.split(' ') if x], key=lambda x: value_map[x]))

# Transformed Code (Semantically Equivalent)
def arrange_numerals(number_string: str) -> str:
    numeral_to_digit = {
        'zero': 0,
        'one': 1,
        'two': 2,
        'three': 3,
        'four': 4,
        'five': 5,
        'six': 6,
        'seven': 7,
        'eight': 8,
        'nine': 9
    }
    
    # Split the input string and filter out any empty strings
    numeral_list = [numeral for numeral in number_string.split(' ') if numeral]
    
    # Sort the list based on the mapped digit values
    sorted_numerals = sorted(numeral_list, key=lambda n: numeral_to_digit[n])
    
    # Join the sorted numerals back into a single string
    return ' '.join(sorted_numerals)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "three one four one five nine",
        "nine eight seven six five four three two one zero",
        "zero zero zero",
        "one two three four five six seven eight nine",
        "four four four four four",
        "five six seven eight nine zero one two three",
        "two four six eight",
        "one three five seven nine",
        "",
        "nine"
    ]

    def test_0(self):
        self.assertEqual(sort_numbers(self.test_cases[0]), arrange_numerals(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sort_numbers(self.test_cases[1]), arrange_numerals(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sort_numbers(self.test_cases[2]), arrange_numerals(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sort_numbers(self.test_cases[3]), arrange_numerals(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sort_numbers(self.test_cases[4]), arrange_numerals(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sort_numbers(self.test_cases[5]), arrange_numerals(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sort_numbers(self.test_cases[6]), arrange_numerals(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sort_numbers(self.test_cases[7]), arrange_numerals(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sort_numbers(self.test_cases[8]), arrange_numerals(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sort_numbers(self.test_cases[9]), arrange_numerals(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()