def same_chars(s0: str, s1: str):
    return set(s0) == set(s1)

def compare_character_sets(string_one: str, string_two: str) -> bool:
    set_of_chars_one = set(string_one)
    set_of_chars_two = set(string_two)
    
    return set_of_chars_one == set_of_chars_two

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("hello", "olleh"),
        ("world", "dlrow"),
        ("python", "nothyp"),
        ("openai", "ipaneo"),
        ("", ""),
        ("a", "a"),
        ("ab", "ba"),
        ("abc", "cba"),
        ("abcd", "dcba"),
        ("xyz", "zyx")
    ]

    def test_0(self):
        self.assertEqual(same_chars(*self.test_cases[0]), compare_character_sets(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(same_chars(*self.test_cases[1]), compare_character_sets(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(same_chars(*self.test_cases[2]), compare_character_sets(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(same_chars(*self.test_cases[3]), compare_character_sets(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(same_chars(*self.test_cases[4]), compare_character_sets(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(same_chars(*self.test_cases[5]), compare_character_sets(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(same_chars(*self.test_cases[6]), compare_character_sets(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(same_chars(*self.test_cases[7]), compare_character_sets(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(same_chars(*self.test_cases[8]), compare_character_sets(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(same_chars(*self.test_cases[9]), compare_character_sets(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()