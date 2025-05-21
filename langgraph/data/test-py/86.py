def anti_shuffle(s):
    return ' '.join([''.join(sorted(list(i))) for i in s.split(' ')])

def order_words_characters(input_string):
    result = []
    for word in input_string.split(' '):
        sorted_word = ''.join(sorted(word))
        result.append(sorted_word)
    return ' '.join(result)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello world",
        "python is fun",
        "openai gpt",
        "shuffle this string",
        "keep it sorted",
        "characters in words",
        "simple test case",
        "another example here",
        "singleword",
        ""
    ]

    def test_0(self):
        self.assertEqual(anti_shuffle(self.test_cases[0]), order_words_characters(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(anti_shuffle(self.test_cases[1]), order_words_characters(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(anti_shuffle(self.test_cases[2]), order_words_characters(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(anti_shuffle(self.test_cases[3]), order_words_characters(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(anti_shuffle(self.test_cases[4]), order_words_characters(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(anti_shuffle(self.test_cases[5]), order_words_characters(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(anti_shuffle(self.test_cases[6]), order_words_characters(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(anti_shuffle(self.test_cases[7]), order_words_characters(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(anti_shuffle(self.test_cases[8]), order_words_characters(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(anti_shuffle(self.test_cases[9]), order_words_characters(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()