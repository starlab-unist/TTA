# Source Code
def even_odd_palindrome(n):
    def is_palindrome(n):
        return str(n) == str(n)[::-1]

    even_palindrome_count = 0
    odd_palindrome_count = 0

    for i in range(1, n+1):
        if i%2 == 1 and is_palindrome(i):
                odd_palindrome_count += 1
        elif i%2 == 0 and is_palindrome(i):
            even_palindrome_count += 1
    return (even_palindrome_count, odd_palindrome_count)

# Transformed Code (Semantically Equivalent)
def count_even_odd_palindromes(limit):
    def check_palindrome(number):
        return str(number) == str(number)[::-1]

    even_count = 0
    odd_count = 0

    current_number = 1
    while current_number <= limit:
        if current_number % 2 == 1 and check_palindrome(current_number):
            odd_count += 1
        elif current_number % 2 == 0 and check_palindrome(current_number):
            even_count += 1
        current_number += 1

    return (even_count, odd_count)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        1,
        10,
        20,
        50,
        100,
        200,
        300,
        400,
        500,
        1000
    ]

    def test_0(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[0]), count_even_odd_palindromes(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[1]), count_even_odd_palindromes(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[2]), count_even_odd_palindromes(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[3]), count_even_odd_palindromes(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[4]), count_even_odd_palindromes(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[5]), count_even_odd_palindromes(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[6]), count_even_odd_palindromes(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[7]), count_even_odd_palindromes(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[8]), count_even_odd_palindromes(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(even_odd_palindrome(self.test_cases[9]), count_even_odd_palindromes(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()