from typing import List
import unittest

# Source Code
def separate_paren_groups(paren_string: str) -> List[str]:
    result = []
    current_string = []
    current_depth = 0

    for c in paren_string:
        if c == '(':
            current_depth += 1
            current_string.append(c)
        elif c == ')':
            current_depth -= 1
            current_string.append(c)

            if current_depth == 0:
                result.append(''.join(current_string))
                current_string.clear()

    return result

# Transformed Code (Semantically Equivalent)
def extract_balanced_parentheses(input_sequence: str) -> List[str]:
    output_groups = []
    temp_group = []
    nesting_level = 0

    index = 0
    while index < len(input_sequence):
        character = input_sequence[index]
        if character == '(':
            nesting_level += 1
            temp_group.append(character)
        elif character == ')':
            nesting_level -= 1
            temp_group.append(character)

            if nesting_level == 0:
                output_groups.append(''.join(temp_group))
                temp_group = []

        index += 1

    return output_groups

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "()",
        "(())",
        "((()))",
        "(()())",
        "()(())",
        "(()(()))",
        "",
        "a(b)c(d(e)f)g",
        "(abc)(def)",
        "((a)(b))(c)"
    ]

    def test_0(self):
        self.assertEqual(separate_paren_groups(self.test_cases[0]), extract_balanced_parentheses(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(separate_paren_groups(self.test_cases[1]), extract_balanced_parentheses(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(separate_paren_groups(self.test_cases[2]), extract_balanced_parentheses(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(separate_paren_groups(self.test_cases[3]), extract_balanced_parentheses(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(separate_paren_groups(self.test_cases[4]), extract_balanced_parentheses(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(separate_paren_groups(self.test_cases[5]), extract_balanced_parentheses(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(separate_paren_groups(self.test_cases[6]), extract_balanced_parentheses(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(separate_paren_groups(self.test_cases[7]), extract_balanced_parentheses(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(separate_paren_groups(self.test_cases[8]), extract_balanced_parentheses(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(separate_paren_groups(self.test_cases[9]), extract_balanced_parentheses(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()