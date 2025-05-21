# Source Code
def fix_spaces(text):
    new_text = ""
    i = 0
    start, end = 0, 0
    while i < len(text):
        if text[i] == " ":
            end += 1
        else:
            if end - start > 2:
                new_text += "-"+text[i]
            elif end - start > 0:
                new_text += "_"*(end - start)+text[i]
            else:
                new_text += text[i]
            start, end = i+1, i+1
        i+=1
    if end - start > 2:
        new_text += "-"
    elif end - start > 0:
        new_text += "_"
    return new_text

# Transformed Code (Semantically Equivalent)
def adjust_whitespace(input_string):
    result = ""
    index = 0
    begin, finish = 0, 0
    while index < len(input_string):
        if input_string[index] == " ":
            finish += 1
        else:
            space_count = finish - begin
            if space_count > 2:
                result += "-" + input_string[index]
            elif space_count > 0:
                result += "_" * space_count + input_string[index]
            else:
                result += input_string[index]
            begin, finish = index + 1, index + 1
        index += 1
    final_space_count = finish - begin
    if final_space_count > 2:
        result += "-"
    elif final_space_count > 0:
        result += "_"
    return result

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "Hello   world",
        "This is  a test",
        "Multiple     spaces",
        "NoSpacesHere",
        " ",
        "  ",
        "   ",
        "    ",
        "a b c d e f g h i j",
        "OpenAI     Inc"
    ]

    def test_0(self):
        self.assertEqual(fix_spaces(self.test_cases[0]), adjust_whitespace(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(fix_spaces(self.test_cases[1]), adjust_whitespace(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(fix_spaces(self.test_cases[2]), adjust_whitespace(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(fix_spaces(self.test_cases[3]), adjust_whitespace(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(fix_spaces(self.test_cases[4]), adjust_whitespace(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(fix_spaces(self.test_cases[5]), adjust_whitespace(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(fix_spaces(self.test_cases[6]), adjust_whitespace(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(fix_spaces(self.test_cases[7]), adjust_whitespace(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(fix_spaces(self.test_cases[8]), adjust_whitespace(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(fix_spaces(self.test_cases[9]), adjust_whitespace(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()