def select_words(s, n):
    result = []
    for word in s.split():
        n_consonants = 0
        for i in range(0, len(word)):
            if word[i].lower() not in ["a","e","i","o","u"]:
                n_consonants += 1 
        if n_consonants == n:
            result.append(word)
    return result

def filter_words_by_consonant_count(input_string, target_consonant_count):
    selected_words = []
    words = input_string.split()

    for word in words:
        consonant_counter = 0
        index = 0
        while index < len(word):
            if word[index].lower() not in "aeiou":
                consonant_counter += 1
            index += 1

        if consonant_counter == target_consonant_count:
            selected_words.append(word)

    return selected_words

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ("hello world", 3),
        ("this is a test", 2),
        ("consonants and vowels", 4),
        ("python programming", 5),
        ("simple words", 1),
        ("", 0),
        ("a e i o u", 0),
        ("bcd fgh jkl", 3),
        ("same same same", 3),
        ("different words here", 4)
    ]

    def test_0(self):
        self.assertEqual(select_words(*self.test_cases[0]), filter_words_by_consonant_count(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(select_words(*self.test_cases[1]), filter_words_by_consonant_count(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(select_words(*self.test_cases[2]), filter_words_by_consonant_count(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(select_words(*self.test_cases[3]), filter_words_by_consonant_count(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(select_words(*self.test_cases[4]), filter_words_by_consonant_count(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(select_words(*self.test_cases[5]), filter_words_by_consonant_count(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(select_words(*self.test_cases[6]), filter_words_by_consonant_count(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(select_words(*self.test_cases[7]), filter_words_by_consonant_count(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(select_words(*self.test_cases[8]), filter_words_by_consonant_count(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(select_words(*self.test_cases[9]), filter_words_by_consonant_count(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()