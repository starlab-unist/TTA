def total_match(lst1, lst2):
    l1 = 0
    for st in lst1:
        l1 += len(st)
    
    l2 = 0
    for st in lst2:
        l2 += len(st)
    
    if l1 <= l2:
        return lst1
    else:
        return lst2

def compare_string_lists(list_a, list_b):
    length_a = sum(len(string) for string in list_a)
    
    length_b = 0
    index = 0
    while index < len(list_b):
        length_b += len(list_b[index])
        index += 1
    
    if length_a <= length_b:
        return list_a
    return list_b

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (["hello", "world"], ["hi", "planet"]),
        (["apple", "banana"], ["kiwi", "grape", "melon"]),
        (["one"], ["two", "three"]),
        ([], ["single"]),
        (["same", "length"], ["even", "longer"]),
        (["a", "b", "c"], ["d", "e", "f"]),
        (["short"], ["tiny", "bit"]),
        (["equal"], ["equal"]),
        (["abc"], ["defg"]),
        ([], [])
    ]

    def test_0(self):
        self.assertEqual(total_match(*self.test_cases[0]), compare_string_lists(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(total_match(*self.test_cases[1]), compare_string_lists(*self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(total_match(*self.test_cases[2]), compare_string_lists(*self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(total_match(*self.test_cases[3]), compare_string_lists(*self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(total_match(*self.test_cases[4]), compare_string_lists(*self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(total_match(*self.test_cases[5]), compare_string_lists(*self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(total_match(*self.test_cases[6]), compare_string_lists(*self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(total_match(*self.test_cases[7]), compare_string_lists(*self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(total_match(*self.test_cases[8]), compare_string_lists(*self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(total_match(*self.test_cases[9]), compare_string_lists(*self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()