from typing import List


# Source Code
def parse_nested_parens(paren_string: str) -> List[int]:
    def parse_paren_group(s):
        depth = 0
        max_depth = 0
        for c in s:
            if c == '(':
                depth += 1
                max_depth = max(depth, max_depth)
            else:
                depth -= 1

        return max_depth

    return [parse_paren_group(x) for x in paren_string.split(' ') if x]


# Transformed Code (Semantically Equivalent)
def analyze_parentheses_depth(paren_sequence: str) -> List[int]:
    def calculate_max_nesting_level(substring):
        current_level = 0
        peak_level = 0
        for character in substring:
            if character == '(':
                current_level += 1
                peak_level = max(current_level, peak_level)
            elif character == ')':
                current_level -= 1

        return peak_level

    return [calculate_max_nesting_level(segment) for segment in paren_sequence.split() if segment]


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "(()) ()",
        "((())) (()) ()",
        "()",
        "((( ))) (( )) ( )",
        "",
        "(()(()))",
        "((()()()))",
        "((())) () ()",
        "(((())))",
        "() () ()"
    ]

    def test_0(self):
        self.assertEqual(parse_nested_parens(self.test_cases[0]), analyze_parentheses_depth(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(parse_nested_parens(self.test_cases[1]), analyze_parentheses_depth(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(parse_nested_parens(self.test_cases[2]), analyze_parentheses_depth(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(parse_nested_parens(self.test_cases[3]), analyze_parentheses_depth(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(parse_nested_parens(self.test_cases[4]), analyze_parentheses_depth(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(parse_nested_parens(self.test_cases[5]), analyze_parentheses_depth(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(parse_nested_parens(self.test_cases[6]), analyze_parentheses_depth(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(parse_nested_parens(self.test_cases[7]), analyze_parentheses_depth(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(parse_nested_parens(self.test_cases[8]), analyze_parentheses_depth(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(parse_nested_parens(self.test_cases[9]), analyze_parentheses_depth(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()