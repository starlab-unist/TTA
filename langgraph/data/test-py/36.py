# Source Code
def fizz_buzz(n: int):
    ns = []
    for i in range(n):
        if i % 11 == 0 or i % 13 == 0:
            ns.append(i)
    s = ''.join(list(map(str, ns)))
    ans = 0
    for c in s:
        ans += (c == '7')
    return ans

# Transformed Code (Semantically Equivalent)
def count_sevens_in_special_numbers(limit: int):
    special_numbers = []
    index = 0
    while index < limit:
        if index % 11 == 0 or index % 13 == 0:
            special_numbers.append(index)
        index += 1

    concatenated_string = ''.join(str(number) for number in special_numbers)
    seven_count = 0
    position = 0
    while position < len(concatenated_string):
        if concatenated_string[position] == '7':
            seven_count += 1
        position += 1

    return seven_count

# Test Cases
import unittest

class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        0,
        1,
        25,
        50,
        75,
        100,
        125,
        150,
        200,
        300
    ]

    def test_0(self):
        self.assertEqual(fizz_buzz(self.test_cases[0]), count_sevens_in_special_numbers(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(fizz_buzz(self.test_cases[1]), count_sevens_in_special_numbers(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(fizz_buzz(self.test_cases[2]), count_sevens_in_special_numbers(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(fizz_buzz(self.test_cases[3]), count_sevens_in_special_numbers(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(fizz_buzz(self.test_cases[4]), count_sevens_in_special_numbers(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(fizz_buzz(self.test_cases[5]), count_sevens_in_special_numbers(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(fizz_buzz(self.test_cases[6]), count_sevens_in_special_numbers(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(fizz_buzz(self.test_cases[7]), count_sevens_in_special_numbers(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(fizz_buzz(self.test_cases[8]), count_sevens_in_special_numbers(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(fizz_buzz(self.test_cases[9]), count_sevens_in_special_numbers(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()