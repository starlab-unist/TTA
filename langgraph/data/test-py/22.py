from typing import List, Any
import unittest


# Source Code
def filter_integers(values: List[Any]) -> List[int]:
    return [x for x in values if isinstance(x, int)]


# Transformed Code (Semantically Equivalent)
def extract_integers(data: List[Any]) -> List[int]:
    result = []
    for item in data:
        if isinstance(item, int):
            result.append(item)
    return result

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [1, 2, 3.5, 'a', 4],
        ['hello', 100, 200, 'world'],
        [1, 2, 3, 4, 5],
        ['x', 'y', 'z'],
        [None, True, False, 0, 1],
        [],
        [1.1, 2.2, 3.3],
        [1, '1', 2, '2', 3, '3'],
        [0, -1, -2, 3, 4],
        ['test', 123, 'example', 456]
    ]

    def test_0(self):
        self.assertEqual(filter_integers(self.test_cases[0]), extract_integers(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(filter_integers(self.test_cases[1]), extract_integers(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(filter_integers(self.test_cases[2]), extract_integers(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(filter_integers(self.test_cases[3]), extract_integers(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(filter_integers(self.test_cases[4]), extract_integers(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(filter_integers(self.test_cases[5]), extract_integers(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(filter_integers(self.test_cases[6]), extract_integers(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(filter_integers(self.test_cases[7]), extract_integers(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(filter_integers(self.test_cases[8]), extract_integers(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(filter_integers(self.test_cases[9]), extract_integers(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()