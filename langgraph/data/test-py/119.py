# Source Code
def match_parens(lst):
    def check(s):
        val = 0
        for i in s:
            if i == '(':
                val = val + 1
            else:
                val = val - 1
            if val < 0:
                return False
        return True if val == 0 else False

    S1 = lst[0] + lst[1]
    S2 = lst[1] + lst[0]
    return 'Yes' if check(S1) or check(S2) else 'No'

# Transformed Code (Semantically Equivalent)
def validate_parentheses_combinations(strings):
    def is_balanced(expression):
        balance = 0
        for char in expression:
            if char == '(':
                balance += 1
            elif char == ')':
                balance -= 1
            if balance < 0:
                return False
        return balance == 0

    combined_first_second = strings[0] + strings[1]
    combined_second_first = strings[1] + strings[0]
    
    if is_balanced(combined_first_second) or is_balanced(combined_second_first):
        return 'Yes'
    else:
        return 'No'

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (["()", "()"], "Yes"),
        (["(", ")"], "Yes"),
        (["(()", "())"], "Yes"),
        (["(", "("], "No"),
        (["))", "(("], "No"),
        (["(())", "()"], "Yes"),
        (["((()))", ""], "Yes"),
        (["", ""], "Yes"),
        (["()(", ")"], "Yes"),
        (["(()", "()())"], "Yes")
    ]

    def test_0(self):
        self.assertEqual(match_parens(self.test_cases[0][0]), validate_parentheses_combinations(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(match_parens(self.test_cases[1][0]), validate_parentheses_combinations(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(match_parens(self.test_cases[2][0]), validate_parentheses_combinations(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(match_parens(self.test_cases[3][0]), validate_parentheses_combinations(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(match_parens(self.test_cases[4][0]), validate_parentheses_combinations(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(match_parens(self.test_cases[5][0]), validate_parentheses_combinations(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(match_parens(self.test_cases[6][0]), validate_parentheses_combinations(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(match_parens(self.test_cases[7][0]), validate_parentheses_combinations(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(match_parens(self.test_cases[8][0]), validate_parentheses_combinations(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(match_parens(self.test_cases[9][0]), validate_parentheses_combinations(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()