def check_dict_case(dict):
    if len(dict.keys()) == 0:
        return False
    else:
        state = "start"
        for key in dict.keys():

            if isinstance(key, str) == False:
                state = "mixed"
                break
            if state == "start":
                if key.isupper():
                    state = "upper"
                elif key.islower():
                    state = "lower"
                else:
                    break
            elif (state == "upper" and not key.isupper()) or (state == "lower" and not key.islower()):
                    state = "mixed"
                    break
            else:
                break
        return state == "upper" or state == "lower" 

def evaluate_dictionary_keys_casing(input_dict):
    if not input_dict:
        return False

    casing_state = None
    for key in input_dict:
        if not isinstance(key, str):
            return False

        if casing_state is None:
            if key.isupper():
                casing_state = 'UPPER'
            elif key.islower():
                casing_state = 'LOWER'
            else:
                return False
        else:
            if (casing_state == 'UPPER' and not key.isupper()) or (casing_state == 'LOWER' and not key.islower()):
                return False

    return casing_state in ['UPPER', 'LOWER']

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        ({}, False),
        ({"A": 1, "B": 2, "C": 3}, True),
        ({"a": 1, "b": 2, "c": 3}, True),
        ({"A": 1, "b": 2, "C": 3}, False),
        ({"1": 1, "2": 2, "3": 3}, False),
        ({"A": 1, 2: "B", "C": 3}, False),
        ({"a": 1, "b": 2, "c": 3, "d": 4, "e": 5}, True),
        ({"HELLO": 1, "WORLD": 2}, True),
        ({"hello": 1, "world": 2}, True),
        ({"Mixed": 1, "CASE": 2}, False)
    ]

    def test_0(self):
        self.assertEqual(check_dict_case(self.test_cases[0][0]), evaluate_dictionary_keys_casing(self.test_cases[0][0]))
    
    def test_1(self):
        self.assertEqual(check_dict_case(self.test_cases[1][0]), evaluate_dictionary_keys_casing(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(check_dict_case(self.test_cases[2][0]), evaluate_dictionary_keys_casing(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(check_dict_case(self.test_cases[3][0]), evaluate_dictionary_keys_casing(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(check_dict_case(self.test_cases[4][0]), evaluate_dictionary_keys_casing(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(check_dict_case(self.test_cases[5][0]), evaluate_dictionary_keys_casing(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(check_dict_case(self.test_cases[6][0]), evaluate_dictionary_keys_casing(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(check_dict_case(self.test_cases[7][0]), evaluate_dictionary_keys_casing(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(check_dict_case(self.test_cases[8][0]), evaluate_dictionary_keys_casing(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(check_dict_case(self.test_cases[9][0]), evaluate_dictionary_keys_casing(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()