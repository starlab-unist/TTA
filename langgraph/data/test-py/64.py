# Source Code
def vowels_count(s):
    if not s:
        return 0

    vowels = "aeiouAEIOU"
    n_vowels = sum(c in vowels for c in s)
    
    if s[-1] == 'y' or s[-1] == 'Y':
        n_vowels += 1
    
    return n_vowels

# Transformed Code (Semantically Equivalent)
def tally_vowels(input_string):
    vowel_set = "aeiouAEIOU"
    vowel_counter = 0

    for character in input_string:
        if character in vowel_set:
            vowel_counter += 1

    if input_string.endswith(('y', 'Y')):
        vowel_counter += 1

    return vowel_counter

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello",
        "HELLO",
        "sky",
        "SYZYGY",
        "rhythm",
        "AEIOUY",
        "abcdefghijklmnopqrstuvwxyz",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "Python",
        "",
        "a",
        "Y",
        "y",
        "bcd",
        "aeiou"
    ]

    def test_hello(self):
        self.assertEqual(vowels_count(self.test_cases[0]), tally_vowels(self.test_cases[0]))

    def test_hello_upper(self):
        self.assertEqual(vowels_count(self.test_cases[1]), tally_vowels(self.test_cases[1]))

    def test_sky(self):
        self.assertEqual(vowels_count(self.test_cases[2]), tally_vowels(self.test_cases[2]))

    def test_syzygy(self):
        self.assertEqual(vowels_count(self.test_cases[3]), tally_vowels(self.test_cases[3]))

    def test_rhythm(self):
        self.assertEqual(vowels_count(self.test_cases[4]), tally_vowels(self.test_cases[4]))

    def test_aeiouy_upper(self):
        self.assertEqual(vowels_count(self.test_cases[5]), tally_vowels(self.test_cases[5]))

    def test_alphabet_lowercase(self):
        self.assertEqual(vowels_count(self.test_cases[6]), tally_vowels(self.test_cases[6]))

    def test_alphabet_uppercase(self):
        self.assertEqual(vowels_count(self.test_cases[7]), tally_vowels(self.test_cases[7]))

    def test_python(self):
        self.assertEqual(vowels_count(self.test_cases[8]), tally_vowels(self.test_cases[8]))

    def test_empty_string(self):
        self.assertEqual(vowels_count(self.test_cases[9]), tally_vowels(self.test_cases[9]))
        self.assertEqual(vowels_count(""), 0)  # Expected number of vowels in an empty string is 0.

    def test_single_a(self):
        self.assertEqual(vowels_count(self.test_cases[10]), tally_vowels(self.test_cases[10]))

    def test_single_Y_upper(self):
        self.assertEqual(vowels_count(self.test_cases[11]), tally_vowels(self.test_cases[11]))
        self.assertEqual(vowels_count("Y"), 1)  # 'Y' is a vowel and the last character.

    def test_single_y_lower(self):
        self.assertEqual(vowels_count(self.test_cases[12]), tally_vowels(self.test_cases[12]))
        self.assertEqual(vowels_count("y"), 1)  # 'y' is a vowel and the last character.

    def test_bcd(self):
        self.assertEqual(vowels_count(self.test_cases[13]), tally_vowels(self.test_cases[13]))

    def test_aeiou(self):
        self.assertEqual(vowels_count(self.test_cases[14]), tally_vowels(self.test_cases[14]))

if __name__ == '__main__':
    unittest.main()