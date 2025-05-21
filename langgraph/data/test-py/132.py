def is_nested(string):
    opening_bracket_index = []
    closing_bracket_index = []
    for i in range(len(string)):
        if string[i] == '[':
            opening_bracket_index.append(i)
        else:
            closing_bracket_index.append(i)
    closing_bracket_index.reverse()
    cnt = 0
    i = 0
    l = len(closing_bracket_index)
    for idx in opening_bracket_index:
        if i < l and idx < closing_bracket_index[i]:
            cnt += 1
            i += 1
    return cnt >= 2

def check_for_nesting(expression):
    start_brackets_positions = []
    end_brackets_positions = []
    index = 0
    while index < len(expression):
        if expression[index] == '[':
            start_brackets_positions.append(index)
        else:
            end_brackets_positions.append(index)
        index += 1
    end_brackets_positions.reverse()
    match_count = 0
    j = 0
    total_end_brackets = len(end_brackets_positions)
    for open_pos in start_brackets_positions:
        if j < total_end_brackets and open_pos < end_brackets_positions[j]:
            match_count += 1
            j += 1
    return match_count >= 2

import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "[]",
        "[[]]",
        "[][]",
        "[[[]]]",
        "[[[[[]]]]]",
        "][",
        "[]][[]",
        "[[]][][[]]",
        "[[[[[]]]]],[[[]]]",
        "[[[]]][][][[[[]]]]"
    ]

    def test_0(self):
        self.assertEqual(is_nested(self.test_cases[0]), check_for_nesting(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(is_nested(self.test_cases[1]), check_for_nesting(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(is_nested(self.test_cases[2]), check_for_nesting(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(is_nested(self.test_cases[3]), check_for_nesting(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(is_nested(self.test_cases[4]), check_for_nesting(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(is_nested(self.test_cases[5]), check_for_nesting(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(is_nested(self.test_cases[6]), check_for_nesting(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(is_nested(self.test_cases[7]), check_for_nesting(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(is_nested(self.test_cases[8]), check_for_nesting(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(is_nested(self.test_cases[9]), check_for_nesting(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()