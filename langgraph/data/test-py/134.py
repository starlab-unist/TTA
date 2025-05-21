def check_if_last_char_is_a_letter(txt):
    check = txt.split(' ')[-1]
    return True if len(check) == 1 and (97 <= ord(check.lower()) <= 122) else False

def determine_if_final_character_is_alphabetic(input_string):
    last_word = input_string.rsplit(' ', 1)[-1]
    return len(last_word) == 1 and 'a' <= last_word.lower() <= 'z'

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello world a",
        "test z",
        "123 b",
        "c",
        "no letters here !",
        "singleword x",
        "spaces at the end ",
        "  leading spaces y",
        "",
        "onlyoneletter"
    ]

    def test_0(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[0]), determine_if_final_character_is_alphabetic(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[1]), determine_if_final_character_is_alphabetic(self.test_cases[1]))

    def test_2(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[2]), determine_if_final_character_is_alphabetic(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[3]), determine_if_final_character_is_alphabetic(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[4]), determine_if_final_character_is_alphabetic(self.test_cases[4]))

    def test_5(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[5]), determine_if_final_character_is_alphabetic(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[6]), determine_if_final_character_is_alphabetic(self.test_cases[6]))

    def test_7(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[7]), determine_if_final_character_is_alphabetic(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[8]), determine_if_final_character_is_alphabetic(self.test_cases[8]))

    def test_9(self):
        self.assertEqual(check_if_last_char_is_a_letter(self.test_cases[9]), determine_if_final_character_is_alphabetic(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()