def split_words(txt):
    if " " in txt:
        return txt.split()
    elif "," in txt:
        return txt.replace(',',' ').split()
    else:
        return len([i for i in txt if i.islower() and ord(i)%2 == 0])

def extract_and_count_words(input_text):
    if ' ' in input_text:
        word_list = input_text.split()
    elif ',' in input_text:
        word_list = input_text.replace(',', ' ').split()
    else:
        count = sum(1 for char in input_text if char.islower() and ord(char) % 2 == 0)
        return count

    return word_list

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello world",
        "apple,banana,cherry",
        "one,two three",
        "abcdefg",
        "hijklmno",
        "pqrstuvw",
        "xyz",
        "123456",
        "",
        "a,b,c,d,e,f,g,h,i,j"
    ]

    def test_0(self):
        self.assertEqual(split_words(self.test_cases[0]), extract_and_count_words(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(split_words(self.test_cases[1]), extract_and_count_words(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(split_words(self.test_cases[2]), extract_and_count_words(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(split_words(self.test_cases[3]), extract_and_count_words(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(split_words(self.test_cases[4]), extract_and_count_words(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(split_words(self.test_cases[5]), extract_and_count_words(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(split_words(self.test_cases[6]), extract_and_count_words(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(split_words(self.test_cases[7]), extract_and_count_words(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(split_words(self.test_cases[8]), extract_and_count_words(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(split_words(self.test_cases[9]), extract_and_count_words(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()