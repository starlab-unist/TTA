def sort_third(l: list):
    l = list(l)
    l[::3] = sorted(l[::3])
    return l

def arrange_every_third_element(input_list: list):
    elements_to_sort = input_list[::3]
    elements_to_sort.sort()
    result_list = list(input_list)
    for index, value in enumerate(elements_to_sort):
        result_list[index * 3] = value
    return result_list

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [9, 2, 3, 6, 5, 4, 1, 8, 7],
        [10, 20, 30, 40, 50, 60, 70, 80, 90],
        [1, 2, 3],
        [3, 2, 1, 6, 5, 4, 9, 8, 7],
        [],
        [5],
        [5, 10],
        [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5],
        [7, 8, 9, 1, 2, 3, 4, 5, 6],
        [0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]

    def test_0(self):
        self.assertEqual(sort_third(self.test_cases[0]), arrange_every_third_element(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(sort_third(self.test_cases[1]), arrange_every_third_element(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(sort_third(self.test_cases[2]), arrange_every_third_element(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(sort_third(self.test_cases[3]), arrange_every_third_element(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(sort_third(self.test_cases[4]), arrange_every_third_element(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(sort_third(self.test_cases[5]), arrange_every_third_element(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(sort_third(self.test_cases[6]), arrange_every_third_element(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(sort_third(self.test_cases[7]), arrange_every_third_element(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(sort_third(self.test_cases[8]), arrange_every_third_element(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(sort_third(self.test_cases[9]), arrange_every_third_element(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()