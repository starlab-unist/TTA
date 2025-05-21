# Source Code
def words_in_sentence(sentence):
    new_lst = []
    for word in sentence.split():
        flg = 0
        if len(word) == 1:
            flg = 1
        for i in range(2, len(word)):
            if len(word)%i == 0:
                flg = 1
        if flg == 0 or len(word) == 2:
            new_lst.append(word)
    return " ".join(new_lst)

# Transformed Code (Semantically Equivalent)
def filter_unique_length_words(phrase):
    result = []
    for term in phrase.split():
        flag = False
        if len(term) == 1:
            flag = True
        divisor = 2
        while divisor < len(term):
            if len(term) % divisor == 0:
                flag = True
                break
            divisor += 1
        if not flag or len(term) == 2:
            result.append(term)
    return " ".join(result)

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello world",
        "a bb ccc dddd eeeee fffffff",
        "prime number test",
        "two three five seven eleven",
        "abc def ghi jkl mno pqr stu vwx yz",
        "one two one two",
        "x y z",
        "ab cd ef gh ij kl mn op qr st uv wx yz",
        "",
        "a"
    ]

    def test_0(self):
        self.assertEqual(words_in_sentence(self.test_cases[0]), filter_unique_length_words(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(words_in_sentence(self.test_cases[1]), filter_unique_length_words(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(words_in_sentence(self.test_cases[2]), filter_unique_length_words(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(words_in_sentence(self.test_cases[3]), filter_unique_length_words(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(words_in_sentence(self.test_cases[4]), filter_unique_length_words(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(words_in_sentence(self.test_cases[5]), filter_unique_length_words(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(words_in_sentence(self.test_cases[6]), filter_unique_length_words(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(words_in_sentence(self.test_cases[7]), filter_unique_length_words(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(words_in_sentence(self.test_cases[8]), filter_unique_length_words(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(words_in_sentence(self.test_cases[9]), filter_unique_length_words(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()