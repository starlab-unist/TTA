from typing import List


def filter_by_substring(strings: List[str], substring: str) -> List[str]:
    return [x for x in strings if substring in x]


def extract_matching_strings(sequence: List[str], pattern: str) -> List[str]:
    result = []
    index = 0
    while index < len(sequence):
        if pattern in sequence[index]:
            result.append(sequence[index])
        index += 1
    return result


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (["hello", "world", "help"], "he"),
        (["apple", "banana", "cherry"], "a"),
        (["one", "two", "three"], "four"),
        ([], "test"),
        (["abc", "def", "ghi"], ""),
        (["123", "456", "789"], "5"),
        (["repeat", "repeal", "replace"], "rep"),
        (["same", "same", "same"], "s"),
        (["unique"], "uni"),
        (["different", "words", "here"], "word")
    ]

    def test_0(self):
        self.assertEqual(filter_by_substring(*self.test_cases[0]), extract_matching_strings(*self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(filter_by_substring(*self.test_cases[1]), extract_matching_strings(*self.test_cases[1]))

    def test_2(self):
        self.assertEqual(filter_by_substring(*self.test_cases[2]), extract_matching_strings(*self.test_cases[2]))

    def test_3(self):
        self.assertEqual(filter_by_substring(*self.test_cases[3]), extract_matching_strings(*self.test_cases[3]))

    def test_4(self):
        self.assertEqual(filter_by_substring(*self.test_cases[4]), extract_matching_strings(*self.test_cases[4]))

    def test_5(self):
        self.assertEqual(filter_by_substring(*self.test_cases[5]), extract_matching_strings(*self.test_cases[5]))

    def test_6(self):
        self.assertEqual(filter_by_substring(*self.test_cases[6]), extract_matching_strings(*self.test_cases[6]))

    def test_7(self):
        self.assertEqual(filter_by_substring(*self.test_cases[7]), extract_matching_strings(*self.test_cases[7]))

    def test_8(self):
        self.assertEqual(filter_by_substring(*self.test_cases[8]), extract_matching_strings(*self.test_cases[8]))

    def test_9(self):
        self.assertEqual(filter_by_substring(*self.test_cases[9]), extract_matching_strings(*self.test_cases[9]))


if __name__ == '__main__':
    unittest.main()