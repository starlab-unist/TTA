def reverse_delete(s,c):
    s = ''.join([char for char in s if char not in c])
    return (s,s[::-1] == s)

def filter_and_check_palindrome(input_string, chars_to_remove):
    filtered_string = ''.join(character for character in input_string if character not in chars_to_remove)
    is_palindrome = filtered_string == filtered_string[::-1]
    return filtered_string, is_palindrome

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("abcba", "x"),
        ("abccba", "x"),
        ("hello", "aeiou"),
        ("racecar", ""),
        ("palindrome", "xyz"),
        ("", "a"),
        ("aabbcc", "abc"),
        ("rotor", "r"),
        ("deified", "d"),
        ("noon", "n")
    ]

    def test_0(self):
        self.assertEqual(reverse_delete(*self.test_cases[0]), filter_and_check_palindrome(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(reverse_delete(*self.test_cases[1]), filter_and_check_palindrome(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(reverse_delete(*self.test_cases[2]), filter_and_check_palindrome(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(reverse_delete(*self.test_cases[3]), filter_and_check_palindrome(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(reverse_delete(*self.test_cases[4]), filter_and_check_palindrome(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(reverse_delete(*self.test_cases[5]), filter_and_check_palindrome(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(reverse_delete(*self.test_cases[6]), filter_and_check_palindrome(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(reverse_delete(*self.test_cases[7]), filter_and_check_palindrome(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(reverse_delete(*self.test_cases[8]), filter_and_check_palindrome(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(reverse_delete(*self.test_cases[9]), filter_and_check_palindrome(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()