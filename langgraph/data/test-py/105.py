def by_length(arr):
    dic = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    }
    sorted_arr = sorted(arr, reverse=True)
    new_arr = []
    for var in sorted_arr:
        try:
            new_arr.append(dic[var])
        except:
            pass
    return new_arr

def arrange_by_number_name(numbers):
    number_names = {
        1: "One",
        2: "Two",
        3: "Three",
        4: "Four",
        5: "Five",
        6: "Six",
        7: "Seven",
        8: "Eight",
        9: "Nine",
    }
    descending_numbers = sorted(numbers, key=lambda x: -x)
    named_numbers = []
    index = 0
    while index < len(descending_numbers):
        num = descending_numbers[index]
        if num in number_names:
            named_numbers.append(number_names[num])
        index += 1
    return named_numbers

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 2, 1],
        [9, 8, 7, 6, 5],
        [4, 4, 4, 4],
        [10, 11, 12],  # should return empty as none are in the dictionary
        [],
        [1, 2, 3, 4, 5, 6, 7, 8, 9],
        [9, 3, 5, 7, 1],
        [2, 2, 2, 3, 3, 1],
        [5],  # single element
        [0, -1, 10]   # should return empty as none are in the dictionary
    ]

    def test_0(self):
        self.assertEqual(by_length(self.test_cases[0]), arrange_by_number_name(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(by_length(self.test_cases[1]), arrange_by_number_name(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(by_length(self.test_cases[2]), arrange_by_number_name(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(by_length(self.test_cases[3]), arrange_by_number_name(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(by_length(self.test_cases[4]), arrange_by_number_name(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(by_length(self.test_cases[5]), arrange_by_number_name(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(by_length(self.test_cases[6]), arrange_by_number_name(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(by_length(self.test_cases[7]), arrange_by_number_name(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(by_length(self.test_cases[8]), arrange_by_number_name(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(by_length(self.test_cases[9]), arrange_by_number_name(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()