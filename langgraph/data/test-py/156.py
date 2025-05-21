def int_to_mini_roman(number):
    num = [1, 4, 5, 9, 10, 40, 50, 90,  
           100, 400, 500, 900, 1000] 
    sym = ["I", "IV", "V", "IX", "X", "XL",  
           "L", "XC", "C", "CD", "D", "CM", "M"] 
    i = 12
    res = ''
    while number: 
        div = number // num[i] 
        number %= num[i] 
        while div: 
            res += sym[i] 
            div -= 1
        i -= 1
    return res.lower()

def convert_integer_to_minimal_roman(value):
    numeral_values = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    roman_symbols = ["I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"]
    index = len(numeral_values) - 1
    result = ""
    while value > 0:
        quotient = value // numeral_values[index]
        value %= numeral_values[index]
        while quotient > 0:
            result += roman_symbols[index]
            quotient -= 1
        index -= 1
    return result.lower()

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        (1, "i"),
        (4, "iv"),
        (9, "ix"),
        (58, "lviii"),
        (1994, "mcmxciv"),
        (3999, "mmmcmxcix"),
        (1000, "m"),
        (500, "d"),
        (100, "c"),
        (10, "x")
    ]

    def test_0(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[0][0]), convert_integer_to_minimal_roman(self.test_cases[0][0]))

    def test_1(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[1][0]), convert_integer_to_minimal_roman(self.test_cases[1][0]))
        
    def test_2(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[2][0]), convert_integer_to_minimal_roman(self.test_cases[2][0]))
    
    def test_3(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[3][0]), convert_integer_to_minimal_roman(self.test_cases[3][0]))
    
    def test_4(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[4][0]), convert_integer_to_minimal_roman(self.test_cases[4][0]))
        
    def test_5(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[5][0]), convert_integer_to_minimal_roman(self.test_cases[5][0]))
    
    def test_6(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[6][0]), convert_integer_to_minimal_roman(self.test_cases[6][0]))
    
    def test_7(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[7][0]), convert_integer_to_minimal_roman(self.test_cases[7][0]))
    
    def test_8(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[8][0]), convert_integer_to_minimal_roman(self.test_cases[8][0]))
    
    def test_9(self):
        self.assertEqual(int_to_mini_roman(self.test_cases[9][0]), convert_integer_to_minimal_roman(self.test_cases[9][0]))

if __name__ == '__main__':
    unittest.main()