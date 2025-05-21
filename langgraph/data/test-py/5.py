from typing import List
import unittest

# Source Code
def intersperse(numbers: List[int], delimeter: int) -> List[int]:
    if not numbers:
        return []

    result = []

    for n in numbers[:-1]:
        result.append(n)
        result.append(delimeter)

    result.append(numbers[-1])

    return result

# Transformed Code (Semantically Equivalent)
def weave_numbers(sequence: List[int], separator: int) -> List[int]:
    if not sequence:
        return []

    interleaved = []
    index = 0

    while index < len(sequence) - 1:
        interleaved.extend([sequence[index], separator])
        index += 1

    interleaved.append(sequence[-1])

    return interleaved

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ([1, 2, 3], 0),
        ([5, 6, 7, 8], -1),
        ([10], 5),
        ([], 3),
        ([1, 1, 1, 1], 2),
        ([9, 8, 7], 4),
        ([2, 4, 6, 8, 10], 1),
        ([3, 3, 3], 3),
        ([5], 5),
        ([7, 8], 9)
    ]

    def test_0(self):
        self.assertEqual(intersperse(self.test_cases[0][0], self.test_cases[0][1]), weave_numbers(self.test_cases[0][0], self.test_cases[0][1]))
    
    def test_1(self):
        self.assertEqual(intersperse(self.test_cases[1][0], self.test_cases[1][1]), weave_numbers(self.test_cases[1][0], self.test_cases[1][1]))

    def test_2(self):
        self.assertEqual(intersperse(self.test_cases[2][0], self.test_cases[2][1]), weave_numbers(self.test_cases[2][0], self.test_cases[2][1]))
    
    def test_3(self):
        self.assertEqual(intersperse(self.test_cases[3][0], self.test_cases[3][1]), weave_numbers(self.test_cases[3][0], self.test_cases[3][1]))

    def test_4(self):
        self.assertEqual(intersperse(self.test_cases[4][0], self.test_cases[4][1]), weave_numbers(self.test_cases[4][0], self.test_cases[4][1]))
        
    def test_5(self):
        self.assertEqual(intersperse(self.test_cases[5][0], self.test_cases[5][1]), weave_numbers(self.test_cases[5][0], self.test_cases[5][1]))

    def test_6(self):
        self.assertEqual(intersperse(self.test_cases[6][0], self.test_cases[6][1]), weave_numbers(self.test_cases[6][0], self.test_cases[6][1]))
    
    def test_7(self):
        self.assertEqual(intersperse(self.test_cases[7][0], self.test_cases[7][1]), weave_numbers(self.test_cases[7][0], self.test_cases[7][1]))

    def test_8(self):
        self.assertEqual(intersperse(self.test_cases[8][0], self.test_cases[8][1]), weave_numbers(self.test_cases[8][0], self.test_cases[8][1]))
    
    def test_9(self):
        self.assertEqual(intersperse(self.test_cases[9][0], self.test_cases[9][1]), weave_numbers(self.test_cases[9][0], self.test_cases[9][1]))

if __name__ == '__main__':
    unittest.main()