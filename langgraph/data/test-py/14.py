from typing import List


# Source Code
def all_prefixes(string: str) -> List[str]:
    result = []

    for i in range(len(string)):
        result.append(string[:i+1])
    return result


# Transformed Code (Semantically Equivalent)
def generate_string_prefixes(input_str: str) -> List[str]:
    prefixes = []
    index = 0

    while index < len(input_str):
        prefixes.append(input_str[:index + 1])
        index += 1

    return prefixes


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "hello",
        "world",
        "a",
        "",
        "python",
        "unittest",
        "12345",
        "prefixes",
        "testcase",
        "semantics"
    ]

    def test_0(self):
        self.assertEqual(all_prefixes(self.test_cases[0]), generate_string_prefixes(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(all_prefixes(self.test_cases[1]), generate_string_prefixes(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(all_prefixes(self.test_cases[2]), generate_string_prefixes(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(all_prefixes(self.test_cases[3]), generate_string_prefixes(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(all_prefixes(self.test_cases[4]), generate_string_prefixes(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(all_prefixes(self.test_cases[5]), generate_string_prefixes(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(all_prefixes(self.test_cases[6]), generate_string_prefixes(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(all_prefixes(self.test_cases[7]), generate_string_prefixes(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(all_prefixes(self.test_cases[8]), generate_string_prefixes(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(all_prefixes(self.test_cases[9]), generate_string_prefixes(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()