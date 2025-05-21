def histogram(test):
    dict1={}
    list1=test.split(" ")
    t=0

    for i in list1:
        if(list1.count(i)>t) and i!='':
            t=list1.count(i)
    if t>0:
        for i in list1:
            if(list1.count(i)==t):
                
                dict1[i]=t
    return dict1

def generate_frequency_map(input_string):
    frequency_dict = {}
    word_list = input_string.split()
    max_count = 0

    for word in word_list:
        current_count = word_list.count(word)
        if current_count > max_count and word != '':
            max_count = current_count

    if max_count > 0:
        for word in word_list:
            if word_list.count(word) == max_count:
                frequency_dict[word] = max_count

    return frequency_dict

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "apple apple banana",
        "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty",
        "a a a b b c",
        "hello world hello",
        "test test test test",
        "unique words only here",
        "repeated repeated repeated repeated",
        "no no no no no no no",
        "singleword",
        ""
    ]

    def test_0(self):
        self.assertEqual(histogram(self.test_cases[0]), generate_frequency_map(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(histogram(self.test_cases[1]), generate_frequency_map(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(histogram(self.test_cases[2]), generate_frequency_map(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(histogram(self.test_cases[3]), generate_frequency_map(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(histogram(self.test_cases[4]), generate_frequency_map(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(histogram(self.test_cases[5]), generate_frequency_map(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(histogram(self.test_cases[6]), generate_frequency_map(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(histogram(self.test_cases[7]), generate_frequency_map(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(histogram(self.test_cases[8]), generate_frequency_map(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(histogram(self.test_cases[9]), generate_frequency_map(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()