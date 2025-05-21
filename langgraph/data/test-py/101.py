# Source Code
def words_string(s):
    if not s:
        return []

    s_list = []

    for letter in s:
        if letter == ',':
            s_list.append(' ')
        else:
            s_list.append(letter)

    s_list = "".join(s_list)
    return s_list.split()

# Transformed Code (Semantically Equivalent)
def process_text(input_string):
    if not input_string:
        return []

    processed_chars = []

    index = 0
    while index < len(input_string):
        char = input_string[index]
        if char == ',':
            processed_chars.append(' ')
        else:
            processed_chars.append(char)
        index += 1

    processed_string = ''.join(processed_chars)
    return processed_string.split()

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello,world",
        "Python,is,great!",
        "OpenAI,ChatGPT",
        "This,is,a,test,string",
        "No commas here",
        ",Leading and trailing,",
        "Multiple,,,commas,,here",
        "",
        " ",
        "OneWord"
    ]

    def test_0(self):
        self.assertEqual(words_string(self.test_cases[0]), process_text(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(words_string(self.test_cases[1]), process_text(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(words_string(self.test_cases[2]), process_text(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(words_string(self.test_cases[3]), process_text(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(words_string(self.test_cases[4]), process_text(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(words_string(self.test_cases[5]), process_text(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(words_string(self.test_cases[6]), process_text(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(words_string(self.test_cases[7]), process_text(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(words_string(self.test_cases[8]), process_text(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(words_string(self.test_cases[9]), process_text(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()