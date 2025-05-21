# Source Code
def correct_bracketing(brackets: str):
    depth = 0
    for b in brackets:
        if b == "<":
            depth += 1
        else:
            depth -= 1
        if depth < 0:
            return False
    return depth == 0

# Transformed Code (Semantically Equivalent)
def validate_bracket_sequence(sequence: str):
    level = 0
    index = 0
    while index < len(sequence):
        if sequence[index] == "<":
            level += 1
        else:
            level -= 1
        if level < 0:
            return False
        index += 1
    return level == 0

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "<>",
        "<<>>",
        "<<<>>>",
        "><",
        "<<><>>",
        "",
        "<<<<>>>>",
        "<<>><<>>",
        "<<<<><>>",
        "<<<<>>><"
    ]

    def test_0(self):
        self.assertEqual(correct_bracketing(self.test_cases[0]), validate_bracket_sequence(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(correct_bracketing(self.test_cases[1]), validate_bracket_sequence(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(correct_bracketing(self.test_cases[2]), validate_bracket_sequence(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(correct_bracketing(self.test_cases[3]), validate_bracket_sequence(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(correct_bracketing(self.test_cases[4]), validate_bracket_sequence(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(correct_bracketing(self.test_cases[5]), validate_bracket_sequence(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(correct_bracketing(self.test_cases[6]), validate_bracket_sequence(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(correct_bracketing(self.test_cases[7]), validate_bracket_sequence(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(correct_bracketing(self.test_cases[8]), validate_bracket_sequence(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(correct_bracketing(self.test_cases[9]), validate_bracket_sequence(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()