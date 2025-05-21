# Source Code
def closest_integer(value):
    from math import floor, ceil

    if value.count('.') == 1:
        # remove trailing zeros
        while (value[-1] == '0'):
            value = value[:-1]

    num = float(value)
    if value[-2:] == '.5':
        if num > 0:
            res = ceil(num)
        else:
            res = floor(num)
    elif len(value) > 0:
        res = int(round(num))
    else:
        res = 0

    return res


# Transformed Code (Semantically Equivalent)
def nearest_whole_number(input_value):
    from math import floor, ceil

    if '.' in input_value:
        # strip trailing zeros
        while input_value.endswith('0'):
            input_value = input_value[:-1]

    number = float(input_value)
    if input_value.endswith('.5'):
        result = ceil(number) if number > 0 else floor(number)
    elif input_value:
        result = int(round(number))
    else:
        result = 0

    return result


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        "4.5",
        "-2.5",
        "3.7",
        "-1.2",
        "0.0",
        "5.000",
        "6.99",
        "-3.01",
        ".5",
        "-.5"
    ]

    def test_0(self):
        self.assertEqual(closest_integer(self.test_cases[0]), nearest_whole_number(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(closest_integer(self.test_cases[1]), nearest_whole_number(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(closest_integer(self.test_cases[2]), nearest_whole_number(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(closest_integer(self.test_cases[3]), nearest_whole_number(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(closest_integer(self.test_cases[4]), nearest_whole_number(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(closest_integer(self.test_cases[5]), nearest_whole_number(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(closest_integer(self.test_cases[6]), nearest_whole_number(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(closest_integer(self.test_cases[7]), nearest_whole_number(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(closest_integer(self.test_cases[8]), nearest_whole_number(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(closest_integer(self.test_cases[9]), nearest_whole_number(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()