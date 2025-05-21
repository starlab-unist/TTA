# Source Code
def how_many_times(string: str, substring: str) -> int:
    times = 0

    for i in range(len(string) - len(substring) + 1):
        if string[i:i+len(substring)] == substring:
            times += 1

    return times


# Transformed Code (Semantically Equivalent)
def count_occurrences(main_str: str, sub_str: str) -> int:
    occurrence_count = 0
    index = 0

    while index <= len(main_str) - len(sub_str):
        if main_str[index:index+len(sub_str)] == sub_str:
            occurrence_count += 1
        index += 1

    return occurrence_count


# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("hello", "l"),          # Expected: 2
        ("banana", "na"),        # Expected: 2
        ("aaaa", "aa"),          # Expected: 3
        ("abcde", "f"),          # Expected: 0
        ("mississippi", "issi"), # Expected: 1
        ("abababa", "aba"),      # Expected: 2
        ("", ""),                # Expected: 1 (empty substring in empty string)
        ("a", ""),               # Expected: 2 (empty substring in non-empty string)
        ("hello world", "o w"),  # Expected: 1
        ("abc", "d")             # Expected: 0
    ]

    def test_0(self):
        self.assertEqual(how_many_times(*self.test_cases[0]), count_occurrences(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(how_many_times(*self.test_cases[1]), count_occurrences(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(how_many_times(*self.test_cases[2]), count_occurrences(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(how_many_times(*self.test_cases[3]), count_occurrences(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(how_many_times(*self.test_cases[4]), count_occurrences(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(how_many_times(*self.test_cases[5]), count_occurrences(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(how_many_times(*self.test_cases[6]), count_occurrences(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(how_many_times(*self.test_cases[7]), count_occurrences(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(how_many_times(*self.test_cases[8]), count_occurrences(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(how_many_times(*self.test_cases[9]), count_occurrences(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()