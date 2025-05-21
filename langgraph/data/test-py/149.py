# Source Code
def sorted_list_sum(lst):
    lst.sort()
    new_lst = []
    for i in lst:
        if len(i) % 2 == 0:
            new_lst.append(i)
    return sorted(new_lst, key=len)

# Transformed Code (Semantically Equivalent)
def even_length_sorted_elements(sequence):
    sequence.sort()
    filtered_sequence = [element for element in sequence if len(element) % 2 == 0]
    return sorted(filtered_sequence, key=len)

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ["apple", "banana", "cherry", "date"],
        ["one", "two", "three", "four", "five"],
        ["a", "bb", "ccc", "dddd", "eeeee", "ffffff"],
        ["", "a", "ab", "abc", "abcd", "abcde", "abcdef"],
        ["python", "java", "c++", "ruby", "swift", "go"],
        ["hello", "world", "foo", "bar", "baz"],
        ["short", "longer", "longest", "tiny"],
        ["even", "odd", "pair", "single"],
        ["aa", "bb", "cc", "dd"],
        ["abcd", "efgh", "ijkl", "mnop"]
    ]

    def test_0(self):
        self.assertEqual(sorted_list_sum(self.test_cases[0]), even_length_sorted_elements(self.test_cases[0]))

    def test_1(self):
        self.assertEqual(sorted_list_sum(self.test_cases[1]), even_length_sorted_elements(self.test_cases[1]))

    def test_2(self):
        self.assertEqual(sorted_list_sum(self.test_cases[2]), even_length_sorted_elements(self.test_cases[2]))

    def test_3(self):
        self.assertEqual(sorted_list_sum(self.test_cases[3]), even_length_sorted_elements(self.test_cases[3]))

    def test_4(self):
        self.assertEqual(sorted_list_sum(self.test_cases[4]), even_length_sorted_elements(self.test_cases[4]))

    def test_5(self):
        self.assertEqual(sorted_list_sum(self.test_cases[5]), even_length_sorted_elements(self.test_cases[5]))

    def test_6(self):
        self.assertEqual(sorted_list_sum(self.test_cases[6]), even_length_sorted_elements(self.test_cases[6]))

    def test_7(self):
        self.assertEqual(sorted_list_sum(self.test_cases[7]), even_length_sorted_elements(self.test_cases[7]))

    def test_8(self):
        self.assertEqual(sorted_list_sum(self.test_cases[8]), even_length_sorted_elements(self.test_cases[8]))

    def test_9(self):
        self.assertEqual(sorted_list_sum(self.test_cases[9]), even_length_sorted_elements(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()